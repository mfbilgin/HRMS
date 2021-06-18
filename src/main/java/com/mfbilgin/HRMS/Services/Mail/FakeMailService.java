package com.mfbilgin.HRMS.Services.Mail;

import org.springframework.stereotype.Component;

@Component
public class FakeMailService {
    public boolean verifyMail(String mail){
        return !mail.equals("");
    }
}
