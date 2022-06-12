package com.company;

public class Esya {
    private int deger;
    private int agirlik;
    private boolean cantayaKonduMu;



    public Esya(int deger, int agirlik) {
        this.deger = deger;
        this.agirlik = agirlik;
        cantayaKonduMu=false;
    }

    public int getDeger() {
        return deger;
    }

    public void setDeger(int deger) {
        this.deger = deger;
    }

    public int getAgirlik() {
        return agirlik;
    }

    public void setAgirlik(int agirlik) {
        this.agirlik = agirlik;
    }

    public boolean isCantayaKonduMu() {
        return cantayaKonduMu;
    }

    public void setCantayaKonduMu(boolean cantayaKonduMu) {
        this.cantayaKonduMu = cantayaKonduMu;
    }

    @Override
    public String toString() {
        return "Esya{" +
                "deger=" + deger +
                ", agirlik=" + agirlik +
                '}';
    }
}
