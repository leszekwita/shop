package com.radzik.michal.shop.flyweight.standard.strategy.impl;

import com.radzik.michal.shop.flyweight.domain.FileType;
import com.radzik.michal.shop.flyweight.standard.strategy.GeneratorStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GeneratorJsonImpl extends GeneratorStrategy {


    public GeneratorJsonImpl() {
        super(FileType.JSON);
    }
    @Override
    public byte[] generate() {
        log.info("File type json");
        return new byte[0];
    }
}
