package com.jsonshop.lemonshop.util;


import com.jsonshop.lemonshop.log.LogEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//该类定义了不同层的日志，分别是业务层、平台、数据库层和异常。
// 如果需要添加更多的层面，可以自己定义yaml文件以及枚举类型，并写入到工具类中即可。
public class LogUtils {

    /**
     * 获取业务日志logger
     */
    public static Logger getBussinessLogger() {
        return LoggerFactory.getLogger(LogEnum.BUSSINESS.getCategory());
    }

    /**
     * 获取平台日志logger
     */
    public static Logger getPlatformLogger() {
        return LoggerFactory.getLogger(LogEnum.PLATFORM.getCategory());
    }

    /**
     * 获取数据库日志logger
     */
    public static Logger getDBLogger() {
        return LoggerFactory.getLogger(LogEnum.DB.getCategory());
    }

    /**
     * 获取异常日志logger
     */
    public static Logger getExceptionLogger() {
        return LoggerFactory.getLogger(LogEnum.EXCEPTION.getCategory());
    }

}
