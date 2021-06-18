package com.mfbilgin.HRMS.Core.Adapters.Mernis;

import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessResult;
import com.mfbilgin.HRMS.Services.Mernis.FakeMernisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MernisManagerAdapter implements MernisService{
    private final FakeMernisService mernisService;
    @Autowired
    public MernisManagerAdapter(FakeMernisService mernisService) {
        this.mernisService = mernisService;
    }

    @Override
    public Result checkIdentityNumber(Long identityNumber, String firstName, String lastName, int yearOfBirth) {
       if (!mernisService.TcKimlikNoDogrula(identityNumber,firstName,lastName,yearOfBirth)){
           return new ErrorResult(Messages.infosNotValid);
       }
        return new SuccessResult();
    }
}
