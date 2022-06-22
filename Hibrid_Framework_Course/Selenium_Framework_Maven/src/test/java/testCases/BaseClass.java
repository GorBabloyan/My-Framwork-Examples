package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.util.logging.Logger;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();
    public String url = readConfig.getApplicationURL();
    public String userName = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters ("browser")
    @BeforeClass
    void setup(String br){
        logger = Logger.getLogger("BaseClass");
        PropertyConfigurator.configure("log4j.properties");

        if (br.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        else if (br.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if(br.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else {
            WebDriverManager.iedriver().setup();
            driver= new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterClass
    void tearDown() {
        driver.quit();
        }

    public void captureScreen (String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
    public String randomString(int length){
        String randomEmail = RandomStringUtils.randomAlphabetic(length) ;
        return randomEmail;
    }
    public String randomNum(int length){
        String randomEmail = RandomStringUtils.randomNumeric(length) ;
        return randomEmail;
    }
}
