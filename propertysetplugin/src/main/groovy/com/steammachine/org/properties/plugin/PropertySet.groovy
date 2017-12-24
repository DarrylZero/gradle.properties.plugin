package com.steammachine.org.properties.plugin

import org.gradle.api.Project
import org.gradle.util.ConfigureUtil

/**
 * Created by Vladimir Bogodukhov on 16.12.2017.
 *
 * @author Vladimir Bogodukhov
 *
 * {@link com.steammachine.org.properties.plugin.PropertySet}
 *        com.steammachine.org.properties.plugin.PropertySet
 *
 */
class PropertySet {

    final Map<String, String> items = [:]
    final Project project;

    PropertySet(Project project) {
        this.project = Objects.requireNonNull(project)
    }


    static PropertySet create(Project project, String propname) {
        project.extensions.create(propname, PropertySet, project)
    }

    /**
     *
     * Adds property file content
     * @param - files
     */
    void setPropertyFiles(File... files) {
        files.each {
            new FileInputStream(it).withCloseable {
                def properties = new Properties()
                properties.load(it)
                properties.each { prop -> items.put(prop.key as String, prop.value as String) }
            }
        }
    }

    /**
     *
     * Adds property file content
     * @param - files
     */
    void setPropertyFile(File file) {
        setPropertyFiles(file)
    }

    /**
     * Creates a new set
     * @param name
     * @param config
     */
    void set(String name, Closure<PropertySet> config) {
        def newSet = create(project, name)
        ConfigureUtil.configureUsing(config).execute(newSet)
    }

    def propertyMissing(String name) {
        items[name]
    }




}
