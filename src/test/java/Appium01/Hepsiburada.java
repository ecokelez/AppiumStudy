package Appium01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hepsiburada {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        System.out.println("Hello World!");
        // Appium sunucusuna baglanmak icin gerekli bilgiler
        // DesiredCapabilities nesnesi olusturuluyor
        // Bu nesne test senaryolarinda kullanilacak cihaz ve uygulama ayarlarini tutar

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        //UiAutomator2 otomasyon araci kullanilarak testin yapilacagini belirtir
        //UiAutomator2, Android uygulamalarini test etmek icin kullanilan otomasyon aracidir
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.hepsiburada.ui.startup.SplashActivity");
        //=> APP_ACTIVITY =>Bu özellik ise Android uygulamasının başlatıcı aktivitesini yani launcher aktivitiy belirtir.
        // Launcher Activity - başlatıcı aktivite uygulama başlatıldığında ilk görünen  ana ekran veya giriş ekranıdır.
        // Appium başlatıcı aktiviteyi kullanarak uygulamayı başlatır. Yani bu başlatıcı aktivitiyi kullanarak
        // uygulamayı başlatır. Ve test senaryolarının bu aktiviteden gerçekleştirir.
        // Başlatıcı aktivitenin doğru şekilde belirtilmesi Appiumun test senaryolarının doğru şekilde başlatmasını sağlar.
        // Biz buradan değişiklikler falan yaparsak bu testimiz çalışmaz, uygulamaya gitmez ve bulamaz.
        // Bu 2 özellik APP_ACTIVITY - APP_PACKAGE ;
        // Appiumun test edilecek uygulamaya doğru şekilde tanımlayıp başlatmasını sağlar.Böylece test senaryolarımızı
        // belli bir Android uygulamasında gerçekleştirebilir ve kullanıcı etkileşimlerini test edebiliriz.
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.pozitron.hepsiburada");
        // => APP_PACKAGE=> Test edilmek istenen Android uyg. package adini belirtir.Package adı uygulamanın benzersiz
        // bir kimligini temsil  eder. Appium bu paket adını kullanarak dogru uygulamayı tanımlar ve başlatır.
        // Uygulamanın dogru bir sekilde belirtilmesi Appium testinin başarılı bir şekilde sonuclanmasını saglar.
        //desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\Users\LENOVO\IdeaProjects\AppiumStudy\Apps\Hepsiburada.apk");

        // Appium sunucusuna baglanma Url'ini olusturalim
        AndroidDriver < AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        //=> AndroidDriver < AndroidElement> ifadesi, Appium ile Android uygulama testlerini calistirmak icin kullanilan
        // bir sınıfın ornegini olusturur
        //=> new URL("http://localhost:4723/wd/hub" ifadesi Appium sunucusuna baglanmak icin kullanilan adresi temsil eder.
        //=> desiredCapabilities ise test senaryosunda kullanilan ayarlari iceren bir nesnedir.
        //=> Kod parcasi Appium sunucusuna baglanmayi ve Android uygulama testlerini baslatmayi saglar.
        //=>  AndroidDriver < AndroidElement> sinifi,Appium sunucusuna baglantiyi gerceklestirirken ,
        //  desiredCapabilities nesnesiyle belirtilen ayarlari kullanir.Bu sayede dogru baglanti ve ayarlarla
        //  test senaryolarini calistirabilir ve Android uygulamasini otomatik olarak test edebiliriz.

        Thread.sleep(2000);
        MobileElement searchBox = driver.findElement(By.className("android.widget.EditText"));
        searchBox.click();



    }
}