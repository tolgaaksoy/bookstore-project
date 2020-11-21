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

## Eklenecek Özellikler ve Düzeltilecek Kısımlar
* Bir yetkilendirme mekanizması eklenecek.
* Yayınevinden kitap çıkarmış yazarları listeleme özelliği eklenecek.
* Listeleme ekranlarına sayfalama özelliği eklenecek.
* Kayıtlara oluşturulma ve güncelleme hakkında özellikler(CreatedBy, CreatedDate, LastModifiedBy, LastModifiedDate) eklenecek.
* Eksik testler yazılacak ve düzeltilecek.
___
