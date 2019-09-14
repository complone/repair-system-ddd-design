#!/usr/bin/env bash
#JDK所在路径
JAVA_HOME="/usr/local/jdk1.8.0_112"
nohup /usr/local/jdk1.8.0_112/bin/java -jar lib/guide-0.0.1-SNAPSHOT.jar -Dfile.encoding=utf-8 -server -XX:+UseG1GC -Xms4g -Xmx4g -XX:+PrintGC -XX:+PrintGCTimeStamps -Xloggc:gc.log nohup.log 2>&1 &
