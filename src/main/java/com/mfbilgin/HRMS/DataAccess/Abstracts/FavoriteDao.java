package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface FavoriteDao extends JpaRepository<Favorite,Integer> {
    List<Favorite> getByStaff_Id(@NotNull int staff_id);
    Favorite getByJobAdvertisement_Id(int jobAdvertisement_id);
}
