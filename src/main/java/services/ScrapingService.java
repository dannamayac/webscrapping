package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrapingService
{
    public String getData()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try
        {
            driver.get("https://www.ktronix.com/computadores-tablet/computadores-portatiles/c/BI_104_KTRON");
            Thread.sleep(3000);
            String html = driver.getPageSource();
            driver.quit();

            return html;
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
