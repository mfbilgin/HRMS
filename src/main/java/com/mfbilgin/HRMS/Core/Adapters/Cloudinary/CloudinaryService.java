package com.mfbilgin.HRMS.Core.Adapters.Cloudinary;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryService {
    DataResult<Map> saveImage(MultipartFile file);
}
