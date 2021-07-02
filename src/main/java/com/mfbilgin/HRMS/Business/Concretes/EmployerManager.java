package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.EmployerService;
import com.mfbilgin.HRMS.Business.Abstracts.EmployerUpdateService;
import com.mfbilgin.HRMS.Business.Abstracts.JobAdvertisementService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.*;
import com.mfbilgin.HRMS.DataAccess.Abstracts.EmployerDao;
import com.mfbilgin.HRMS.Entites.Concretes.Employer;
import com.mfbilgin.HRMS.Entites.Concretes.EmployerUpdate;
import com.mfbilgin.HRMS.Entites.Concretes.JobAdvertisement;
import com.mfbilgin.HRMS.Entites.Dto.RegisterForEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployerManager implements EmployerService {
    private final EmployerDao employerDao;
    private final EmployerUpdateService employerUpdateService;
    private final JobAdvertisementService jobAdvertisementService;
    @Autowired
    public EmployerManager(EmployerDao employerDao, EmployerUpdateService employerUpdateService, JobAdvertisementService jobAdvertisementService) {
        this.employerDao = employerDao;
        this.employerUpdateService = employerUpdateService;
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @Override
    public Result add(Employer employer) {
        employer.setActivatedBySystemStaff(false);
        employerDao.save(employer);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(Employer employer)
    {
        var employerForUpdate = employerDao.getById(employer.getId());
        employerForUpdate.setPassword(employer.getPassword());
        employerForUpdate.setEmail(employer.getEmail());
        employerForUpdate.setWebAddress(employer.getWebAddress());
        employerForUpdate.setPhoneNumber(employer.getPhoneNumber());
        employerForUpdate.setCompanyName(employer.getCompanyName());
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result addToUpdate(Employer employer) {
        if(!checkEmployerDomain(employer)){
            return new ErrorResult(Messages.emailDomainMustBeSameAsWebSite);
        }
        var employerUpdate = convertEmployerToEmployerUpdate(employer);
        employerUpdateService.add(employerUpdate);
        return new SuccessResult(Messages.willBeUpdatedAfterApproved);
    }

    @Override
    public Result setUpdateStatus(int id) {
        var employerUpdate = employerUpdateService.getByEmployer_Id(id).getData();
        var employer = convertEmployerUpdateToEmployer(employerUpdate);
        update(employer);
        employerUpdateService.delete(employerUpdate.getEmployerUpdateId());
        return new SuccessResult(Messages.employerUpdateStatusSetToTrue);
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
    private Employer convertEmployerUpdateToEmployer(EmployerUpdate employerUpdate) {
        var employer = new Employer();
        employer.setId(employerUpdate.getEmployer().getId());
        employer.setEmail(employerUpdate.getEmail());
        employer.setCompanyName(employerUpdate.getCompanyName());
        employer.setPhoneNumber(employerUpdate.getPhoneNumber());
        employer.setWebAddress(employerUpdate.getWebAddress());
        employer.setPassword(employerUpdate.getPassword());
        return employer;
    }
    private EmployerUpdate convertEmployerToEmployerUpdate(Employer employer) {
        var employerUpdate = new EmployerUpdate();
        employerUpdate.setEmail(employer.getEmail());
        employerUpdate.setCompanyName(employer.getCompanyName());
        employerUpdate.setPhoneNumber(employer.getPhoneNumber());
        employerUpdate.setWebAddress(employer.getWebAddress());
        employerUpdate.setPassword(employer.getPassword());
        employerUpdate.setEmployer(employer);
        return employerUpdate;
    }
    private boolean checkEmployerDomain(Employer employer) {
        String mailDomain = employer.getEmail().split("@")[1].split("\\.")[0];
        return mailDomain.equals(employer.getWebAddress().split("\\.")[1]);
    }
}
