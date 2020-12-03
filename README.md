# Bookstore Application

Uygulama özellikleri:
* Yazar Tanımı yapılabilir. ( Yazar Adı, Açıklama )
* Yayınevi Tanımı yapılabilir. ( Yayınevi Adı, Açıklama )
* Kitap tanıtımı yapılabilir. ( kitap adı, kitap alt adı, kitap seri adı, yazar, yayın evi, isbn numarası, açıklama )
* Bir Yazar için n tane kitap tanımlanabilir.
* Bir Yayınevi için n tane kitap tanımlanabilir.
* Kitap adı, Seri adı, Yazar ya da ISBN ile arama yapabilir.
* Var olan bir kayıt üzerinde değişiklik yapılabilir.
* Var olan kayıtlar incelebilir.
* Var olan bir kayıt silinebilir.
* Kullanıcılar sisteme kayıt olabilir.
* Kullanıcılar sisteme kullanıcı adı/parola ile giriş yapılabilir.

### Kullanılan Teknolojiler ve Araçlar
#### Backend
* Java 8
* Spring Boot  (Spring Web MVC, Spring Data JPA)
* Spring Security
* MySQL
* Maven 


#### Frontend
* Javascript
* Thymeleaf

"Tasarımda Nice Admin temasından faydalanılmıştır."


## :package: Maven ile Kurulum

Kuruluma başlamadan önce "application.properties" içindeki veritabanı bağlantısı güncellenmelidir.

Proje Dosyasında:

* `mvn compile`
* `mvn package`

## :clipboard: Çalıştırma

Proje Dosyasında:
```console
java -jar target/bookstoreapp-0.0.1-SNAPSHOT.jar
```

## Teknik Seçimler ve Kabuller
* Her kitabın bir yazarı olması gerektiği kabul edildi.
* Her kitabın bir yayınevi olması gerektiği kabul edildi.
* Önceki gerekliliklerden dolayı tüm kitapları silinmeyen bir yazar silinememektedir.
* Önceki gerekliliklerden dolayı tüm kitapları silinmeyen bir yayınevi silinememektedir.
* Projeye herkesin üye olabileceği kabul edildi.

### UI
Uygulamadan bazı ekran görüntüleri.
* Login Page:

*/login*

![LoginPage](https://user-images.githubusercontent.com/24254922/101061525-a63db200-35a1-11eb-9552-fb10177f6e60.png)
___
* Signup Page:

*/register*
![SignupPage](https://user-images.githubusercontent.com/24254922/101061537-a9d13900-35a1-11eb-9e8f-f42f851f4fb6.png)
___
* Home Page:

*/index*
![HomePage](https://user-images.githubusercontent.com/24254922/101061547-ad64c000-35a1-11eb-98dc-04fe08acb8cd.png)
___
* Bookstore Page:

*/bookstories*

![bookstorePage](https://user-images.githubusercontent.com/24254922/101061522-a5a51b80-35a1-11eb-8f43-8c9cb1f599b5.png)
___
* Edit Bookstore Popup:

*/bookstories*
![editBookstore](https://user-images.githubusercontent.com/24254922/101061523-a5a51b80-35a1-11eb-8319-e2aab20d5d6a.png)
___
* Author Page:

*/authors*

![authorPage](https://user-images.githubusercontent.com/24254922/101061520-a50c8500-35a1-11eb-8f85-77af359f9f57.png)
___
* Edit Author Popup:

*/authors*
![editAuthor](https://user-images.githubusercontent.com/24254922/101063198-98892c00-35a3-11eb-9ce3-1457da4d8999.png)
___
* Books Page:

*/books*
![BookPage](https://user-images.githubusercontent.com/24254922/101061508-a342c180-35a1-11eb-8bb6-1cc99a0220e5.png)
___
* Edit Book Popup:

*/books*
![editBook](https://user-images.githubusercontent.com/24254922/101061515-a473ee80-35a1-11eb-9b46-42ac1ce7db87.png)
___
* Details Book Popup:

*/books*
![BookDetails](https://user-images.githubusercontent.com/24254922/101061517-a473ee80-35a1-11eb-8593-61b17fb108f1.png)



## Eklenecek Özellikler ve Düzeltilecek Kısımlar
* Bir yetkilendirme mekanizması eklenecek.
* Yayınevinden kitap çıkarmış yazarları listeleme özelliği eklenecek.
* Listeleme ekranlarına sayfalama özelliği eklenecek.
* Kayıtlara oluşturulma ve güncelleme hakkında özellikler(CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate) eklenecek.
* Eksik testler yazılacak ve düzeltilecek.
___
