package com.example.springbootdemo1.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zc
 * @Description TODO
 * @date 2021/10/10 9:52 下午
 * @Version 1.0
 */
@Data
public class Goods {
    private String id;

    private String goodsName;

    private BigDecimal price;
}
