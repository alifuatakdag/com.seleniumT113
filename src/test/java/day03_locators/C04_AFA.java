package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AFA {
    public static void main(String[] args) throws InterruptedException {


        // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        // 3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkListi = driver.findElements(By.tagName("a"));
        int actualLinkSayisi = linkListi.size();
        System.out.println("' " + actualLinkSayisi + " ' adet link vardir.");

        int expectedLinkSayisi = 147;

        if(actualLinkSayisi==expectedLinkSayisi){
            System.out.println("Link Sayisi Testi PASSED");
        }else {
            System.out.println("Link Sayisi Testi FAILED");
        }
        // 4- Products linkine tiklayin
        WebElement produckLinki = driver.findElement(By.partialLinkText("Products"));
        produckLinki.click();
        // 5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferYazisi = driver.findElement(By.id("sale_image"));
        if(specialOfferYazisi.isDisplayed()){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        // 6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();


    }
}
