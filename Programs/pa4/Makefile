#makefile for CMPS 12B pa4
#  Wilson Au-Yeung
#  wwauyeun
#  May 14,2016
#   CMPS12B
#  This Makefile allows me to create and archive all of the .java files I have on this Programming assignment and creates an executable jar Simulation which allows me to run the main function in Simulation.class. And lastly, it allows me to clean up all the class files and allows me to submit all in one Makefile
# -----------------------------------------------------------

JAVAC      = javac
MAINCLASS  = Simulation
JAVASRC    = $(wildcard *.java)
SOURCES    = $(JAVASRC) Makefile README
CLASSES    = $(patsubst %.java, %.class, $(JAVASRC))
JARCLASSES = $(patsubst %.class, %*.class, $(CLASSES))
JARFILE    = $(MAINCLASS)
SUBMIT = submit cmps012b-pt.s16 pa4

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(JARCLASSES)
	chmod +x $(JARFILE)
	rm Manifest

%.class: %.java
	$(JAVAC) $<

clean:
	rm *.class $(JARFILE)

submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)
check:
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/pa4/wwauyeun
