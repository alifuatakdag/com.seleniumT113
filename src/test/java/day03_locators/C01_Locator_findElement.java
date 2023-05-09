package day03_locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
public class C01_Locator_findElement {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // arama kutusuna Nutella yazdirip
        /*
            Test otomasyonu yaparken
            bir webelementi kullanmak istersek 2 seye ihtiyacimiz var
            1- o webelementi benzersiz olarak tarif edebilecegimiz bir locator
            2- bu locator'i soyledigimizde bize web elementi bulup getirecek method
            ornegin amazon sitesindeki arama kutusunun unique tarif edicisi olarak
            id = "twotabsearchtextbox" kullanabiliriz
         */
        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
        // data turu   objenin adi        =  findElement : webelementi bulan method
        //                                   By : webelementi bulacagimiz locator'in turunu yazdigimiz method
        //                                   twotabsearchtextbox : unique tarif icin id attribute degeri
        aramaKutusuElementi.sendKeys("Nutella");
        // istenen webelement'e istenen yaziyi gonderir

        // Enter tusuna basarak arama yapin
        aramaKutusuElementi.submit();
        // istenen web elementi uzerinde enter tusuna basar
        Thread.sleep(7000);
        driver.close();
    }
}