#Wilson Au-Yeung
#wwauyeun
#CMPS12B
#April 15,2016
#This Makefile allows me to create and archive both Search.java and creates a executable jar Recursion Search that allows me to run the main function from Search.class. And lastly, it allows me to clean up class and jar files and submit.
JAVASRC = Search.java
SOURCES = Makefile README $(JAVASRC)
MAINCLASS = Search
CLASSES = Search.class
JARFILE = Search
SUBMIT = submit cmps012b-pt.s16 pa2
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
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/pa2/wwauyeun
