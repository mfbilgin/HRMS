package com.mfbilgin.HRMS.Core.Adapters.Mail;

import com.mfbilgin.HRMS.Core.Utilities.Results.Result;

public interface MailService {
    Result verifyMail(String mail);
}
