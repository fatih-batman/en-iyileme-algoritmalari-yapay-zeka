package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Kromozomlar {
    LinkedList<Canta> kromozomArray;

    public Kromozomlar() {
        kromozomArray = new LinkedList<Canta>();
    }

    public LinkedList<Canta> getKromozomArray(){
        return kromozomArray;
    }

    public void setKromozomArray(LinkedList<Canta> newKromozomArray){
        kromozomArray=newKromozomArray;
    }





    @Override
    public String toString() {
        return "Kromozomlar{" +
                "kromozomArray=" + kromozomArray +
                '}';

    }


    // Kromozomu(çantayı) çanta değerine göre en değerliden en değersize doğru sıralama yaptıracağız.
    public void kromozomSirala(){
        for (int i = 0; i < kromozomArray.size(); i++) {
            Canta max = kromozomArray.get(i);
            int maxId = i;
            for (int j = i+1; j < kromozomArray.size(); j++) {
                if (kromozomArray.get(j).getCantaDegeri() > max.getCantaDegeri()) {
                    max = kromozomArray.get(j);
                    maxId = j;
                }
            }
            // swapping
            Canta temp = kromozomArray.get(i);
            kromozomArray.set(i,max);
            kromozomArray.set(maxId,temp);
        }
        return;
        }

    public Canta ureme(Canta parentCanta1,Canta parentCanta2){
        int esyaSayisiParentCanta1 = parentCanta1.getCantadakiEsyalar().size();
        int esyaSayisiParentCanta2 = parentCanta2.getCantadakiEsyalar().size();
        Canta cocuk = new Canta();
        int i = 0;
        while (true) { //While döngüsünü cant agırlığı 100 olcak şekilde ayarla
            int cantaAgirlikKontrol = 0;
            if( (i%2)==0 ) { //0 ise 1. atadan 2 ise 2. atadan gen(Esya) alınıp yavru cantaya konuluyor.
                cantaAgirlikKontrol = parentCanta1.getCantadakiEsyalar().get(i%esyaSayisiParentCanta1).getAgirlik() + cocuk.cantaAgirlikHesapla();
                if (cantaAgirlikKontrol > cocuk.getMaxCantaAgirligi()){
                    cocuk.cantaDegeriHesapla();
                    cocuk.cantaAgirlikHesapla();
                    return cocuk;                                     }
                //System.out.println(cocuk.getCantadakiEsyalar().size());
                cocuk.getCantadakiEsyalar().add( parentCanta1.getCantadakiEsyalar().get(i%esyaSayisiParentCanta1) );
                           }
            else {
                cantaAgirlikKontrol = parentCanta2.getCantadakiEsyalar().get(i%esyaSayisiParentCanta2).getAgirlik() + cocuk.cantaAgirlikHesapla();
                if (cantaAgirlikKontrol > cocuk.getMaxCantaAgirligi()){
                    cocuk.cantaDegeriHesapla();
                    cocuk.cantaAgirlikHesapla();
                    return cocuk;                                     }
                cocuk.getCantadakiEsyalar().add( parentCanta2.getCantadakiEsyalar().get(i%esyaSayisiParentCanta2) );
                 }
            i++;
                    }
    }

    public void mutasyon(List<Esya> esyaListesi){
        Random random = new Random(); //Yüzde 10 oranında mutasyon gerçekleşir.
        for (int i=0; i<kromozomArray.size();i++){
            int deger = random.nextInt(99);
            if(deger>=0 && deger<50) {
                int mutasyonPozisyonu = random.nextInt(kromozomArray.get(i).getCantadakiEsyalar().size()-2 );
                while(true){
                    int yeniHarfMutasyonIndex = random.nextInt( esyaListesi.size()-2 );
                    kromozomArray.get(i).getCantadakiEsyalar().remove(mutasyonPozisyonu);
                    kromozomArray.get(i).getCantadakiEsyalar().add(mutasyonPozisyonu,esyaListesi.get(yeniHarfMutasyonIndex));
                    kromozomArray.get(i).cantaDegeriHesapla();
                    if(kromozomArray.get(i).cantaAgirlikHesapla()<=kromozomArray.get(i).getMaxCantaAgirligi()) break;

                }
            }
        }
        kromozomSirala();
        return;


    }




}
