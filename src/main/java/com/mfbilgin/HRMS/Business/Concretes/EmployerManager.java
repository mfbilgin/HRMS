package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.EmployerService;
import com.mfbilgin.HRMS.Business.Abstracts.JobAdvertisementService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessResult;
import com.mfbilgin.HRMS.DataAccess.Abstracts.EmployerDao;
import com.mfbilgin.HRMS.Entites.Concretes.Employer;
import com.mfbilgin.HRMS.Entites.Concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployerManager implements EmployerService {
    private final EmployerDao employerDao;
    private final JobAdvertisementService jobAdvertisementService;
    @Autowired
    public EmployerManager(EmployerDao employerDao, JobAdvertisementService jobAdvertisementService) {
        this.employerDao = employerDao;
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @Override
    public Result add(Employer employer) {
        employer.setActivatedBySystemStaff(false);
        employerDao.save(employer);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(Employer employer) {
        return new SuccessResult(Messages.updated);
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(employerDao.findAll());
    }

    @Override
    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<>(employerDao.getById(id));
    }

    @Override
    public DataResult<List<Employer>> getByIfHaveJobAdvertisement() {
        List<Employer> employers = new ArrayList<>();
        var jobAdvertisementResult =  jobAdvertisementService.getByStatusIsTrue().getData();
        for (JobAdvertisement jobAdvertisement:jobAdvertisementResult) {
            if (!employers.contains(jobAdvertisement.getEmployer())){
                employers.add(jobAdvertisement.getEmployer());
            }
        }
        return new SuccessDataResult<>(employers);
    }


}
