package com.radzik.michal.shop.flyweight.generic.strategy.generator.impl;

import com.radzik.michal.shop.flyweight.domain.FileType;
import com.radzik.michal.shop.flyweight.generic.strategy.generator.GeneratorStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JsonGeneratorImpl implements GeneratorStrategy {

    @Override
    public FileType getType() {
        return FileType.JSON;
    }


    @Override
    public byte[] generateFile() {
        log.info("generate file is Json");
        return new byte[0];
    }
}
