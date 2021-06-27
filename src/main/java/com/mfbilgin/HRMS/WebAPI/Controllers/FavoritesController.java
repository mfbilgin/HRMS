package com.mfbilgin.HRMS.WebAPI.Controllers;

import com.mfbilgin.HRMS.Business.Abstracts.FavoriteService;
import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites/")
@CrossOrigin
public class FavoritesController {
    private final FavoriteService favoriteService;
    @Autowired
    public FavoritesController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("getAll")
    public DataResult<List<Favorite>> getAll(@RequestParam int staffId){
        return favoriteService.getAll(staffId);
    }
    @GetMapping("getById")
    public DataResult<Favorite> getById(@RequestParam int id){
        return favoriteService.getById(id);
    }
    @GetMapping("getByJobAdvertisementId")
    public DataResult<Favorite> getByJobAdvertisementId(@RequestParam int jobAdvertisementId){
        return favoriteService.getByJobAdvertisementId(jobAdvertisementId);
    }
    @GetMapping("delete")
    public Result delete(@RequestParam int id){
        return favoriteService.delete(id);
    }

    @PostMapping("add")
    public Result add(@RequestBody Favorite favorite){
        return favoriteService.add(favorite);
    }

}
