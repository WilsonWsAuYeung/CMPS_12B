# Makefile with macros
#Wilson Au-Yeung
#wwauyeun
#CMPS12M
#March 29,2016
#This Makefile allows me to create and archive both HelloUser.java HelloUser2.java and creates a executable jar file Hello that allows me to run the main function from HelloUser2.class. And lastly, it allows me to clean up class and jar files and submit.
JAVASRC = HelloUser.java HelloUser2.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = HelloUser2
CLASSES = HelloUser.class HelloUser2.class
JARFILE = Hello
SUBMIT = submit cmps012b-pt.s16 lab1
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
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/lab1/wwauyeun
