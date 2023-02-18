package com.radzik.michal.shop.flyweight.standard.strategy.impl;

import com.radzik.michal.shop.flyweight.domain.FileType;
import com.radzik.michal.shop.flyweight.standard.strategy.GeneratorStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GeneratorCsvImpl extends GeneratorStrategy {


    public GeneratorCsvImpl() {
        super(FileType.CSV);
    }

    @Override
    public byte[] generate() {
        log.info("Generate type csv");
        return new byte[0];
    }
}
