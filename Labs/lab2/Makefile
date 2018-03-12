# Makefile with macros
# #Wilson Au-Yeung
# #wwauyeun
# #CMPS12M
# #April 11 ,2016
# #This Makefile allows me to create and archive FileReverse.java and creates a executable jar file FileReverse that allows me to run the main function from FileReverse.class. Making a jar file allows me to run it and take in the input text file and paste whatever I want into the output text. And lastly, it allows me to clean up class and jar files and submit.

JAVASRC = FileReverse.java
SOURCES = Makefile README $(JAVASRC)
MAINCLASS = FileReverse
CLASSES = FileReverse.class
JARFILE = FileReverse
SUBMIT = submit cmps012b-pt.s16 lab2
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
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/lab2/wwauyeun
