package com.mfbilgin.HRMS.DataAccess.Abstracts;

import com.mfbilgin.HRMS.Entites.Concretes.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface SkillDao extends JpaRepository<Skill,Integer> {
    List<Skill> getByStaff_Id(@NotNull @NotBlank int staff_id);
    @Query("From Skill where staff.id =:staff_id and name =:name")
    Skill getByStaff_IdAndAndName(@NotNull @NotBlank int staff_id,String name);
}
