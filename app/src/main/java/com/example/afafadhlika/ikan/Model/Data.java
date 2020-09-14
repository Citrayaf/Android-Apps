package com.example.afafadhlika.ikan.Model;

public class Data {
    private String nama, password, NoTambak, NamTambak, LuasTambak, JenisIkan, JumlahIkan, BeratBenih, Usia, Pemberian, Tanggal, HasilBerat, TanggalPanen, TotalPakan, Jam; // -> ini sesuaiin sama isi firebase, dan samain. kalo di firebasenya nama ya harus nama, jangan Nama / name
    // gak ada integer dkk, semua string. kecuali ada yang mau dioperasiin harus diubah dulu dari text to string baru ke int
    //tipe data disini sesuaiin sama firebase, kalo di firebase gak ada " " berarti int
    //sek ya tak ngerjain quiz

    public Data() {
    }

    public Data(String nama, String password, String noTambak, String namTambak, String luasTambak, String jenisIkan, String jumlahIkan, String beratBenih, String usia, String pemberian, String tanggal, String hasilBerat, String tanggalPanen, String totalPakan, String jam) {
        this.nama = nama;
        this.password = password;
        NoTambak = noTambak;
        NamTambak = namTambak;
        LuasTambak = luasTambak;
        JenisIkan = jenisIkan;
        JumlahIkan = jumlahIkan;
        BeratBenih = beratBenih;
        Usia = usia;
        Pemberian = pemberian;
        Tanggal = tanggal;
        HasilBerat = hasilBerat;
        TanggalPanen = tanggalPanen;
        TotalPakan = totalPakan;
        Jam = jam;
    }

    public String getJam() {
        return Jam;
    }

    public void setJam(String jam) {
        Jam = jam;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamTambak() {
        return NamTambak;
    }

    public void setNamTambak(String namTambak) {
        NamTambak = namTambak;
    }

    public String getNoTambak() {
        return NoTambak;
    }

    public void setNoTambak(String noTambak) {
        NoTambak = noTambak;
    }

    public String getLuasTambak() {
        return LuasTambak;
    }

    public void setLuasTambak(String luasTambak) {
        LuasTambak = luasTambak;
    }

    public String getJenisIkan() {
        return JenisIkan;
    }

    public void setJenisIkan(String jenisIkan) {
        JenisIkan = jenisIkan;
    }

    public String getJumlahIkan() {
        return JumlahIkan;
    }

    public void setJumlahIkan(String jumlahIkan) {
        JumlahIkan = jumlahIkan;
    }

    public String getBeratBenih() {
        return BeratBenih;
    }

    public void setBeratBenih(String beratBenih) {
        BeratBenih = beratBenih;
    }

    public String getUsia() {
        return Usia;
    }

    public void setUsia(String usia) {
        Usia = usia;
    }

    public String getPemberian() {
        return Pemberian;
    }

    public void setPemberian(String pemberian) {
        Pemberian = pemberian;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getHasilBerat() {
        return HasilBerat;
    }

    public void setHasilBerat(String hasilBerat) {
        HasilBerat = hasilBerat;
    }

    public String getTanggalPanen() {
        return TanggalPanen;
    }

    public void setTanggalPanen(String tanggalPanen) {
        TanggalPanen = tanggalPanen;
    }

    public String getTotalPakan() {
        return TotalPakan;
    }

    public void setTotalPakan(String totalPakan) {
        TotalPakan = totalPakan;
    }
}
