package com.cecgw.cq.entity;

/**
 * @Author zhuguanghui
 * @Description
 * @Date 2018/12/4
 */

public class ResultModel<T> {
    // 返回码
    private Integer code;
    // 返回消息
    private String msg;
    // 数据源
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public ResultModel(){
        super();
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
    public ResultModel(Integer code, String msg, T data ){
        this.data = data;
        this.code = code;
        this.msg = msg;
    }
}
