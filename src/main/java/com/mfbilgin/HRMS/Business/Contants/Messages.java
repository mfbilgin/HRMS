package com.mfbilgin.HRMS.Business.Contants;

public class Messages {
    // # Common Messages #
    public static final String updated = "Güncellendi";
    public static final String added = "Eklendi";
    public static final String deleted = "Silindi";
    // # Job Position Messages #
    public static final String jobPositionNameLengthMustBeGreatherThanOne = "İş Pozisyonu Adı en az 2 karakter olmalıdır";
    public static final String jobPositionExist = "İş pozisyonu zaten var";


    // # Auth Messages #
    public static final String registered = "Kayıt Oluşturuldu";
    public static final String logined = "Giriş Yapıldı";
    public static final String passwordError = "Parola Hatalı";
    public static final String passwordsNotSame = "Parolalar Eşleşmiyor";


    // # User Messages #
    public static final String userNotExist = "Kullanıcı Bulunamadı";
    public static final String mailAlreadyExist = "Bu Mail Adresi Kullanımda";
    public static final String mailOrIdentificationNumberAlreadyExist = "Bu maile veya TC kimlik numarasına ait birisi zaten kayıtlı";
    public static final String emailDomainMustBeSameAsWebSite = "Email domaini web sitesi domainiyle aynı olmalı.";


    // # Job Advertisement Messages #
    public static final String applicationDeadlineWasExpired = "Bu ilanın son başvuru tarihi geçmiş.";
    public static final String cityWasNull = "Şehir boş geçilemez.";
    public static final String jobPositionWasNull = "İş pozisyonu boş geçilemez.";
    public static final String workTypeWasNull = "Çalışma yeri boş geçilemez.";
    public static final String workTimeWasNull = "Çalışma zamanı boş geçilemez.";
    public static final String emptyPositionCountWasNull = "Boş pozisyonu adedi boş geçilemez";
    public static String applicationDeadlineWasNull = "Son başvuru tarihi boş geçilemez";
    public static final String jobDescriptionWasNull = "İş tanımı boş geçilemez";
    public static final String jobAdvertisementAdded = "Eklendi (onaylandıktan sonra yayınlanacaktır)";
    public static final String favoriteAllReadyExist = "Bu ilan favorilerinizde zaten mevcut";


    // # Validation Messages #
    public static final String infosNotValid = "Bilgileriniz doğrulanamadı.";
    public static final String mailNotVerified = "Mail doğrulanamadı.";


    // # Cover Letter Messages #
    public static final String coverLetterAlreadyExist = "Bir ön yazı zaten mevcut";


    // # Github Messages #
    public static final String githubAlreadyExist = "Bir github adresi zaten mevcut";


    // # Linkedin Messages #
    public static final String linkedinAlreadyExist = "Bir linkedin adresi zaten mevcut";


    // # Skill Messages #
    public static final String skillAlreadyExist = "Bu isimde bir yetenek zaten mevcut";


    // # Image Messages #
    public static final String imageAlreadyExist = "Bir resim zaten mevcut";

    // # City Messages #
    public static final String cityAlreadyExist = "Bu isimde bir şehir zaten mevcut";

}

