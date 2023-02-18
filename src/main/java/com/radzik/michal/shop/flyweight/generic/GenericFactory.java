package com.radzik.michal.shop.flyweight.generic;

import com.radzik.michal.shop.flyweight.generic.strategy.GenericStrategy;
import com.radzik.michal.shop.flyweight.standard.strategy.GeneratorStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GenericFactory<K,V extends GenericStrategy<K>> {

    private final List<V> strategyList;

    private Map<K,V> strategyMap;

    @PostConstruct
    void init(){
        this.strategyMap = strategyList.stream().collect(Collectors.toMap(GenericStrategy::getType, Function.identity()));
    }

    public V getByType(K type){
        return strategyMap.get(type);

    }
}
