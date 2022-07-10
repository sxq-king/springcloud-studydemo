package com.sxq.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: s x q
 * @Date: 2022/6/23 10:31
 * @Version: v1.0
 *
 * 返回前端通用的json字符串
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{
    private Integer code;
    private String  message;
    private T       date;

    public CommonResult(Integer code, String message){
        this(code,message,null);

    }
}
