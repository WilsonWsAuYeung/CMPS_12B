#------------------------------------------------------------------------------
# Makefile for charType.c
# Wilson Au-Yeung
# wwauyeun
# CMPS12M
# April 29,2016
# This Makefile allows me to create and archive charType.c and creates a executable jar file charType that allows me to run the main function from charType.o Making a jar file allows me to run and take the input text from the input file and paste what I need into the output text. It allows me to clean up the class and jar files and submit. I make a check function to allow me to check my submission and to check if there are any leaks in the program.
#------------------------------------------------------------------------------

FLAGS = -std=c99 -Wall
SOURCES = charType.c
CSOURCES = Makefile README $(SOURCES)
OBJECTS = charType.o
SUBMIT = submit cmps012b-pt.s16 lab4
EXEBIN = charType

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
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/lab4/wwauyeun
	valgrind --leak-check=full charType in out	
