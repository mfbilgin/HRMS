package com.mfbilgin.HRMS.Core.Adapters.Mail;

import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessResult;
import com.mfbilgin.HRMS.Services.Mail.FakeMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailManagerAdapter implements MailService{
    private final FakeMailService mailService;
    @Autowired
    public MailManagerAdapter(FakeMailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public Result verifyMail(String mail) {
        if (!mailService.verifyMail(mail)){
            return new ErrorResult(Messages.mailNotVerified);
        }
        return new SuccessResult();
    }
}
