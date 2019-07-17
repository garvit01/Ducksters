#!/bin/bash

cd AuthenticationService
source ./env-variable.sh
mvn clean package
#docker build -t user-app .
cd ..
cd DusckstersService
source ./env-variable.sh
mvn clean package
#docker build -t duckseters-app .
cd ..
