#!/bin/bash
echo "Publishing jar files ..."

gradle :propertysetplugin:publish -Prepo_user=$1 -Prepo_password=$2


