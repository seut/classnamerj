====================================================
 Classnamerj - A Java implementation of classnamer.
====================================================

This is a Java implementation of the classnamer, more famous as it's
web-service: http://classnamer.com.
Original implementation (Ruby) can be found here https://github.com/ab9/classnamer.

It's randomly generates tongue-in-check class names suitable for
enterprise-friendly object-oriented languages like C++ or Java. It
includes a library and a command-line program.

A working Java_  >= 1.7 installation is required to run the
command-line program.

Running the command-line program
================================

At first, classnamerj needs to be build(compiled) before it can be
run locally. This can be done using gradle::

  ./gradlew install

Afterwards, running the classnamerj executable will give you your
long desired classname::

  ./bin/classnamerj


Using the library
=================

The library is quit simple and just ships a ``Classnamer`` class with
3 static public methods:

 - generate()
   This using the build-in matrix as string resources and uses the
   default Java random class for randomess.

 - generate(String[][] matrix)
   By using this, one can provide a custom matrix as string resources.
   This matrix must consists of at least 3 elements, first one is used
   for the first name in the class and so on.

 - generate(String[][] matrix, Random random)
   Same as above besides a custom Random implementation can be given.


Example Usage
-------------

::

   import net.rtme.Classnamer;
   String generatedClassname = Classnamer.generate();

Why?
====

Why not? :-)
Honestly, I wanted to use the classnamer.com functionality offline in
another project.


Credits
=======

All credits go to the author of the original classname code, Aaron
Beckerman, I've just ported it to Java_.


License
=======

This code is distributed under the MIT License (also known as the
Expat License). See the LICENSE.txt file for details.

.. _Java: http://www.java.com/
