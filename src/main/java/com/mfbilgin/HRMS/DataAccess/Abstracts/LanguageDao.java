package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface LanguageDao  extends JpaRepository<Language,Integer> {
    List<Language> getByStaff_Id(@NotNull @NotBlank int staff_id);
}
