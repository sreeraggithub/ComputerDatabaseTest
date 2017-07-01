/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import static Tests.GenericClass.driver;
import static Tests.GenericClass.wait;
import computerdatabasetest.DataReader;
import computerdatabasetest.DataReader;
import computerdatabasetest.DataReader;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 *
 * @author sreer
 */
public class CreateComputer {
    @Test (groups = "create", testName = "Create a new Computer")
    public void createComputerTest(){
        try {
            Properties prop = new DataReader().getThemAll();
            driver.get("http://computer-database.herokuapp.com/computers");
            driver.findElement(By.linkText("Add a new computer")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
            driver.findElement(By.id("name")).sendKeys(prop.getProperty("createComputerName"));
            driver.findElement(By.id("introduced")).sendKeys(prop.getProperty("createComputerIntro"));
            driver.findElement(By.id("discontinued")).sendKeys(prop.getProperty("createComputerDisco"));
            driver.findElement(By.id("company")).sendKeys(prop.getProperty("createComputerCompany"));
            driver.findElement(By.cssSelector("#main > form > div > input")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main > div.alert-message.warning")));
            String confirmationMsg = driver.findElement(By.cssSelector("#main > div.alert-message.warning")).getText();
            Reporter.log("Creation of computer is succesfull!!! confirmationmessage is : "+confirmationMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       
    }
}
