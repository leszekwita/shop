package com.radzik.michal.shop.flyweight.standard;


import com.radzik.michal.shop.flyweight.domain.FileType;
import com.radzik.michal.shop.flyweight.domain.MailType;
import com.radzik.michal.shop.flyweight.generic.strategy.GenericStrategy;
import com.radzik.michal.shop.flyweight.standard.strategy.GeneratorStrategy;
import com.radzik.michal.shop.flyweight.standard.strategy.SendEmailStrategy;
import lombok.RequiredArgsConstructor;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SendEmailFactory {

    private final List<SendEmailStrategy> sendEmailStrategys;


    private Map<MailType, SendEmailStrategy> strategyMap;

    @PostConstruct
    public void init(){
        strategyMap = sendEmailStrategys.stream().collect(Collectors.toMap(SendEmailStrategy::getType, Function.identity()));
    }

    public SendEmailStrategy getByType(MailType mailType){
        return strategyMap.get(mailType);
    }
}
