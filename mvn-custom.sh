#!/bin/sh
set -e

mvn clean && mvn validate && mvn compile && mvn compile && mvn test && mvn package -Dmaven.test.skip

echo ------------------------------------------------------------------------------------------------------

source text_input.txt
cd ./target
echo -ne "${PARAM_ONE}\n${OPERATION}\n${PARAM_TWO}" | java -jar CalculatorJenkins-1.0-SNAPSHOT-jar-with-dependencies.jar
cd ..

echo ------------------------------------------------------------------------------------------------------

mvn verify
#show tests

echo SCRIPT HAS BEEN SUCCESSFULLY EXECUTED!
