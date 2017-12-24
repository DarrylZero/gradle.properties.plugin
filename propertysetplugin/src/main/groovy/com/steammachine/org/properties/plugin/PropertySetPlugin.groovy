package com.steammachine.org.properties.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Vladimir Bogodukhov on 16.12.2017.
 *
 * @author Vladimir Bogodukhov
 * {@link com.steammachine.org.properties.plugin.PropertySetPlugin}
 *        com.steammachine.org.properties.plugin.PropertySetPlugin
 */
class PropertySetPlugin implements Plugin<Project> {

    public static final String AUXPROPS = 'auxprops'

    @Override
    void apply(Project project) {
        PropertySet.create(project, AUXPROPS)
    }
}
