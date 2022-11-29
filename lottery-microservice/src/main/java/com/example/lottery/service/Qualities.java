package com.example.lottery.service;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.PARAMETER})
public @interface Qualities {
	Quality[] value();
}
