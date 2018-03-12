#------------------------------------------------------------------------------
# Makefile with macros for FileReverse.c
# # #Wilson Au-Yeung
# # #wwauyeun
# # #CMPS12M
# # #April 17 ,2016
# # #This Makefile allows me to create and archive FileReverse.c and creates a executable jar file FileReverse that allows me to run the main function from FileReverse.o. Making a jar file allows me to run it and take in the input text file and paste whatever I want into the output text. And lastly, it allows me to clean up class and jar files and submit.
#
#------------------------------------------------------------------------------

FLAGS = -std=c99 -Wall
SOURCES = FileReverse.c
CSOURCES = Makefile README $(SOURCES)
OBJECTS = FileReverse.o
EXEBIN = FileReverse
SUBMIT = submit cmps012b-pt.s16 lab3
all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm $(EXEBIN) $(OBJECTS) out
submit : $(CSOURCES)
	 $(SUBMIT) $(CSOURCES)

check :
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/lab3/wwauyeun
	
