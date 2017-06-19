JEval, release 0.9.4 beta (December 2008)
http://jeval.sourceforge.net
----------------------------------------------

1. INTRODUCTION

JEval is the advanced library for adding mathematical, string, Boolean and 
functional expression parsing and evaluation to your Java applications. 

JEval Features:

* Parses and evaluates dynamic and static expressions at run time.
* A great solution for filtering data at runtime.
* Supports mathematical, Boolean, String and functional expressions.
* Supports all major mathematical and Boolean operators.
* Supports custom functions.
* 39 Math and String functions built in and ready to use.
* Supports nested functions.
* Supports variables.
* Allows for custom variable resolver.
* No reparsing of expressions when variables change.
* No dependencies to other non-standard Java libraries.
* JUnit tests.
* Compatible with J2SE 1.2 and above.

2. RELEASE INFO

JEval requires J2SE 1.2 and above.  This release was tested using J2SE 1.5.0_13 
running in Java 1.3 compatibility mode.

Release contents:
* "src" contains the Java source files for the project
* "test" contains the Java source files for the project's test suite
* "dist" contains the project distribution jar files
* "lib" contains all third-party libraries needed for running the samples and/or 
building the framework
* "docs" contains general documentation and API Javadocs
* "samples" contains demo applications

Ant build scripts for the project and the samples are provided. The standard 
samples can be built with
the included Ant runtime by invoking the corresponding "build.bat" files (see 
samples subdirectories).

Latest info is available at the public Web site: http://jeval.sourceforge.net
Project info at the SourceForge site: http://sourceforge.net/projects/jeval/

The JEval project is released under the terms of the Apache Software License 
(see license.txt). All libraries included in the "lib" directory are subject to 
their respective licenses.

3. DISTRIBUTION JAR FILES

The "dist" directory contains the following distinct jar files for use in 
applications.

* "JEval" (~68 KB)
- Contents: JEval API

4. WHERE TO START?

Documentation can be found in the "docs" directory:
* JEval Javadoc - see Evaluator class for implementation details

Documented sample applications can be found in "samples":
* Boolean operations
* Custom functions
* Looping with variables
* Mathematical functions
* Mathematical operations
* Nested functions
* String functions
* String operations
* Variables
