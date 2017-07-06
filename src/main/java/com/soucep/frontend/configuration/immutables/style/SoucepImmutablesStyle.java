package com.soucep.frontend.configuration.immutables.style;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Created by Zsolt_Jakab on 7/4/2017.
 */
@Target({PACKAGE, TYPE})
@Retention(CLASS)
@JsonSerialize
@JsonDeserialize
@Value.Style (
        get = {"*"},
        init = "*",
        typeAbstract = {"Abstract*"},
        typeImmutable = "Immutable*",
        builder = "builder",
        build = "build",
        visibility = Value.Style.ImplementationVisibility.PUBLIC,
        overshadowImplementation = true,
        builderVisibility = Value.Style.BuilderVisibility.PUBLIC)
public @interface SoucepImmutablesStyle {
}
