package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.EmployerService;
import com.mfbilgin.HRMS.Business.Abstracts.ImageService;
import com.mfbilgin.HRMS.Business.Abstracts.StaffService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Adapters.Cloudinary.CloudinaryService;
import com.mfbilgin.HRMS.Core.Utilities.Results.*;
import com.mfbilgin.HRMS.DataAccess.Abstracts.ImageDao;
import com.mfbilgin.HRMS.Entites.Concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class ImageManager implements ImageService {
    private final ImageDao imageDao;
    private final CloudinaryService cloudinaryService;
    private final StaffService staffService;
    private final EmployerService employerService;
    @Autowired
    public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService, StaffService staffService, EmployerService employerService) {
        this.imageDao = imageDao;
        this.cloudinaryService = cloudinaryService;
        this.staffService = staffService;
        this.employerService = employerService;
    }

    @Override
    public Result add(MultipartFile photoFile, int staffId) {
        var imageByStaffId = imageDao.getByStaff_Id(staffId);
        if (imageByStaffId != null) return new ErrorResult(Messages.imageAlreadyExist);
        var result = this.cloudinaryService.upload(photoFile);
        if(!result.isSuccess()) {
            return new ErrorResult();
        }
        Image photo = new Image();
        photo.setStaff(staffService.getById(staffId).getData());
        photo.setImagePath(result.getData().get("url"));
        this.imageDao.save(photo);
        return new SuccessResult(Messages.added);

    }

    @Override
    public Result delete(int id) {
        var image = imageDao.getById(id);
        this.imageDao.delete(image);
        return new SuccessResult(Messages.deleted);

    }

    @Override
    public DataResult<Image> getByStaffId(int id) {
        return new SuccessDataResult<>(imageDao.getByStaff_Id(id));
    }

    @Override
    public DataResult<Image> getById(int id) {
        return new SuccessDataResult<>(imageDao.getById(id));
    }
}
