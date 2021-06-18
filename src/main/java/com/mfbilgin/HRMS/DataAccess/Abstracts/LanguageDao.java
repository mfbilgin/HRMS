package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface LanguageDao  extends JpaRepository<Language,Integer> {
    List<Language> getByEmployer_Id(@NotNull @NotBlank int employer_id);
}
