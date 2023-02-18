package com.radzik.michal.shop.flyweight.standard.strategy;

import com.radzik.michal.shop.flyweight.domain.MailType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class SendEmailStrategy {

    private final MailType type;

    public abstract void sendEmail ();
}
