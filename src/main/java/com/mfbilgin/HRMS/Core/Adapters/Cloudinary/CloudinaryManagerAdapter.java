package com.mfbilgin.HRMS.Core.Adapters.Cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.ErrorDataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.SuccessDataResult;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CloudinaryManagerAdapter implements CloudinaryService{
    Cloudinary cloudinary;

    public CloudinaryManagerAdapter() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name", "dogukanozgurylmz");
        valuesMap.put("api_key", "114183154134113");
        valuesMap.put("api_secret", "Fc1vBgzek7nNPxCT1q6UVgygmwM");
        cloudinary = new Cloudinary(valuesMap);
    }

    @Override
    public DataResult<Map> saveImage(MultipartFile file) {
        try {
            var resultMap = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<>(resultMap);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return new ErrorDataResult<>();
    }
}
