package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
    @Test
    public void testCase01() throws InterruptedException{

       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        Thread.sleep(5000);
        WebElement name = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[1]")));
        name.click();
        name.sendKeys("Crio Learner");
        WebElement textarea=driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        textarea.click();
        long epochTime = System.currentTimeMillis() / 1000L;
        textarea.sendKeys("I want to be the best QA Engineer! " +epochTime);

        WebElement testingExp=driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[1]"));
        testingExp.click();

        WebElement selectJava=driver.findElement(By.xpath("//span[contains(text(),'Java')]"));
        selectJava.click();
        WebElement selectSelenium=driver.findElement(By.xpath("//span[contains(text(),'Selenium')]"));
        selectSelenium.click();
        WebElement selectTestNg =driver.findElement(By.xpath("//span[contains(text(),'TestNG')]"));
        selectTestNg.click();
        WebElement dropdown =driver.findElement(By.xpath("//span[contains(text(),'Choose')]"));
        dropdown.click();
        Thread.sleep(3000);
        WebElement Mr= driver.findElement(By.xpath("//div[@role='option']//span[text()='Mr']"));
        //(//div[@role='option']//span)[2]
       Mr.click();
    // Thread.sleep(3000);
    //  WebElement Mr = driver.findElement(By.xpath("//span[normalize-space(text())='Mr']"));
    //  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Mr);


        WebElement selectdate = driver.findElement(By.xpath("//input[@aria-labelledby='i50']"));
        selectdate.click();
        Thread.sleep(3000);
        LocalDate sevenDaysBefore = LocalDate.now().minusDays(7);
        System.out.println(sevenDaysBefore);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(dtf);
        String formattedDate = sevenDaysBefore.format(dtf);
        System.out.println(formattedDate);
        Thread.sleep(3000);
        selectdate.clear();
        selectdate.sendKeys(formattedDate);
        
        

        WebElement hourtxtBox=driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Hour']")));
        hourtxtBox.click();
        hourtxtBox.sendKeys("07");
        Thread.sleep(3000);
        WebElement minutetxtBox=driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Minute']")));
        minutetxtBox.click();
        minutetxtBox.sendKeys("30");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Submit']")).click();

        Thread.sleep(2000);
        WebElement successmsg=driver.findElement(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']"));
        System.out.println(successmsg.getText());

    }
}