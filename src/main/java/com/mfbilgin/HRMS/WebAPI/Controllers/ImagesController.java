package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.ImageService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images/")
@CrossOrigin
public class ImagesController {
    private final ImageService imageService;
    @Autowired
    public ImagesController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("getByStaffId")
    public DataResult<Image> getByStaffId(@RequestParam int staff_id){
        return imageService.getByStaffId(staff_id);
    }
    @PostMapping("photoUpload")
    public Result photoUpload(@RequestParam("photo") MultipartFile photo, @RequestParam("id") int id) {
        return  this.imageService.add(photo,id);
    }
    @PostMapping("photoDelete")
    public Result photoDelete(@RequestParam() int id){
        return this.imageService.delete(id);
    }
}
