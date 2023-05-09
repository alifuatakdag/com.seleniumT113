package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_IlkTest_AFA {
    public static void main(String[] args) throws InterruptedException {
        // once gerekli ayarlamalari yapip driver objesi olusturmaliyiz
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //4. Sayfa basligini(title) yazdirin
        System.out.println("Sayfanin Basligi : " + driver.getTitle());

        //5. Sayfa basliginin “Amazon” icerdigini test edin
        // yazilim testi beklenen degerlerin gerceklesip gerceklesmedigini test etmektir
        String expectedIcerik = "Amazon";
        String actualIcerik = driver.getTitle();

        if (actualIcerik.contains(expectedIcerik)) {
            System.out.println("Sayfa Basligi Test PASSED");
        } else {
            System.out.println("SAyfa Basligi Test FAILED");
        }

        //6. Sayfa adresini(url) yazdirin
        System.out.println("Sayfanin URL'si: " + driver.getCurrentUrl());

        //7. Sayfa url’inin “amazon” icerdigini test edin.
        expectedIcerik = "amazon";
        actualIcerik = driver.getCurrentUrl();

        if (actualIcerik.contains(expectedIcerik)) {
            System.out.println("Sayfa Url Test PASSED");
        } else {
            System.out.println("SAyfa url Test FAILED");
        }

        //8. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        expectedIcerik = "Turkey";
        actualIcerik = driver.getPageSource();

        if (actualIcerik.contains(expectedIcerik)) {
            System.out.println("Sayfa html Test PASSED");
        } else {
            System.out.println("SAyfa html Test FAILED");
        }

        //10. Sayfayi kapatin.
        Thread.sleep(4000);
        driver.close();

    }
}
