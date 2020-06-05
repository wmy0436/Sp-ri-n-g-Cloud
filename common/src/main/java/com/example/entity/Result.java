package com.example.entity;

import lombok.Data;

/**
 * @author mingyi
 * 返回值类
 */
@Data
public class Result<T> {

    /**
     * 状态码
     */
    private int code;
    /**
     * 回传信息
     */
    private String mesage;

    /**
     * 回传数据
     */
    private T data;


    public Result(T data) {
        this.code = 200;
        this.mesage = "执行成功";
        this.data = data;
    }

    public Result() {
        this.code = 200;
        this.mesage = "执行成功";
    }

    public Result(int code, String mesage) {
        this.code = code;
        this.mesage = mesage;
    }

    /**
     * 带返回值的成功结果调用
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    /**
     * 无返回值的成功结果调用
     *
     * @param
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        return new Result<T>();
    }

    /**
     * 调用失败返回信息与状态码
     *
     * @param mesage
     * @param code
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String mesage, int code) {
        return new Result<T>(code, mesage);
    }


}
