package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.*;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Adapters.Mail.MailService;
import com.mfbilgin.HRMS.Core.Adapters.Mernis.MernisService;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessResult;
import com.mfbilgin.HRMS.Entites.Concretes.Employer;
import com.mfbilgin.HRMS.Entites.Concretes.Staff;
import com.mfbilgin.HRMS.Entites.Dto.LoginForUserDto;
import com.mfbilgin.HRMS.Entites.Dto.RegisterForEmployerDto;
import com.mfbilgin.HRMS.Entites.Dto.RegisterForStaffDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.TypeMapper;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
public class AuthManager implements AuthService {
    private final UserService userService;
    private final StaffService staffService;
    private final EmployerService employerService;
    private final SystemStaffService systemStaffService;
    private final MernisService mernisService;
    private final MailService mailService;


    @Autowired
    public AuthManager(
            UserService userService,
            StaffService staffService,
            EmployerService employerService,
            SystemStaffService systemStaffService,
            MernisService mernisService,
            MailService mailService) {
        this.userService = userService;
        this.staffService = staffService;
        this.employerService = employerService;
        this.systemStaffService = systemStaffService;
        this.mernisService = mernisService;
        this.mailService = mailService;
    }


    @Override
    public Result registerForEmployer(RegisterForEmployerDto registerForEmployerDto) {
        if(!checkEmployerDomain(registerForEmployerDto)){
            return new ErrorResult(Messages.emailDomainMustBeSameAsWebSite);
        }
        if (!registerForEmployerDto.getPassword().equals(registerForEmployerDto.getPasswordConfirm())){
            return new ErrorResult(Messages.passwordsNotSame);
        }
        if(this.userService.getByEmail(registerForEmployerDto.getEmail()).getData() != null){
            return new ErrorResult(Messages.mailAlreadyExist);
        }
        var employerForRegister = generateEmployer(registerForEmployerDto);
        employerForRegister.setVerifiedByEmail(mailService.verifyMail(registerForEmployerDto.getEmail()).isSuccess());
        employerService.add(employerForRegister);
        return new SuccessResult(Messages.registered);
    }

    @Override
    public Result registerForStaff(RegisterForStaffDto registerForStaffDto) {
        if(this.userService.getByEmail(registerForStaffDto.getEmail()).getData() != null ||
                this.staffService.getByIdentificationNumber(registerForStaffDto.getIdentificationNumber()).getData() !=null){
            return new ErrorResult(Messages.mailOrIdentificationNumberAlreadyExist);
        }
        if (!registerForStaffDto.getPassword().equals(registerForStaffDto.getPasswordConfirm())){
            return new ErrorResult(Messages.passwordsNotSame);
        }
        if(!mernisService.checkIdentityNumber(
                Long.parseLong(registerForStaffDto.getIdentificationNumber()),
                registerForStaffDto.getFirstName(),
                registerForStaffDto.getLastName(),
                Integer.parseInt(registerForStaffDto.getBirthYear())).isSuccess()){
            return new ErrorResult(Messages.infosNotValid);
        }
        Staff candidatesForRegister = generateStaff(registerForStaffDto);
        candidatesForRegister.setVerifiedByEmail(mailService.verifyMail(candidatesForRegister.getEmail()).isSuccess());
        staffService.add(candidatesForRegister);
        return new SuccessResult(Messages.registered);
    }

    @Override
    public Result login(LoginForUserDto loginForUserDto) {
        var user = userService.getByEmail(loginForUserDto.getEmail()).getData();
        if (user == null){
            return new ErrorResult(Messages.userNotExist);
        }
        if(!user.getPassword().equals(loginForUserDto.getPassword())){
            return new ErrorResult(Messages.passwordError);
        }
        return new SuccessResult(Messages.logined);
    }

    public boolean checkEmployerDomain(RegisterForEmployerDto registerForEmployerDto) {
        String mailDomain = registerForEmployerDto.getEmail().split("@")[1].split("\\.")[0];
        return mailDomain.equals(registerForEmployerDto.getWebsite().split("\\.")[1]);
    }
    private Employer generateEmployer(RegisterForEmployerDto registerForEmployerDto) {
        var employer = new Employer();
        employer.setCompanyName(registerForEmployerDto.getCompanyName());
        employer.setPhoneNumber(registerForEmployerDto.getPhoneNumber());
        employer.setWebAddress(registerForEmployerDto.getWebsite());
        employer.setActivatedBySystemStaff(false);
        employer.setEmail(registerForEmployerDto.getEmail());
        employer.setPassword(registerForEmployerDto.getPassword());
        return employer;
    }
    private Staff generateStaff(RegisterForStaffDto registerForStaffDto) {
        var staff= new Staff();
        staff.setFirstName(registerForStaffDto.getFirstName());
        staff.setLastName(registerForStaffDto.getLastName());
        staff.setBirthYear(registerForStaffDto.getBirthYear());
        staff.setIdentificationNumber(registerForStaffDto.getIdentificationNumber());
        staff.setEmail(registerForStaffDto.getEmail());
        staff.setPassword(registerForStaffDto.getPassword());
        return staff;
    }

}
