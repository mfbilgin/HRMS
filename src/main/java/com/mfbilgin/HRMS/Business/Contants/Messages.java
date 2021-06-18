package com.mfbilgin.HRMS.Business.Contants;

public class Messages {
    // # Common Messages #
    public static final String updated = "Güncellendi";
    public static final String added = "Eklendi";
    public static final String deleted = "Silindi";



    // # Staffs Messages #
    public static final String firstNameLengthMustBeGreaterThanOne = "İsim en az 2 karakter olmalıdır";
    public static final String lastNameLengthMustBeGreaterThanOne = "Soyisim en az 2 karakter olmalıdır";
    public static final String firstNameLengthMustBeSmallerThanFifty = "İsim en fazla 50 karakter olabilir";
    public static final String lastNameLengthMustBeSmallerThanFifty = "Soyisim en fazla 50 karakter olabilir";
    public static final String phoneNumberLengthMustBeFourCharacter = "Telefon numarası 11 karakter olmalıdır";
    public static final String yearOfBirthLengthMustBeFourCharacter = "Doğum yılı 4 karakter olmalıdır";
    public static final String identityNumberLengthMustBeElevenCharacter = "Kimlik Numarası 11 karakter olmalıdır";
    public static final String addressLengthMustBeGreaterThanNine = "Adres en az 10 karakter olmalıdır";
    public static final String addressLengthMustBeSmallerThanTwoHundred = "Adres en fazla 200 karakter olabilir";


    // # Employer Messages #
    public static final String companyNameLengthMustBeSmallerThanFifty = "Şirket ismi en fazla 50 karakter olabilir";
    public static final String companyNameLengthMustBeSmallerThanHundred = "Web site en fazla 100 karakter olabilir";


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
    public static final String identityNumberAlreadyExist = "Bu Kimlik Numarası Kullanımda";
    public static final String mailAlreadyExist = "Bu Mail Adresi Kullanımda";
    public static final String mailOrIdentificationNumberAlreadyExist = "Bu maile veya TC kimlik numarasına ait birisi zaten kayıtlı";
    public static final String emailDomainMustBeSameAsWebSite = "Email domaini web sitesi domainiyle aynı olmalı.";


    // # Validation Messages #
    public static final String infosNotValid = "Bilgileriniz doğrulanamadı.";
    public static final String mailNotVerified = "Mail doğrulanamadı.";


}

