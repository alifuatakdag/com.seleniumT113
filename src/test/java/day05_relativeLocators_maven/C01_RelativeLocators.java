package day05_relativeLocators_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        //2 ) Berlin’i 3 farkli relative locator ile locate edin

       // driver.findElement(By.xpath("//img[@id="pid7_thumb"]")).click();

        // A - tag img, NYC nin altında


        // B - tag img, BOSTON ın saginda

        WebElement boston = driver.findElement(By.id("pid6_thumb"));
        WebElement berlin2 =driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(boston));

        if(berlin2.getAttribute("id").equals("pid7_thumb")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        // C - tag img, SAYLOR ın üstünde


        //3 ) Relative locator’larin dogru calistigini test edin

        Thread.sleep(3000);
        driver.close();
    }
}
