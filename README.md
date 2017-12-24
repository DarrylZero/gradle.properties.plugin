# properties gradle plugin

# UNDER CONSTRUCTION

Simlpe plugin to manage property files

property files are imported into property object which, in turn, becomes 
available as string properties of field


**_apply plugin: 'com.steammachine.org.gradle.properties.plugins'_**


auxprops <--- property added by plugin

auxprops.propertyFile file('prop.properties')


version = auxprops.version 

auxprops.version -> a string property that is kept in prop.properties file
 


