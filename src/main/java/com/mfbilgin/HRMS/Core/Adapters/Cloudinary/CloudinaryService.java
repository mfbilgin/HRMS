package com.mfbilgin.HRMS.Core.Adapters.Cloudinary;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {
    DataResult<Map<String, String>> upload(MultipartFile file);
    DataResult<Map> delete(String id) throws IOException;
}
