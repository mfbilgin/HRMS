package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Dto.LoginForUserDto;
import com.mfbilgin.HRMS.Entites.Dto.RegisterForEmployerDto;
import com.mfbilgin.HRMS.Entites.Dto.RegisterForStaffDto;

public interface AuthService {
    Result registerForEmployer(RegisterForEmployerDto registerForEmployerDto);
    Result registerForStaff(RegisterForStaffDto registerForStaffDto);
    Result login(LoginForUserDto loginForUserDto);
}
