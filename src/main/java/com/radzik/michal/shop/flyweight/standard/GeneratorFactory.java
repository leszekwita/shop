package com.radzik.michal.shop.flyweight.standard;

import com.radzik.michal.shop.flyweight.domain.FileType;
import com.radzik.michal.shop.flyweight.standard.strategy.GeneratorStrategy;
import lombok.RequiredArgsConstructor;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GeneratorFactory {

    private final List<GeneratorStrategy> generatorStrategys;


    private Map<FileType, GeneratorStrategy> strategyMap;

    @PostConstruct
    public void init(){
        strategyMap = generatorStrategys.stream().collect(Collectors.toMap(GeneratorStrategy::getType, Function.identity()));
    }

    public GeneratorStrategy getByType(FileType fileType){
       return strategyMap.get(fileType);
    }

}
