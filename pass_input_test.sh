#!/bin/bash
cd ./target
echo -ne "${1}\n${2}\n${3}" | java -jar CalculatorJenkins-1.0-SNAPSHOT-jar-with-dependencies.jar
cd ..
mvn test
