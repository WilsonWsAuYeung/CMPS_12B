// Wilson Au-Yeung
// wwauyeun
// May 14,2016
// CMPS12B
// Simulates the Queue.java and Job.java ADT
import java.io.*;
import java.util.Scanner;

public class Simulation {
  public static Job getJob(Scanner in) {
    String[] s = in.nextLine().split(" ");
    int a = Integer.parseInt(s[0]);
    int d = Integer.parseInt(s[1]);
    return new Job(a, d);
  }
  public static void main(String[] args) throws IOException {
    if (args[0] != null) {
      boolean none = true;
      File in = new File(args[0]);
      Scanner scan = new Scanner(in);
      PrintWriter report = new PrintWriter(new FileWriter(args[0] + ".rpt"));
      PrintWriter trace = new PrintWriter(new PrintWriter(args[0] + ".trc"));
      String NxtStr = scan.nextLine();
      int num = Integer.parseInt(NxtStr);
      Queue storage = new Queue();
      for (int i = 0; i < num; ++i) {
        storage.enqueue((Job)getJob(scan));
      }
      Queue backup = backup(storage, num);
      Queue[] processor = new Queue[num + 1];
      for (int j = 1; j <= num; ++j) {
        processor[j] = new Queue();
      }
      scan.close();
      report.println("Report file: " + args[0] + ".rpt");
      report.println(num + " Jobs:");
      report.println(storage);
      report.println();
      for (int j = 0; j < 50; j++) {
        report.print("*");
      }
      report.println();
      trace.println("Trace file:" + args[0] + ".trc ");
      trace.println(num + " Jobs:"
                    + "\n" + storage);

      for (int i = 1; i < num; ++i) {
        if (i == 1) {
          report.print(i + " processor:");
        } else {
          report.print(i + " processors:");
        }
        trace.println();
        for (int j = 0; j < 30; ++j) {
          trace.print("*");
        }
        trace.println();
        if (i == 1) {
          trace.println(i + " processor:");
        } else {
          trace.println(i + " processors:");
        }
        for (int j = 0; j < 30; ++j)
          trace.print("*");
        trace.println("\n time=0");
        trace.println("0: " + storage);
        for (int j = 1; j <= i; ++j) {
          trace.println(j + ": " + processor[j]);
        }
        int TIME = 0;
        int left = num;
        while (left != 0) {
          boolean boolF = false;
          while (newProcess(storage, processor, TIME, i)) {
            boolF = true;
          }
          while (finishProcess(storage, processor, TIME, i)) {
            boolF = true;
            left--;
          }
          if (boolF) {
            trace.println("time=" + TIME);
            trace.println("0: " + storage);
            for (int j = 1; j <= i; ++j) {
              trace.println(j + ": " + processor[j]);
            }
          }
          TIME++;
        }
        int TOTAL_WAIT_TIME = ComputeTotalWait(storage, num);
        int MAX_WAIT_TIME = ComputeMaxWait(storage, num);
        reset(backup, storage, num);
        report.printf("totalWait=%d, maxWait=%d, averageWait=%.2f %n",
                      TOTAL_WAIT_TIME, MAX_WAIT_TIME,
                      (float)TOTAL_WAIT_TIME / num);
      }
      if (none) {
        trace.close();
        report.close();
      }
    }
  }

  static boolean finishProcess(Queue storage, Queue[] process, int time,
                               int num) {
    boolean ans = false;
    for (int i = 1; i <= num; ++i) {
      if (process[i].isEmpty())
        continue;
      else {
        if (((Job)process[i].peek()).getFinish() == time) {
          storage.enqueue(process[i].dequeue());
          if (!process[i].isEmpty())
            ((Job)process[i].peek()).computeFinishTime(time);
          { return true; }
        }
      }
    }
    return ans;
  }

  static int ComputeTotalWait(Queue storage, int m) {
    int WAIT_TIME = 0;
    for (int i = 0; i < m; ++i) {
      Job present = (Job)storage.dequeue();
      WAIT_TIME += present.getWaitTime();
      storage.enqueue(present);
    }
    return WAIT_TIME;
  }
  static boolean newProcess(Queue storage, Queue[] process, int time, int num) {
    boolean k = false;
    if (!storage.isEmpty()) {
      if (((Job)storage.peek()).getArrival() == time) {
        Job tmp = ((Job)storage.dequeue());
        int actu = nextProcessor(process, num);
        process[actu].enqueue(tmp);
        if (((Job)process[actu].peek()).getFinish() == Job.UNDEF)
          ((Job)process[actu].peek()).computeFinishTime(time);
        return !k;
      }
    }
    return k;
  }

  static int nextProcessor(Queue[] processor, int num) {
    int next = 1;
    for (int i = 1; i <= num; ++i) {
      if (processor[i].length() < processor[next].length())
        next = i;
    }
    return next;
  }

  static Queue backup(Queue storage, int m) {
    Queue ama = new Queue();
    for (int i = 0; i < m; ++i) {
      Job present = (Job)storage.dequeue();
      ama.enqueue(present);
      storage.enqueue(present);
    }
    return ama;
  }

  static int ComputeMaxWait(Queue storage, int m) {
    int WAIT_TIME = 0;
    for (int i = 0; i < m; ++i) {
      Job present = (Job)storage.dequeue();
      if (present.getWaitTime() > WAIT_TIME) {
        WAIT_TIME = present.getWaitTime();
      }
      storage.enqueue(present);
    }
    return WAIT_TIME;
  }

  static void reset(Queue backup, Queue storage, int m) {
    if (!storage.isEmpty())
      storage.dequeueAll();
    for (int i = 0; i < m; ++i) {
      Job present = (Job)backup.dequeue();
      present.resetFinishTime();
      storage.enqueue(present);
      backup.enqueue(present);
    }
  }
}
