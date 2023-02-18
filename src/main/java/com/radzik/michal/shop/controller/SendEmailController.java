package com.radzik.michal.shop.controller;

import com.radzik.michal.shop.flyweight.domain.MailType;
import com.radzik.michal.shop.flyweight.generic.GenericFactory;
import com.radzik.michal.shop.flyweight.generic.strategy.generator.SendEmailStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sendmail")
@RequiredArgsConstructor
public class SendEmailController {

    private final GenericFactory<MailType, SendEmailStrategy> sendEmailFactory;

    @GetMapping("/{mailType}")
    public void getSendEmail(@PathVariable MailType mailType) {
        sendEmailFactory.getByType(mailType).sendMail();
    }
}
