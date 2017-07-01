/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 *
 * @author sreer
 */
public class GenericClass {
    
    public static WebDriver driver;
    public static WebDriverWait wait;
    
    @BeforeSuite
    public static void openBrowser(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", 
               path.concat("/chromedriver.exe"));
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5000);
    }
    
    @AfterSuite
    public static void closeBrowser(){
        Reporter.log("All test completed succesfully!!!");
        driver.close();
    }
}
