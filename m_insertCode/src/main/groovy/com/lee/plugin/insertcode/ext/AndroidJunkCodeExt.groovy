package com.lee.plugin.insertcode.ext

import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer

class AndroidJunkCodeExt {
    Map<String, Closure<JunkCodeConfig>> configMap = [:]

    NamedDomainObjectContainer<JunkCodeConfig> variantConfig

    void variantConfig(Action<? super NamedDomainObjectContainer<JunkCodeConfig>> action) {
        action.execute(variantConfig)
    }
}