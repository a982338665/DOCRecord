package pers.lish.girl.utils;

import pers.lish.girl.domain.ResultBean;

/**
 * create by lishengbo on 2017-12-20 11:42
 */
public class ResultUtil {

    public static ResultBean success(Object o) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(1);
        resultBean.setMsg("成功");
        resultBean.setData(o);
        return resultBean;
    }

    public static ResultBean success() {
        return success(null);
    }

    public static ResultBean error(Integer code, String msg, Object o) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(code);
        if(msg==null){
            resultBean.setMsg("");
        }else{
            resultBean.setMsg(msg);
        }
        resultBean.setData(o);
        return resultBean;
    }
    public static ResultBean error() {
        return error(0,"系统异常",null);
    }
    public static ResultBean error( Object o) {
        return error(0,"系统异常",o);
    }
    public static ResultBean error( Integer code, String msg) {
        return error(code,msg,null);
    }
}
