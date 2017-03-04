JFLAGS_DEBUG = -g
JFLAGS_TEST = -d ./
JC = javac
J = java
RM = rm
JUNITTEST_FILES = $(wildcard JUnitTests/*.java)
JUNITTEST_RUNNER = NerdGameTestRunner
NERDGAME_FILES = $(wildcard *.java);
NERDGAME = NerdGame
ALL_CLASSES = *.class

default: run

all:
	$(JC) $(NERDGAME_FILES)

run: all
	$(J) $(NERDGAME)
	$(RM) $(ALL_CLASSES)

debug:
	$(JC) $(JFLAGS_DEBUG) $(NERDGAME_FILES)

rundebug: debug
	$(J) $(NERDGAME)
	$(RM) $(ALL_CLASSES)

test: debug
	$(JC) $(JFLAGS_TEST) $(JUNITTEST_FILES)

runtest: test
	$(J) $(JUNITTEST_RUNNER)
	$(RM) $(ALL_CLASSES)

clean:
	$(RM) $(ALL_CLASSES)
