package com.radzik.michal.shop.flyweight.standard.strategy;

import com.radzik.michal.shop.flyweight.domain.FileType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class GeneratorStrategy {

    private final FileType type;

    public abstract byte[] generate ();


}
