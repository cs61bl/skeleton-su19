# Targets that don't correspond to files, but are to be treated as commands.
.PHONY: default check clean output

CPATH = "..:$(CLASSPATH):;..;$(CLASSPATH)"

default: check

check: 
	@echo "Testing correct inputs..."
	@CLASSPATH=$(CPATH) bash test-correct correct/*.inp

# 'make clean' will clean up stuff you can reconstruct.
clean:
	$(RM) *~ OUT* ERRS*
