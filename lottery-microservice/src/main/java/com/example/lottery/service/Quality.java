package com.example.lottery.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Repeatable(Qualities.class)
public @interface Quality {
	QualityLevel value();
}
