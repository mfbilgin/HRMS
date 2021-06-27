package com.mfbilgin.HRMS.Business.Abstracts;

import com.mfbilgin.HRMS.Core.Utilities.Results.DataResult;
import com.mfbilgin.HRMS.Core.Utilities.Results.Result;
import com.mfbilgin.HRMS.Entites.Concretes.Favorite;

import java.util.List;

public interface FavoriteService {
    Result add(Favorite favorite);
    Result delete(int favoriteId);
    DataResult<List<Favorite>> getAll(int StaffId);
    DataResult<Favorite> getById(int id);
    DataResult<Favorite> getByJobAdvertisementId(int jobAdvertisementId);

}
