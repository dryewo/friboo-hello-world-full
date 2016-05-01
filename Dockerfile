FROM registry.opensource.zalan.do/stups/openjdk:8u66-b17-1-12
COPY target/friboo-hello-world-full.jar /app.jar
COPY target/scm-source.json /scm-source.json
CMD java $JAVA_OPTS -jar /app.jar
