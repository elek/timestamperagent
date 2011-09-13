Simple javaagent which prefix the standard input and output with the current date.

Usage:
    java ... -javaagent:/path/timestamperagent.jar ....
    
With maven:

    export MAVEN_OPTS="-javaagent:/home/.../timestamperagent.jar"

example output:

mvn install

2011.09.13 22:17:49.121 [INFO] Scanning for projects...
2011.09.13 22:17:49.336 [WARNING] 
2011.09.13 22:17:49.336 [WARNING] Some problems were encountered while building the effective model for net.anzix:nona:war:1.0-SNAPSHOT
2011.09.13 22:17:49.337 [WARNING] 'reporting.plugins.plugin.version' for org.apache.maven.plugins:maven-checkstyle-plugin is missing. @ line 295, column 21
2011.09.13 22:17:49.337 [WARNING] 
2011.09.13 22:17:49.337 [WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
2011.09.13 22:17:49.338 [WARNING] 
2011.09.13 22:17:49.338 [WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
2011.09.13 22:17:49.338 [WARNING]
....