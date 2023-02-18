package com.radzik.michal.shop.batch;

import com.radzik.michal.shop.domain.dao.Product;
import com.radzik.michal.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductWriterImpl implements ItemWriter<Product> {

    private final ProductRepository productRepository;

    @Override
    public void write(List<? extends Product> list) throws Exception {
        productRepository.saveAll(list);
    }
}
