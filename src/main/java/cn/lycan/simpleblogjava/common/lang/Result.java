package cn.lycan.simpleblogjava.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Makkapakka
 * @date 2022-6-28
 * @package_name cn.lycan.simpleblogjava.common.lang
 * @description
 */
@Data
public class Result implements Serializable {
    
    private String code;
    private String msg;
    private Object data;
    
    public static Result success(String msg, Object data) {
        Result m = new Result();
        m.setCode("0");
        m.setData(data);
        m.setMsg(msg);
        return m;
    }
    
    public static Result fail(String msg) {
        Result m = new Result();
        m.setCode("-1");
        m.setData(null);
        m.setMsg(msg);
        return m;
    }
    
    public static Result fail(String msg, Object data) {
        Result m = new Result();
        m.setCode("-1");
        m.setMsg(msg);
        m.setData(data);
        return m;
    }
}
