IDIR=../include
CC=gcc
CFLAGS=-I$(IDIR)

ODIR=obj
LDIR=../lib

_OBJ=Main.o SymmetricTree.o
OBJ=$(patsubst %,$(ODIR)/%,$(_OBJ))

$(ODIR)/%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

Main: $(OBJ)
	gcc -o $@ $^ $(CFLAGS)

.PHONY: clean

clean: 
	rm -f $(ODIR)/*.o *~ core $(INCDIR)/*~
