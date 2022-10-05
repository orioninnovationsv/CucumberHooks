# Proje Hakkında 

- Cucumber framework kullanbilmek adına pom.xml dosyasına gerekli dependency eklendi.
- Cucumber için feature dosyası oluşturulup içerisine test senaryolarımızı yazdık.
- Testleri çalıştırabilmek için CucumberRunner sınıfı oluşturuldu. (Sınıf içerisindeki keywordler için Cucumber Options kısmına bakabilirsiniz)
- Oluşturduğumuz test senaryoları için stepDefinition paketi açılıp içindeki sınıflarda methodlar tanımlandı.
- Driver class'ı oluşturuldu ve WebDriver objesini global olarak her class içersinde kullanabilir hale geldik.
Daha iyi anlayabilmek adına Java instance vs static konusu araştırılabilir.
- Page Object Model kullanımı için pages package oluşturulup trendyoldaki sayfalar için class oluşturuldu. 
- Oluşturulan bu sınıflarda constructor kullanılarak PageFactory sınıfı (@FindBy) anotasyonu kullanılabilir hale getirildi. 
- Feature içerisinde farklı test senaryoları oluşturuldu. Bu senaryolar çoğaltılıp uygun step definition ile testler koşulabilir.
- Feature içersinde senaryolara belirli @tagName verilerek hem ayrı ayrı hem de Feature üzerindeki @tagName ile toplu olarak test koşulabilir.


---------------------------------------------------------------



## Cucumber Options

- plugin : Raporlama kısmı için (html,allure,cucumberReport) kullanılıyor.
- features : Oluşturduğumuz feature dosyalarının konumunu girmek böylelikle koşulacak testlerin konumunu Runner sınıfında belirtmek için kullanıyoruz.
- glue : Test senaryolarının konumunu belirttiğimiz gibi bu ilgili senaryolara ait methodların bulunduğu paketin de konumunu belirtmek için kullanıyoruz.
- tags : Feature dosyası içerisinde dosyanın tümünü kapsayabilecek (Feature keyword üstüne) yada senaryoları ayrı ayrı koşabilmek için (Scenario üstüne) tag kullabiliyoruz. 
Runner sınıfı içerisinde ise hangi tag'i çalışturmak istediğimizi belirtiyoruz.



---------------------------------------------------------------

## Page Object Model Faydaları

- POM kullanarak web sayfasını class formatına çevirebiliyor ve böylece ilgili webelement'leri locate edebiliyoruz.
- Web elementleri test anotasyonları altında her seferinde driver.findElement() kullanarak bulmak yerine POM kullanarak bulduğumuzda elementi bir kere locate edilip istediğmiz kadar kullanabiliyoruz.
- Element üzerinde developer tarafından yapılacak bir değişiklik durumunda test caselerin çalışmasını etkilemeden sadece page class içerisindeki locator değiştirilebilir.  
- Locate edilen bu webelementleri doğrudan yada yine class içerisinde oluşturulan methodlar ile kullanabiliyoruz. (login() methodu ile birden fazla elementi kullandık)
- Web elementleri method ile kullanmak aynı zamanda gerektiğinde method ile parametre alarak farklı senaryoları tek method ile çözebilmemizi sağlıyor.
CommonPage navigateCategory() methodu ile bütün kategorileri ayrı ayrı locate etmek yerine kategoriler listesi içerisinde parametreye uygun olan kategoriyi seçebiliyoruz. 
