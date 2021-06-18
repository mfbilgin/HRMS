package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.UserService;
import com.mfbilgin.HRMS.Core.DataAccess.UserDao;
import com.mfbilgin.HRMS.Core.Entites.User;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Üye eklendi.");
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<>(this.userDao.getByEmail(email));
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(this.userDao.findAll(),"Üyeler listelendi.");
    }
}
