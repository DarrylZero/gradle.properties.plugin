#!/usr/bin/env bash

echo "Building ......"
gradle build sonarqube -Dsonar.host.url=https://sonarcloud.io -Dsonar.organization=$1 -Dsonar.login=$2
