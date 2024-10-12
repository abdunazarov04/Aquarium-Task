Aquarium, which is common in multithreading in java.

**⚠️Sizda ortiqcha 15 daqiqa vaqtingiz bo'lsa buni o'qishni maslahat beraman.⚠️**

**UZ** - **Java** dasturlash tilida Thread, umuman olganda Multithreading juda ko'p qo'llaniladi.
_Nega?_
**Sababi Multithreading dastur samaradorligini tubdan o'zgartrib yuborishi mumkin**

_Qanday ?
O'zi thread nima ?,
Bu faqat javada shundaymi ?
Nega multithreading deyiladi ?,
Shu kabi savollar sizda bo'lsa shoshilmang tariflashga harakat qilaman._


Thread to'g'ridan to'gri tarjima qilinganda ip deb aytiladi ammo biz uni tarjima qilmasdan thread deb ketsak odobdan bo'ladi 😊
threadlarni vazifasi sodda qilib aytdanda bir ish buyurilsa uni bajarish, yani aytilgan ishni bajaruvchi ekan.

Multithreading esa threadlarga berilgan tarifni murakkabroq ko'rinishi, 1 ta threadni o'zi aytilgan 1 ishni 10 daqiqada bajarsa
multithreadingda bir qancha threadlar aytilgan 1 ichni 1 daqiqada bajaradi. 

_Nima o'zgardi ?_
Vaqtdan yutildi, yani threadlar ishchi sifatida tasvirlasak 1 ishchi 1 ishni 10 daqiqada bajarsa bir qancha ishchilar 1 ta ishni 1 daqiqada bajaradi,
adashmasam ish tezligi 10 yoki 9 barobarga oshdi.

Threadlar faqat javada mavjudmi ?
Yo'q albatta threadlar ko'plab dasturlash tillarida mavjud.

Endi asosiy mavzuga to'xtalib o'tamiz, Aquarium topshirig'i bu biroz murakkab va threadlar bilan ishlash shart bo'lgan topshiriglar sirasiga kiradi.
----------------------------------------------------------------------------------------------------
**Topshiriq mazmuni:**
    Teshaboy ukasi Boltaboy ga uning tug’ilgan kuniga akvarium bilan baliqlar sovg’a qildi.
    Bir necha kundan so’ng Teshaboyning o’zi ham baliqlarga qiziqa boshladi va o’ziga ham akvarium bilan baliqlar sotib oldi.
    Lekin baliqlarga qarash uchun Teshaboyning yetarlicha bo’sh vaqti yo’q edi. 
    Shuning uchun Teshaboy akvariumda sodir bo’layotgan har bir jarayonni yozib boruvchi dastur tuzishga qaror qildi va yordam uchun bizga murojaat qildi.
    Bizning vazifangiz Teshaboyga dastur tuzishda yordam berish.
    
**Dasturga bo’lgan talablar:**
  - Barcha qiymatlar Random orqali aniqlanishi kerak.
  - Collections lardan foydalanish kerak.
  - Har bir baliq alohida Thread da bo’lishi kerak.
  - Har bir sodir bo’layotgan jarayon haqida Console da xabar chiqish kerak.

**Eslatma:**
  - Dastur tuzish vaqtida akvariumda N ta erkak va M ta urg’ochi baliqlar bor edi. N va M
    qiymati ham Random orqali aniqlanadi.
  - Har bir baliq o’zining yashash muddati mavjud va uning qiymati Random orqali
    aniqlanadi.
  - Agar erkak va urg’ochi baliqlar uchrashib qolishsa ular nasl qoldirishi kerak. Yangi
    tug'ilgan har bir baliqning jinsi Random orqali aniqlanadi.
----------------------------------------------------------------------------------------------------

_Biz talablarni ko'rib chiqdik va yechim qidirishga tushdik._

Bizda asosiy 3 ta class mavjud 
                              {Fish, Aquarium, Main}

Class - Fish
    Bu class bizga baliq yaratilishni taminlovchi sifatida hizmat qiladi.
    
Class - Aquarium
    Bu class bizga Fishlarni yani baliqlarni jamlash, tekshirish, yaratish va o'chirish uchun kerak.
    
Class - Main 
    Bu bizning asosiy classimiz Fish hamda Aquariumni yaratish va dasturni ishga tushirish uchun yordam beradi.


**Endi har bir classda qanday functionlari mavjudligi haqida.**
_Fish classi._

  Bizga shart davomida aytilganki har bir baliq alohida bir thread bo'lib yaratilishi kerak bunda biz **Fish extends Thread _yoki_ Runnable** dan foydalanishimiz mumkin.

Asosiy o'zgaruvchilar.
        _fishGender - baliq jinsi.
        fishLifeSpan - baliq umri.
        akvarium - baliqning akvariumi._
va biz bu o'zgaruvchilarga qiymatlarni Constructor orqali berishga majburmiz.

Asosiy methodlar.
       getFishGender() - baliqning jinsini olish yoki tekshirish uchun kerak.
       run() thread ishga tushishi uchun @Override qilinadi.
       agar run methodidagi logikaga qiziqsangiz koddan ko'rishingiz mumkin.
       
_Aquarium classi._
  Berilgan shart bo'yicha talablarni bajarishni boshlaymiz.
  
Asosiy o'zgaruvchilar.
      listOfFish - bu baliqlarni saqlash uchun List turida CopyOnWriteArrayList (nega boshqa thread safe Collectionlar yo'qmi?
      bor albatta misol uchun Vector collectoni bir qancha ustunliklari mavjuda ammo bizga kerakli natija bera olmasligi mukin.
      Agar ko‘p o‘qish va kam yozish operatsiyalari mavjud bo‘lsa, CopyOnWriteArrayList samaraliroq va xavfsizroq.)
      Agar o‘qish va yozish operatsiyalari teng yoki yozishlar ko‘proq bo‘lsa, Vector ko‘proq ma'qul bo‘lishi mumkin, chunki u nusxa yaratmasdan yozadi.
      random - bu bir qancha random raqam va boshqa turdagi ammalarni olishimiz uchun.
Asosiy methodlar.
      addFish() - bu method bizga yangi baliqni akvariumga qo'shish uchun.
      removeFish - bu baliq o'lgandan so'ng akvariumdan uni o'chirib yuborish uchun.
      checkForMate - bu ikki baliq uchrashgan yoki uchrashmaganligini tekshirish uchun.
      createNewFish() - bu yangi baliq yaratish uchun.
      
_Main classi_
    Bu classda biz yozgan classlarimizni ishlatib koramiz. Agarda sizga bu qiziq bo'lsa kodni yaxshilab analiz qilishingizni so'rab qolamiz. Rahmat
