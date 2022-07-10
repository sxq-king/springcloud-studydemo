package com.sxq.springcloud.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sxq.springcloud.entities.CommonResult;

/**
 * @Auther: s x q
 * @Date: 2022/7/6 15:34
 * @Version: v1.0
 */

public class CustomerBlockHandler {
    public static CommonResult handleException1(BlockException exception){
        return new CommonResult(4444,"客户自定义，global handleException----1");
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(4444,"客户自定义，global handleException----2");
    }

}
