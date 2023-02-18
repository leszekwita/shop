package com.radzik.michal.shop.batch;

import com.radzik.michal.shop.batch.domain.ProductCsv;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class ProductReaderImpl {

    public ItemReader <ProductCsv> reader (String filePath){
        BeanWrapperFieldSetMapper<ProductCsv> mapper = new BeanWrapperFieldSetMapper<> ();
        mapper.setTargetType(ProductCsv.class);
        return new FlatFileItemReaderBuilder<ProductCsv>()
                .name("productReader")
                .linesToSkip(1)
                .resource(new FileSystemResource(filePath))
                .delimited()
                .names("name", "price", "amount")
                .fieldSetMapper(mapper)
                .build();

    }
}
