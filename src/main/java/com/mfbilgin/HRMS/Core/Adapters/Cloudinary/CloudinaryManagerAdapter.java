package com.mfbilgin.HRMS.Core.Adapters.Cloudinary;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Services.Cloudinary.JCloudinaryService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Component
public class CloudinaryManagerAdapter implements CloudinaryService{
    private final JCloudinaryService jCloudinaryService;

    public CloudinaryManagerAdapter(JCloudinaryService jCloudinaryService) {
        this.jCloudinaryService = jCloudinaryService;
    }

    @Override
    public DataResult<Map<String, String>> upload(MultipartFile file) {
        return jCloudinaryService.upload(file);
    }

    @Override
    public DataResult<Map> delete(int id) throws IOException {
        return jCloudinaryService.delete(String.valueOf(id));
    }
}
