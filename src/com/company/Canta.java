package com.company;

import java.util.ArrayList;

public class Canta {
    private ArrayList<Esya> cantadakiEsyalar;
    private int cantaAgirlik;
    private int cantaDegeri;
    private int maxCantaAgirligi=100;



    public Canta(ArrayList<Esya> cantadakiEsyalar) {
        this.cantadakiEsyalar = cantadakiEsyalar;
        cantaAgirlik=0;
        cantaDegeri=0;
    }

    public Canta() {
        cantaAgirlik=0;
        cantaDegeri=0;
        cantadakiEsyalar = new ArrayList<Esya>();
    }

    public ArrayList<Esya> getCantadakiEsyalar() {
        return cantadakiEsyalar;
    }

    public void setCantadakiEsyalar(ArrayList<Esya> cantadakiEsyalar) {
        this.cantadakiEsyalar = cantadakiEsyalar;
    }

    public int getCantaAgirlik() {
        return cantaAgirlik;
    }

    public void setCantaAgirlik(int cantaAgirlik) {
        this.cantaAgirlik = cantaAgirlik;
    }

    public int getCantaDegeri() {
        return cantaDegeri;
    }

    public void setCantaDegeri(int cantaDegeri) {
        this.cantaDegeri = cantaDegeri;
    }

    public int getMaxCantaAgirligi() {
        return maxCantaAgirligi;
    }

    public void setMaxCantaAgirligi(int maxCantaAgirligi) {
        this.maxCantaAgirligi = maxCantaAgirligi;
    }

    public int cantaAgirlikHesapla(){
        cantaAgirlik=0;
        for(int i=0; i<cantadakiEsyalar.size(); i++){
            cantaAgirlik += cantadakiEsyalar.get(i).getAgirlik();
        }

        return cantaAgirlik;
    }

    public int cantaDegeriHesapla(){
        cantaDegeri=0;
        for(int i=0; i<cantadakiEsyalar.size(); i++){
            cantaDegeri += cantadakiEsyalar.get(i).getDeger();
        }
        return cantaDegeri;
    }

    @Override
    public String toString() {
        return "Canta{" +
                "Çanta ağırlığı=" + cantaAgirlik +
                ", Çanta değeri=" + cantaDegeri +
                ", Cantadaki esyalar=" + cantadakiEsyalar +
                '}';
    }



}
