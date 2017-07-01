/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import static Tests.GenericClass.driver;
import static Tests.GenericClass.wait;
import computerdatabasetest.DataReader;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 *
 * @author sreer
 */
public class UpdateComputer {
    @Test(groups = "update", dependsOnGroups = "delete", testName = "Update of a Computer")
    public void updateComputerTest() {
        try {
            Properties prop = new DataReader().getThemAll();
            driver.findElement(By.linkText("Add a new computer")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
            driver.findElement(By.id("name")).sendKeys(prop.getProperty("updateComputerName"));
            driver.findElement(By.id("introduced")).sendKeys(prop.getProperty("updateComputerIntro"));
            driver.findElement(By.id("discontinued")).sendKeys(prop.getProperty("updateComputerDisco"));
            driver.findElement(By.id("company")).sendKeys(prop.getProperty("updateComputerCompany"));
            driver.findElement(By.cssSelector("#main > form > div > input")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main > div.alert-message.warning")));
            driver.findElement(By.cssSelector("#searchbox")).sendKeys(prop.getProperty("updateComputerName"));
            driver.findElement(By.cssSelector("#searchsubmit")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main > table > tbody > tr > td:nth-child(1) > a")));
            driver.findElement(By.cssSelector("#main > table > tbody > tr > td:nth-child(1) > a")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("company")));
            driver.findElement(By.id("company")).sendKeys(prop.getProperty("updateComputerCompanyNew"));
            driver.findElement(By.xpath(prop.getProperty("xpathButton"))).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main > div.alert-message.warning")));
            String confirmMsg = driver.findElement(By.cssSelector("#main > div.alert-message.warning")).getText();
            Reporter.log("Update of computer is succesfull!!! confirmationmessage is : " + confirmMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
