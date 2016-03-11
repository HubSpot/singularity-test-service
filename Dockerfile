FROM java:8

ADD ./target/singularitytest-1.0-SNAPSHOT.jar /etc/test/test.jar
ADD ./example.yml /etc/test/example.yml

CMD java -Ddw.server.connector.port=$PORT0 -jar /etc/test/test.jar server /etc/test/example.yml

