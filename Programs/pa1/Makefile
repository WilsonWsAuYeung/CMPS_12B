#Wilson Au-Yeung
#wwauyeun
#CMPS12B
#April 4,2016
#This Makefile allows me to create and archive both Recursion.java and creates a executable jar Recursion Hello that allows me to run the main function from Recursion.class. And lastly, it allows me to clean up class and jar files and submit.
JAVASRC = Recursion.java
SOURCES = Makefile README $(JAVASRC)
MAINCLASS = Recursion
CLASSES = Recursion.class
JARFILE = Recursion
SUBMIT = submit cmps012b-pt.s16 pa1
all: $(JARFILE)
$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)
$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)
clean:
	rm $(CLASSES) $(JARFILE)
submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)
check:
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/pa1/wwauyeun
