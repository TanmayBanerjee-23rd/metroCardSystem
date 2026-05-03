#!/bin/bash

./gradlew clean build -x test --no-daemon
java -jar build/libs/metroCardSystem.jar sample_input/input1.txt