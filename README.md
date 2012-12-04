SpringJeeHelloWorld
===================

The purpose of the project is to serve as a playground for testing out
JBoss and Spring technologies.  It started as a way to research the JEE 6
ejb embedded in war approach with a little Groovy sprinkled in.  Since
inception other pieces have been added in (Twitter Bootstrap, JPA, etc).

A secondary purpose of the project was to utilize Intellij IDEA project
builder to track to a gradle project.  So far the best method to keep these
in sync is to use gradle's ideaModule task.  Intellij's gradle support itself
is not quite up to par for syncing with gradle dependancies.  Either way the
.idea projects are up to date and have artifacts that correspond to the gradle
sub-projects.

Building
--------
Gradle files are provided for command line build.  Idea project files contain enough
information to build and deploy to JBoss 7.1 standalone.  I haven't attempted a
similar setup in Eclipse, but would like to see that added.

(2012-12-04) Managing the Intellij / Gradle projects is a bit trickier across machines.  I have two laptops
(1 windows 7 and 1 OSX) and I try to check that the idea files work on both machines.
Unfortunately the .idea files reference the gradle artifacts with specific path info (which
means they become machine specific).  This has caused me to need maintain separate idea projects
for each machine. boo.

Database
--------
An export of a Postgresql database is included under the jpa/data directory to jumpstart
the JPA code.  Its a simple text export and should be importable to any Postresql 9.1
or greater server.

Cache
-----
Added in a trivial use of JBoss Infinispan to hold the user list.  The caused update to the standalone-full.xml.

Spring Security
---------------
Added Spring Security into the app.  Users are defined directly in the applicationContext.xml.  Spring config has
commented entries to log in using https.  My setup uses Apache httpd SSL with mod_jk which would be outside of the
scope of this project, but you can simply uncomment the 3 'intercept-url' entries and comment the corresponding
unsecured entries to test this out.

Spring Data JPA
---------------
Added Spring Data for JPA.  Intellij has pretty good support for type ahead combining Spring JPA finders with
entity properties to form your finder method names.
