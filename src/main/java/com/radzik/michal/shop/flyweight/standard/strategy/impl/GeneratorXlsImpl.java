package com.radzik.michal.shop.flyweight.standard.strategy.impl;

import com.radzik.michal.shop.flyweight.domain.FileType;
import com.radzik.michal.shop.flyweight.standard.strategy.GeneratorStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GeneratorXlsImpl extends GeneratorStrategy {

    public GeneratorXlsImpl() {
        super(FileType.XLS);
    }
    @Override
    public byte[] generate() {

        log.info("File type xls");
        return new byte[0];
    }
}
