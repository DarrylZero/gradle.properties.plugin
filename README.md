# UNDER CONSTRUCTION
# properties gradle plugin
# gradle.resource.copy.plugin
gradle copy resources plugin   ![Build Status](https://travis-ci.org/DarrylZero/gradle.resource.copy.plugin.svg?branch=development)

_Simlpe plugin to manage property files_



Content of property files is imported into property object which, in turn, becomes 
available as properties of string type


`Application`: 
To add plugin dependency do the following :
```groovy
buildscript {
    repositories {
        maven { url "https://clojars.org/repo" }
    }

    dependencies {
        classpath 'com.steammachine.org:gradle.plugins:0.9.3'
    }
}
```


`Enabling`: To enable plugin add line to your gradle script 
```groovy
apply plugin: 'com.steammachine.org.gradle.properties.plugins'
```


When plugin is applied the following properties are added to project:

- auxprops - using this property you can load content of property file (that goes with extension _.properties_)

Content of properties file properties.properties
```properties
address=United Kingdom. London. Baker street 221B.
```

```groovy
auxprops.propertyFile file('prop.properties')
```


Below that line in your script you can refer to that property via auxprops property

```groovy
def somedata = auxprops.address
```

There is also another way to add properties to the project object of the gradle script

```groovy
auxprops.set('another_properties') {
    propertyFile file('properties.properties')
} 
```

After the properties are loaded it is possible to use it as a part of project property (in example case another_properties)

```groovy
def addressofwatson = another_properties.address
```

