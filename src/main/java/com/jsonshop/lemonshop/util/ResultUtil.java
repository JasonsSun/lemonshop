package com.jsonshop.lemonshop.util;

import java.beans.Transient;

public class ResultUtil {

    private static String Success = "success";

    private static String Failed = "error";

    private String message;

    private Boolean BoolStatus;

    private String TextStatus;

    public Boolean getBoolStatus() {
        return BoolStatus;
    }

    public void setBoolStatus(Boolean boolStatus) {
        BoolStatus = boolStatus;
    }

    public String getTextStatus() {
        return TextStatus;
    }

    public void setTextStatus(String textStatus) {
        TextStatus = textStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Transient
    /**
     * @Package com.jsonshop.lemonshop.util
     * @Description:
     * @author Jason
     * @date 2019/6/8  1:21
     * @version 1.0
     * @Params [info]
     * @Return com.jsonshop.lemonshop.util.ResultUtil
     */
    public static ResultUtil renderSuccess(String info) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setMessage(info);
        resultUtil.setBoolStatus(true);
        return resultUtil;

    }


    @Transient
    /**
     * @Package com.jsonshop.lemonshop.util
     * @Description:
     * @author Jason
     * @date 2019/6/8  1:27
     * @version 1.0
     * @Params [info]
     * @Return com.jsonshop.lemonshop.util.ResultUtil
     */
    public static ResultUtil renderFailed(String info) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setMessage(info);
        resultUtil.setBoolStatus(false);
        return resultUtil;

    }


    @Transient
    /**
     * @Package com.jsonshop.lemonshop.util
     * @Description:
     * @author Jason
     * @date 2019/6/8  1:27
     * @version 1.0
     * @Params [info]
     * @Return com.jsonshop.lemonshop.util.ResultUtil
     */
    public static ResultUtil renderSuccessText(String info) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setMessage(info);
        resultUtil.setTextStatus(Success);
        return resultUtil;

    }


    @Transient
    /**
     * @Package com.jsonshop.lemonshop.util
     * @Description:
     * @author Jason
     * @date 2019/6/8  1:29
     * @version 1.0
     * @Params [info]
     * @Return com.jsonshop.lemonshop.util.ResultUtil
     */
    public static ResultUtil renderFailedText(String info) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setMessage(info);
        resultUtil.setTextStatus(Failed);
        return resultUtil;

    }
}
