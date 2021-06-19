package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Result add(MultipartFile photoFile, int staffId);
    Result delete(int id);
    DataResult<Image> getByStaffId(int staffId);
    DataResult<Image> getById(int id);
}
