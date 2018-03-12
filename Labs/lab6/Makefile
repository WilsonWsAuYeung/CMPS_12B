#------------------------------------------------------------------------------
#   Makefile for List ADT
#------------------------------------------------------------------------------

# Variables
JARFILE    = ListClient
MAINCLASS  = ListClient
SOURCES    = List.java ListInterface.java ListClient.java ListTest.java\
             ListIndexOutOfBoundsException.java
CSOURCES   = Makefile README $(SOURCES)
CLASSES    = List.class ListInterface.class ListTest.class ListClient.class List\$$Node.class\
             ListIndexOutOfBoundsException.class
SUBMIT     = submit cmps012b-pt.s16 lab6
# Build Targets
all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)

$(CLASSES): $(SOURCES)
	javac -Xlint $(SOURCES)

clean:
	rm -f $(CLASSES) $(JARFILE)

check:
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/lab6/wwauyeun

submit: $(CSOURCES)
	$(SUBMIT) $(CSOURCES)
