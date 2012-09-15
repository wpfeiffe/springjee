SpringJeeHelloWorld
===================

The purpose of the project is to serve as a playground for testing out
JBoss and Spring technologies.  It started as a way to research the JEE 6
ejb embedded in war approach with a little Groovy sprinkled in.  Since
inception other pieces have been added in (Twitter Bootstrap, JPA, etc).

A secondary purpose of the project was to utilize Intellij IDEA project
builder to track to a gradle project.  So far the best method to keep these
in sync is to use gradle's ideaModule task.  Intellij's gradle support  itself
is not quite up to par for syncing with gradle dependancies.  Either way the
.idea projects are up to date and have artifacts that correspond to the gradle
sub-projects.

Building
--------
Gradle files are provided for command line build.  Idea project files contain enough
information to build and deploy to JBoss 7.1 standalone.  I haven't attempted a
similar setup in Eclipse, but would like to see that added.

Database
--------
An export of a Postgresql database is included under the jpa/data directory to jumpstart
the JPA code.  Its a simple text export and should be importable to any Postresql 9.1
or greater server.
