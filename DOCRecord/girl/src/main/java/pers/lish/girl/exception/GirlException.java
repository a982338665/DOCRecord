package pers.lish.girl.exception;

import pers.lish.girl.enums.ResultEnum;

/**
 * create by lishengbo on 2017-12-20 14:12
 * 自定义异常：
 * 此处继承运行时异常，而非Exception，若继承后者，则无法回滚，因为Spring框架仅支持RuntimeException事务回滚
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public  GirlException (Integer code ,String msg){
        super(msg);
        this.code=code;
    }
    public  GirlException (ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
