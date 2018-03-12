#makefile for CMPS 12B pa3
#  Wilson Au-Yeung
#  wwauyeun
#  April 26,2016
#  CMPS12B
#  This Makefile allows me to create and archive all of the .java files I have on this Programming assignment and creates an executable jar DictionaryClient which allows me to run the main function in DictionaryClient.class. And lastly, it allows me to clean up all the class files and allows me to submit all in one Makefile
#  #------------------------------------------------------------------------------

JAVAC      = javac 
MAINCLASS  = DictionaryClient
JAVASRC    = $(wildcard *.java)
SOURCES    = $(JAVASRC) Makefile README
CLASSES    = $(patsubst %.java, %.class, $(JAVASRC))
JARCLASSES = $(patsubst %.class, %*.class, $(CLASSES))
JARFILE    = $(MAINCLASS) 
SUBMIT	   = submit cmps012b-pt.s16 pa3

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(JARCLASSES)
	chmod +x $(JARFILE)
	rm Manifest

%.class: %.java
	$(JAVAC) $<

clean:
	rm -f *.class $(JARFILE)
check: 
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/pa3/wwauyeun

submit:	$(SOURCES)
	$(SUBMIT) $(SOURCES)
