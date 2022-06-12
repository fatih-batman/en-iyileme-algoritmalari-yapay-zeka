# en-iyileme-algoritmalari-yapay-zeka
genetic-algorithms
Genetik algoritmalar ile Knapsack probleminin çözümü.
Bir çantanın belirli bir eşya alma kapasitesi vardır. 
Bu çantaya elimizdeki eşyalar arasından öyle bir yerleştirme yapmalıyız ki çanta kapasiteyi geçmemeli ve içerisinde en değerli eşyaları barındırmalı.
Biz problemimizde 100 kg(değişken yoluyla projede değiştirilebilir) kapasitesi olan çantalar oluşturduk.
Belli bir değere ve ağırlığa sahip eşyalar döngüler içerisinde belli sayılar aralığında ve tamamen rastgele oluşturulacak.
Bir listede tutulup kromozom içerisine rastgele yerleştirilecek.
Eşya Sınıfı
Knapsack probleminde çantaya koyulacak olan eşyaların belirli nitelikleri var: Eşyanın ağırlığı ve eşyanın değeri ve çantaya konup konmamış olma durumu.
Çanta Sınıfı
Bir çanta içinde eşyaları barındıracak. Çantaların belli bir kapasitesi var ve bu kapasiteden fazla ağırlıkta eşya çantaya konulamaz.
Kromozom Sınıfı
Bu sınıf içerisinde Kromozom listesini tutuyor. Her bir kromozom aslında bir çantayı ifade ediyor.
Çanta değerliği fazla olan kromozomlar listenin en sonuna itiliyor. Böylelikle ilerde bir elitizm uygulanabilecek.
Bir kromozomun belirli sayıda bir geni olmayacak. Çünki knapsack probleminde önemli olan çantadaki eleman sayısı değil çantanın ağırlığı.
Main
Burada öncelikle 100 kadar eşyayı rastgele oluşturdum. İlk 50 adeti ağırlığı 1-16 arası, değeri ise 1-26 arası değişiyor.
İkinci 25 adeti ağırlığı 1-21 arası, değeri ise 1-51 arası değişiyor. Üçüncü 25 adeti ağırlığı 1-26 arası, değeri ise 1-76 arası değişiyor.
Üçüncü grubun değerinin fazla olması çantada daha olması istenen eşyaların yaratılması demek.
Rastgele oluşturulan eşyalar yaratılan çantalara rastgele olarak yerleştiriliyor ve bu çantalar kendi içinde en değerliden en değersize 
doğru sıralanıyor.
Şimdi Elimizde belirli sayıda(100) kromozom(çanta) var ve değerlerine göre sıralandılar. Bu noktaya kadar projenin kodları yazıldı.
Projenin devamında üreme yapılarak mevcut kromozomlardan yeni kromozomlar elde ediliyor. Sıralanmış kromozomlardan daha değerli olanlar 
kullanılarak elitizm yapıldı(%5). Rastgele mutasyonlar gerçekleşecek.
Değeri daha yüksek ve ağırlığı belirli bir ağırlıktan(100 kg) daha az olan yeni çantalar üretildi. Bu çantalarda kendi içinde sıralandı.
Sonuç olarak en mantıklı tercihler ve alternatifler elimizde kaldı.

![image](https://user-images.githubusercontent.com/78312646/173236094-50ee729a-cd1b-40ca-abb8-951b54b47cce.png)
