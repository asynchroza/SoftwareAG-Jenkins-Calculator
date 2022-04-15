#!/bin/bash
mvn clean && mvn validate && mvn compile && mvn compile -Dmaven.test.skip && mvn package -Dmaven.test.skip
echo ------------------------------------------------------------------------------------------------------
./read_text.sh
echo ------------------------------------------------------------------------------------------------------
mvn verify
echo SCRIPT HAS BEEN EXECUTED!
