package devops;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class amazon {
    public WebDriver driver;
    @Test
    @Parameters({"bname"})
    public void crossBrowseTest(String bname) throws MalformedURLException, InterruptedException {
        System.out.println("Remote driver connectivity is started");
        //session will create on local machine
        if(bname.equals("Chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
            System.out.println("session created on chrome");
        }
        else if(bname.equals("FireFox"))
        {
            FirefoxOptions options = new FirefoxOptions();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
            System.out.println("session created on firefox");
        }
        else if(bname.equals("Edge"))
        {
            EdgeOptions options = new EdgeOptions();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
            System.out.println("session created on Edge");
        }
        System.out.println("Remote driver connectivity is completed");
        Thread.sleep(10000);
        driver.get("https://www.amazon.in/");
        Thread.sleep(6000);
        driver.findElement(By.linkText("Best Sellers")).click();
        System.out.println("Title:-"+driver.getTitle());
        driver.quit();

    }
}
