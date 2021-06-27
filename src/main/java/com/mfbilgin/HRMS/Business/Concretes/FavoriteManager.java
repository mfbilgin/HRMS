package com.mfbilgin.HRMS.Business.Concretes;

import com.mfbilgin.HRMS.Business.Abstracts.FavoriteService;
import com.mfbilgin.HRMS.Business.Contants.Messages;
import com.mfbilgin.HRMS.Core.Utilities.Results.*;
import com.mfbilgin.HRMS.DataAccess.Abstracts.FavoriteDao;
import com.mfbilgin.HRMS.Entites.Concretes.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteManager implements FavoriteService {
    private final FavoriteDao favoriteDao;
    @Autowired
    public FavoriteManager(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

    @Override
    public Result add(Favorite favorite) {
        var favoriteByJobAdvertisementId = favoriteDao.getByJobAdvertisement_Id(favorite.getJobAdvertisement().getId());
        if (favoriteByJobAdvertisementId != null) return new ErrorResult(Messages.favoriteAllReadyExist);
        favoriteDao.save(favorite);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result delete(int favoriteId) {
        var favoriteById = favoriteDao.getById(favoriteId);
        favoriteDao.delete(favoriteById);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<Favorite>> getAll(int staffId) {
        return new SuccessDataResult<>(favoriteDao.getByStaff_Id(staffId));
    }

    @Override
    public DataResult<Favorite> getById(int id) {
        return new SuccessDataResult<>(favoriteDao.getById(id));
    }

    @Override
    public DataResult<Favorite> getByJobAdvertisementId(int jobAdvertisementId) {
        return new SuccessDataResult<>(favoriteDao.getByJobAdvertisement_Id(jobAdvertisementId));
    }
}
