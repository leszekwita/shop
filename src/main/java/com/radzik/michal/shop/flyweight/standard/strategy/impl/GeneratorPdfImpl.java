package com.radzik.michal.shop.flyweight.standard.strategy.impl;

import com.radzik.michal.shop.flyweight.domain.FileType;
import com.radzik.michal.shop.flyweight.standard.strategy.GeneratorStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GeneratorPdfImpl extends GeneratorStrategy {


    public GeneratorPdfImpl() {
        super(FileType.PDF);
    }

    @Override
    public byte[] generate() {
        log.info("File type pdf");
        return new byte[0];
    }
}
