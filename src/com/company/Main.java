package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

        /*
            KNAPSACK (SIRTÇANTASI) PROBLEMİ
            Kromozomlar sınıfı içerisinde bir Linkedlist içerisinde kromozomlar(çantalar tutuluyor.)
            Çantalar belirli bir ağırlı geçemez. Çantalar içerisinde esya bulundurur.
            Çantaların kaç eşya bulundurduğu önemli değildir. Önemli olan eşyaların ağırlıkları toplamı
            çantanın maxKapasitesini geçmiyor olmasıdır.
            Böylelikle çantaları rastgele eşleştirme(üreme) yaparak yeni çantalar oluşturuyoruz.
            Çantalar max kapasiteyi aşmayacak şekilde en yüksek değerli eşyaları bulana kadar işlem devam ediyor.
        */




        final long startTime = System.nanoTime();
        int kromozomSayisi = 100;  // Kromozom sayısını buradan değiştirebiliriz.
        List<Esya> esyaListesi = getEsyaList(); // 100 elemanı var. 0-99

        //WARNING! Eşyaların çantaya 2 kez konma durumu düzeltilecek.
        // Kromozom sayisi kadar Kromozomu(Çantayı) yaratıyoruz.
        //Çantanın içine rastgele eşyalar konuluyor.
        Random random = new Random();
        Kromozomlar kromozomlar = new Kromozomlar();
        for (int i=0; i<kromozomSayisi; i++){

            Canta canta = new Canta(new ArrayList<Esya>());
            int cantaAgirlikKontrol = 0;
            while( canta.cantaAgirlikHesapla()<=canta.getMaxCantaAgirligi() ){
                int rastgeleSayi = random.nextInt(100); //0-99 arası sayi
                cantaAgirlikKontrol = esyaListesi.get(rastgeleSayi).getAgirlik() + canta.getCantaAgirlik();
                if( cantaAgirlikKontrol>canta.getMaxCantaAgirligi() ) break;
                canta.getCantadakiEsyalar().add( esyaListesi.get(rastgeleSayi) );
            }
            canta.cantaDegeriHesapla();
            kromozomlar.getKromozomArray().add(i,canta);
        }
        kromozomlar.kromozomSirala();



        /*for (Canta c:kromozomlar.getKromozomArray()
             ) {
            System.out.println(c.toString());
        } */

        int generation=0;
        int enIyiKromozomDegeri=0;
        int enIyiKromozomDegismedi=0;
        Kromozomlar kromozomlarYeni = new Kromozomlar();
        while (true){
            kromozomlarYeni = new Kromozomlar();
            int yuzde5KromozomSayisi = (5*kromozomSayisi)/100;
            // En sonda bulunan yakınlık seviyesi en yüksek elemanaları alıyoruz. Elitizm
            for(int t=0; t<=yuzde5KromozomSayisi;t++ ) kromozomlarYeni.getKromozomArray().add(t,kromozomlar.getKromozomArray().get(t));
            enIyiKromozomDegeri = kromozomlarYeni.getKromozomArray().getFirst().cantaDegeriHesapla();
            int rastgeleSayi = random.nextInt(99);
            for(int t=yuzde5KromozomSayisi;t<kromozomSayisi-1;t++){
                kromozomlarYeni.getKromozomArray().add(
                kromozomlarYeni.ureme( kromozomlar.getKromozomArray().get(rastgeleSayi),kromozomlar.getKromozomArray().get(t-5) )
                                                      );
                kromozomlarYeni.getKromozomArray().get(t).cantaAgirlikHesapla();
                kromozomlarYeni.getKromozomArray().get(t).cantaDegeriHesapla();
            }

            kromozomlarYeni.kromozomSirala();
            kromozomlarYeni.mutasyon(esyaListesi);

            int enIyiYeniKromozomDegeri = kromozomlarYeni.getKromozomArray().getFirst().cantaDegeriHesapla();
            //System.out.println("generasyon="+generation+" "+enIyiYeniKromozomDegeri+" "+enIyiKromozomDegeri);
            if( !(enIyiYeniKromozomDegeri>enIyiKromozomDegeri) ) {
                enIyiKromozomDegismedi++;

                if (enIyiKromozomDegismedi>=25) break;  // Kaç adımda burakılacağı.
            }
            else enIyiKromozomDegismedi=0;
            generation++;
            kromozomlar=kromozomlarYeni;
            for(int m=0;m<5;m++) System.out.println("m="+m+" "+kromozomlarYeni.getKromozomArray().get(m).toString());
            System.out.println("        ");
        }






        System.out.println("         ");
        for(int i=0;i<99;i++) System.out.println(kromozomlarYeni.getKromozomArray().get(i).toString());
        System.out.println(generation+" jenerasyon yapıldı.");


    }

    private static List<Esya> getEsyaList() {
        List<Esya> esyaListesi = new ArrayList<Esya>();
        Random random = new Random(); //instance of random class

        for (int i=0; i<50; i++){  // ağırlığı 1-16 arası 50 adet esya üretildi.
            int rastgeleDeger = random.nextInt(25);
            //generate random values from 0-25
            int rastgeleAgirlik = random.nextInt(15);
            esyaListesi.add( new Esya( rastgeleDeger+1, rastgeleAgirlik+1 ) );
        }

        for (int j=0; j<25; j++){  // ağırlığı 1-21 arası 50 adet esya üretildi.
            int rastgeleDeger = random.nextInt(50);
            //generate random values from 0-25
            int rastgeleAgirlik = random.nextInt(20);
            esyaListesi.add( new Esya( rastgeleDeger+1, rastgeleAgirlik+1 ) );
        }

        for (int j=0; j<25; j++){  // ağırlığı 1-26 arası 50 adet esya üretildi.
            int rastgeleDeger = random.nextInt(75);
            //generate random values from 0-25
            int rastgeleAgirlik = random.nextInt(25);
            esyaListesi.add( new Esya( rastgeleDeger+1, rastgeleAgirlik+1 ) );
        }
        return esyaListesi;
    }
}
