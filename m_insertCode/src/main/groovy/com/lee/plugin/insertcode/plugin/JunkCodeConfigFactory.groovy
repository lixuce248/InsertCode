package com.lee.plugin.insertcode.plugin

import com.lee.plugin.insertcode.ext.JunkCodeConfig
import org.gradle.api.NamedDomainObjectFactory

class JunkCodeConfigFactory implements NamedDomainObjectFactory<JunkCodeConfig> {

    @Override
    JunkCodeConfig create(String name) {
        return new JunkCodeConfig(name)
    }
}