#!/bin/bash

gradle clean build -x test --no-daemon
java -jar build/libs/metroCardSystem.jar sample_input/input1.txt