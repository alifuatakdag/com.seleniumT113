package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2- Add Element butonuna basin
        WebElement addElementButtonu = driver.findElement(By.xpath("//button[@onclick]"));
        addElementButtonu.click();
        Thread.sleep(2000);
        addElementButtonu.click();
        Thread.sleep(2000);
        addElementButtonu.click();
        Thread.sleep(2000);
        addElementButtonu.click();

        //3- Delete butonu’nun gorunur oldugunu test edin //button[@class="added-manually"]
        WebElement deleteButtonElement = driver.findElement(By.xpath("//button[@class=\"added-manually\"]"));
        if (deleteButtonElement.isDisplayed()){
            System.out.println("Delete buttın test PASSED");
        }else {
            System.out.println("delete button test FAILED");
        }
        Thread.sleep(2000);

        //4- Delete tusuna basin
        deleteButtonElement.click();
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addElementElementi = driver.findElement(By.xpath("//h3"));
        if (addElementElementi.isDisplayed()){
            System.out.println("add element test PASSED");
        }else {
            System.out.println("add elemnet test FAILED");
        }
        Thread.sleep(3000);
        driver.close();
    }
}
