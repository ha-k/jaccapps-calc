# FILE. . . . . /home/hak/hlt/src/hlt/language/jaccapps/calc/Makefile
# EDIT BY . . . Hassan Ait-Kaci
# ON MACHINE. . Hp-Dv7
# STARTED ON. . Fri Oct 12 00:26:29 2012

# Last modified on Mon Mar 26 08:21:15 2018 by hak

########################################################################

APPLICATION	= Calculator

########################################################################

HOME		= D:/hak
# WIN_HOME is defined as an environment var in .profile as /cygdrive/d
WIN_HOME	= ${HOME}
HLT_HOME	= ${WIN_HOME}/hlt

HLT_CLASSES	= ${HLT_HOME}/classes
JDOM_CLASSES	= ${HLT_CLASSES}/jdom.jar

# OBJENESIS	= objenesis-1.2
# CLONING	= cloning-1.8.1
# OBJENESISJAR	= ${HOME}/java/cloning/${OBJENESIS}-bin/${OBJENESIS}/${OBJENESIS}.jar
# CLONINGJAR	= ${HOME}/java/cloning/${CLONING}-dist/${CLONING}/${CLONING}.jar
# CLONINGPATH	= ${CLONINGJAR};${OBJENESISJAR}

SHARED_CLASSES	= ${HLT_CLASSES};${JDOM_CLASSES}#;${CLONINGPATH}

RESOURCES	= ${HLT_CLASSES}/resources
LOCAL_CLASSES	= ./classes
SOURCES		= ./sources
DOCS		= ./docs
EXAMPLES	= ./examples
CLASSPATH	= ${LOCAL_CLASSES};${SHARED_CLASSES}

TRASH	= ,* ,.* *~ @*@ .*~ */,* */,.* */*~ */@*@ */.*~

JAVAC	= @javac -O -d "${LOCAL_CLASSES}" -classpath "${CLASSPATH}" -Xlint:deprecation #-Xlint:unchecked
JAVA	= @java -classpath "${CLASSPATH}"
JACC	= ${JAVA} hlt.language.syntax.Jacc
LOG	= ${JACC} -n -v4
DOC	= ${JACC} -doc

MK	= @make
ND	= @mkdir -p
CP	= @cp -f
CD	= @cd
LS	= @ls
MV	= @mv -f
RM	= @rm -rf
SAY	= @echo "***"

HL_OPS	= -! -con "${RESOURCES}/Hilite.Configuration" # -p jacc.${APPLICATION}
HL	= @hl ${HL_OPS}

DOCDIR  = ${DOCS}/${APPLICATION}Doc
IMAGES	= ${DOCDIR}/images

########################################################################

help:
	@${SAY}
	@${SAY} "This makefile manages the ${APPLICATION} Jacc application."
	@${SAY} "You can 'make ...' where '...' is one of:"
	@${SAY}
	@${SAY} "    all:      same as 'basic ; run'"
	@${SAY} "    basic:    same as 'gen ; classes'"
	@${SAY} "    full:     same as 'basic ; doc ; log ; run'"
	@${SAY} "    partial:  to run the ${APPLICATION} application"
	@${SAY}
	@${SAY} "where:"
	@${SAY}
	@${SAY} "    gen:      generates the ${APPLICATION} parser"
	@${SAY} "    classes:  compiles the java source files"
	@${SAY} "    run:      runs the ${APPLICATION} application"
	@${SAY} "    doc:      generates the ${APPLICATION} documentation"
	@${SAY} "    log:      generates a grammar analysis log file"
	@${SAY} "    clean:    erases regeneratable files"
	@${SAY} "    help:     prints this message"
	@${SAY}

########################################################################

all:	basic run
basic:	gen classes
full:	basic doc log run

########################################################################

gen: tidy ${SOURCES}/${APPLICATION}.grm
	${SAY} Make gen:
	${SAY} Generating the ${APPLICATION} parser...
	${JACC} -base ${SOURCES} \
                -dest ${SOURCES} \
                -p ${APPLICATION}Parser \
                ${SOURCES}/${APPLICATION}.grm

########################################################################

classes: tidy
	${SAY} Make classes:
	${SAY} Compiling java files...
	${JAVAC} ${SOURCES}/*.java
	${SAY} Wrote class files in ${LOCAL_CLASSES}/

########################################################################

run:
	${CD} ${LOCAL_CLASSES} 
	${SAY} Running ${APPLICATION} - type "'exit;'" to quit
	${JAVA} ${APPLICATION}Main
	${CD} ..

########################################################################

partial:
	${CD} ${LOCAL_CLASSES} 
	${SAY} Running Partial${APPLICATION}
	${JAVA} Partial${APPLICATION}
	${CD} ..

########################################################################

doc: rmdoc hyper hl

########################################################################

rmdoc:
	${SAY} Make rmdoc:
	${SAY} Removing old ${DOCDIR} documentation ...
	${RM} ${DOCDIR}

########################################################################

hyper: rmdoc tidy
	${SAY} Make hyper:
	${SAY} Generating the ${APPLICATION} grammar hyperdocumentation ...
	${JACC} -doc -base ${SOURCES} ${SOURCES}/${APPLICATION}.grm
	${MV} ${APPLICATION}Doc ${DOCS}/
	${MK} images
	${MV} ${DOCDIR}/index.html ${DOCDIR}/000StartHere.html
	${SAY} Visit ${DOCDIR}/000StartHere.html to navigate the grammar documentation

########################################################################

images:
	${SAY} Make images:
	${SAY} Copying image files ...
	${ND} ${IMAGES}
	${ND} ${IMAGES}/hlt
	${ND} ${IMAGES}/arrows
	${ND} ${IMAGES}/arrows/misc/
	${CP} ${RESOURCES}/images/hlt/*.gif ${IMAGES}/hlt/
	${CP} ${RESOURCES}/images/arrows/misc/*.gif ${IMAGES}/arrows/misc/

########################################################################

hl: tidy
	${SAY} Make hl:
	${SAY} Hiliting HTML for Java and Jacc sources files ...
	${HL} -d ${DOCDIR} ${SOURCES}/*.grm ${SOURCES}/*.java
	${SAY} See hilited HTML source code in ${DOCDIR}/index.html.

########################################################################

log: tidy
	${SAY} Make log:
	${SAY} Generating complete analysis log for ${SOURCES}/${APPLICATION}.grm...
	${JACC} -v 4 -n -o ${APPLICATION}.log \
                -base ${SOURCES} ${SOURCES}/${APPLICATION}
	${MV} ${APPLICATION}.log ${SOURCES}/${APPLICATION}.log
	${SAY} See grammar log in file ${SOURCES}/${APPLICATION}.log

########################################################################

clean: tidy
	${SAY} Make clean:
	${SAY} Removing the old parser Java sources...
	${RM} ${SOURCES}/${APPLICATION}Parser.java
	${SAY} Removing the old grammar analysis log...
	${RM} ${SOURCES}/${APPLICATION}.log
	${SAY} Removing the old documentation
	${RM} ${DOCDIR}

########################################################################

tidy:
	${SAY} Make tidy:
	${SAY} "Tidying up trash (if any) ..."
#	${LS} ${TRASH} 2> /dev/null ; true
	${RM} ${TRASH}

########################################################################
