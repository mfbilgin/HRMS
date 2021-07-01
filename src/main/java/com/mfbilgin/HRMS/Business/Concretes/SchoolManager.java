package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.SchoolService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessResult;
import com.mfbilgin.HRMS.DataAccess.Abstracts.SchoolDao;
import com.mfbilgin.HRMS.Entites.Concretes.School;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolManager implements SchoolService {
    private final SchoolDao schoolDao;

    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }


    @Override
    public Result add(School school) {
        if (school.getGraduationYear().equals("") || school.getGraduationYear().equals("0")){
            school.setGraduationYear("Devam Ediyor");
        }
        schoolDao.save(school);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(School school) {
        var schoolById = schoolDao.getById(school.getSchoolId());
        schoolById.setDepartment(school.getDepartment());
        schoolById.setSchoolName(school.getSchoolName());
        schoolById.setStartYear(school.getStartYear());
        if (school.getGraduationYear().equals("") || school.getGraduationYear().equals("0")){
            schoolById.setGraduationYear("Devam Ediyor");
        }
        else{
            schoolById.setGraduationYear(school.getGraduationYear());
        }
        schoolDao.save(schoolById);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(int schoolId) {
        var school = schoolDao.getById(schoolId);
        schoolDao.delete(school);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<School>> getByStaffId(int staff_id) {
        return new SuccessDataResult<>(schoolDao.getByStaff_Id(staff_id));
    }

    @Override
    public DataResult<School> getById(int id) {
        return new SuccessDataResult<>(schoolDao.getById(id));
    }

    @Override
    public DataResult<List<School>> getByStaff_IdOrderByGraduationYearDesc(int staff_id) {
        return new SuccessDataResult<>(schoolDao.getByStaff_IdOrderByGraduationYearDesc(staff_id));
    }
}
