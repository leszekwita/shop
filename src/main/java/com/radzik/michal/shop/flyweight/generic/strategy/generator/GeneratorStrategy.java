package com.radzik.michal.shop.flyweight.generic.strategy.generator;

import com.radzik.michal.shop.flyweight.domain.FileType;
import com.radzik.michal.shop.flyweight.generic.strategy.GenericStrategy;

public interface GeneratorStrategy extends GenericStrategy<FileType> {

    byte [] generateFile();
}
