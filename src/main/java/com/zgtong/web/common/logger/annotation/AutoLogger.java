package com.zgtong.web.common.logger.annotation;

import com.zgtong.web.common.logger.LogFormat;
import com.zgtong.web.common.logger.LogLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自动对方法前后打日志信息
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AutoLogger {
    /**
     * 记录方法入参
     * @return
     */
    boolean request() default true;

    /**
     * 记录方法返回值
     * @return
     */
    boolean response() default true;

    /**
     * 是否记录到神策打点日志
     * @return
     */
    boolean shencePoint() default false;

    /**
	 * 只在返回结果错误时记录
	 */
	boolean onlyFailed() default false;

	/**
	 * 记录耗时
	 * 
	 * @return
	 */
    @Deprecated
    boolean usedtime() default true;

    /**
     * 数据格式化方式
     * @return
     */
    LogFormat requestFormat() default LogFormat.json;

    /**
     * 数据格式化方式
     * @return
     */
    LogFormat responseFormat() default LogFormat.json;

    /**
     * 日志级别
     * @return
     */
    @Deprecated
    LogLevel logLevel() default LogLevel.info;
}
