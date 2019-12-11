FROM maven:3.6-jdk-8

WORKDIR /src/usr/app/

COPY . .

CMD mvn clean install
CMD mvn test -DdefaultSuiteFiles="testng.xml"
