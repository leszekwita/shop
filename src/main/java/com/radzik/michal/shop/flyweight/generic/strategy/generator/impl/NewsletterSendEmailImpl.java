package com.radzik.michal.shop.flyweight.generic.strategy.generator.impl;

import com.radzik.michal.shop.flyweight.domain.MailType;
import com.radzik.michal.shop.flyweight.generic.strategy.generator.SendEmailStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NewsletterSendEmailImpl implements SendEmailStrategy {
    @Override
    public MailType getType() {
        return MailType.NEWSLETTER;
    }

    @Override
    public void sendMail() {
        log.info("generate type NEWSLETTER");
    }
}