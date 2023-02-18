package com.radzik.michal.shop.batch;

import com.radzik.michal.shop.batch.domain.ProductCsv;
import com.radzik.michal.shop.domain.dao.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProductProcessorImpl implements ItemProcessor<ProductCsv, Product> {


    @Override
    public Product process(ProductCsv productCsv) throws Exception {
        return Product.builder()
                .amount(productCsv.getAmount())
                .name(productCsv.getName())
                .price(productCsv.getPrice())
                .build();
    }
}
