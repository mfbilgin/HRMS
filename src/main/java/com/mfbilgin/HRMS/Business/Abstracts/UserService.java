package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Entites.User;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;

import java.util.List;

public interface UserService {
    Result add(User user);
    DataResult<User> getByEmail(String email);
    DataResult<List<User>> getAll();
}
