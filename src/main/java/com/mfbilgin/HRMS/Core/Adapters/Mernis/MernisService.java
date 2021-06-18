package com.mfbilgin.HRMS.Core.Adapters.Mernis;

import com.mfbilgin.HRMS.Core.Utilities.Results.Result;


public interface MernisService {
    Result checkIdentityNumber(Long identityNumber, String firstName, String lastName, int yearOfBirth);
}
