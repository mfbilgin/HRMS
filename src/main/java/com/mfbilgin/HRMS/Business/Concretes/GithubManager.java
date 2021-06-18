package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.GithubService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.*;
import com.mfbilgin.HRMS.DataAccess.Abstracts.GithubDao;
import com.mfbilgin.HRMS.Entites.Concretes.Github;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GithubManager implements GithubService {
    private final GithubDao githubDao;
    @Autowired
    public GithubManager(GithubDao githubDao) {
        this.githubDao = githubDao;
    }

    @Override
    public Result add(Github github) {
        var result = githubDao.getByEmployer_Id(github.getEmployer().getId());
        if (result != null) return new ErrorResult(Messages.githubAlreadyExist);
        githubDao.save(github);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(Github github) {
        var githubById = githubDao.getById(github.getId());
        githubById.setAccountAddress(github.getAccountAddress());
        githubDao.save(githubById);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(Github github) {
        githubDao.delete(github);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<Github> getByEmployerId(int employer_id) {
        return new SuccessDataResult<>(githubDao.getByEmployer_Id(employer_id));
    }
}
