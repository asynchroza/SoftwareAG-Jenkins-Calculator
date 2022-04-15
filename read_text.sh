#!/bin/bash
source text_input.txt
cd ./target
echo -ne "${PARAM_ONE}\n${OPERATION}\n${PARAM_TWO}" | java -jar CalculatorJenkins-1.0-SNAPSHOT-jar-with-dependencies.jar
cd ..
mvn test
