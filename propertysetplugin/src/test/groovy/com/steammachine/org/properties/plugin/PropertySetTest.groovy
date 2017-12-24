package com.steammachine.org.properties.plugin

import org.gradle.api.internal.project.DefaultProject
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Assert
import org.junit.Test

class PropertySetTest {

    @Test
    void testNameIntegrity_PropertySet() {
        Assert.assertEquals("com.steammachine.org.properties.plugin.PropertySet", PropertySet.class.name);
    }

    @Test
    void testNameIntegrity_PropertySetPlugin() {
        Assert.assertEquals("com.steammachine.org.properties.plugin.PropertySetPlugin", PropertySetPlugin.class.name);
    }

    @Test
    void testPluginInProject() {
        DefaultProject project = (DefaultProject) ProjectBuilder.builder().build();

        Assert.assertFalse(project.hasProperty('auxprops'))
        project.pluginManager.apply(PropertySetPlugin)
        Assert.assertTrue(project.hasProperty('auxprops'))
    }



    @Test
    void testPluginInProject20() {
        DefaultProject project = (DefaultProject) ProjectBuilder.builder().build();

        Assert.assertFalse(project.hasProperty('auxprops'))
        project.pluginManager.apply(PropertySetPlugin)
        Assert.assertTrue(project.hasProperty('auxprops'))

        Assert.assertFalse(project.hasProperty('prop1'))
        Assert.assertFalse(project.hasProperty('prop2'))
        Assert.assertFalse(project.hasProperty('prop3'))
        Assert.assertFalse(project.hasProperty('prop4'))

        project.auxprops.propertyFile new File(PropertySetTest.class.classLoader.getResource('testproperties/properties10.properties').toURI())
        Assert.assertEquals("prop1", project.auxprops.prop1)
        Assert.assertEquals("prop2", project.auxprops.prop2)
        Assert.assertFalse(project.hasProperty('prop3'))
        Assert.assertFalse(project.hasProperty('prop4'))

        project.auxprops.propertyFile new File(PropertySetTest.class.classLoader.getResource('testproperties/properties20.properties').toURI())
        Assert.assertEquals("prop3", project.auxprops.prop3)
        Assert.assertEquals("prop4", project.auxprops.prop4)
    }

    @Test
    void testMainPropertyName10() {
        Assert.assertEquals('auxprops', PropertySetPlugin.AUXPROPS)
    }

    @Test
    void testPluginInProject30() {
        DefaultProject project = (DefaultProject) ProjectBuilder.builder().build();

        Assert.assertFalse(project.hasProperty('auxprops'))
        project.pluginManager.apply(PropertySetPlugin)
        Assert.assertTrue(project.hasProperty('auxprops'))

        project.auxprops.set("otherproperty"){
            propertyFile new File(PropertySetTest.class.classLoader.getResource('testproperties/properties10.properties').toURI())
            propertyFile new File(PropertySetTest.class.classLoader.getResource('testproperties/properties20.properties').toURI())
        }

        Assert.assertEquals("prop1", project.otherproperty.prop1)
        Assert.assertEquals("prop2", project.otherproperty.prop2)
        Assert.assertEquals("prop3", project.otherproperty.prop3)
        Assert.assertEquals("prop4", project.otherproperty.prop4)
    }









}
