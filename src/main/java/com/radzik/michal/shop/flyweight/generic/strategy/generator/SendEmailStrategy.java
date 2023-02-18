package com.radzik.michal.shop.flyweight.generic.strategy.generator;

import com.radzik.michal.shop.flyweight.domain.MailType;
import com.radzik.michal.shop.flyweight.generic.strategy.GenericStrategy;

public interface SendEmailStrategy extends GenericStrategy<MailType> {

    void sendMail();
}
