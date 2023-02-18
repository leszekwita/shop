package com.radzik.michal.shop.flyweight.standard.strategy.impl;

import com.radzik.michal.shop.flyweight.domain.MailType;
import com.radzik.michal.shop.flyweight.standard.strategy.SendEmailStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendEmailTransactionalImpl extends SendEmailStrategy {
    public SendEmailTransactionalImpl() {
        super(MailType.TRANSACTIONAL);
    }

    @Override
    public void sendEmail() {
        log.info("Mail type TRANSACTIONAL");
    }
}
