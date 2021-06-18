package com.mfbilgin.HRMS.Services.Mernis;

import org.springframework.stereotype.Component;

@Component
public class FakeMernisService {
    public boolean TcKimlikNoDogrula(Long tcKimlikNo,String ad,String soyad,int dogumYili){
        return tcKimlikNo != 0 && !ad.equals("") && !soyad.equals("") && dogumYili != 0;
    }
}
