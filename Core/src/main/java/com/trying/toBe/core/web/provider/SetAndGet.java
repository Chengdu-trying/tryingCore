package com.trying.toBe.core.web.provider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标记一个action中的属性字段需要set和get方法
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SetAndGet {
	/** 是否需要set方法 */
	boolean set() default true;

	/** 是否需要get方法 */
	boolean get() default true;
}
