#!/usr/bin/env bash

echo "Building ......"
gradle build sonarqube -Psonar.host.url=https://sonarcloud.io -Psonar.organization=$1 -Dsonar.login=$2
