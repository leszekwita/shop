package com.radzik.michal.shop.batch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCsv {

    private String name;

    private Integer price;

    private Integer amount;
}
