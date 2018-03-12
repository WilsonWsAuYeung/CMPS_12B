# wwauyeun
# # CMPS12M
# # May 7,2016
# # This Makefile allows me to create and archive Dictionary.c and DictionaryClient and creates a executable jar file DictionaryClient which holds the main function that allows me to run the main function from DictionaryClient.o. It allows me to clean up the class and jar files and submit. I make a check function to allows me to check my submission and to check if there are any leaks in the program.
# #------------------------------------------------------------------------------
FLAGS   = -std=c99 -Wall
SOURCES = DictionaryClient.c Dictionary.c DictionaryTest.c
CSOURCES = Makefile README $(SOURCES) $(HEADERS)
OBJECTS = DictionaryClient.o Dictionary.o
HEADERS = Dictionary.h
SUBMIT = submit cmps012b-pt.s16 lab5
EXEBIN  = DictionaryClient

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS) $(HEADERS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES) $(HEADERS)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

check:
	valgrind --leak-check=full $(EXEBIN) 
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/lab5/wwauyeun
submit: $(CSOURCES)
	$(SUBMIT) $(CSOURCES)
