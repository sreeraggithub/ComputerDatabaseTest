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
public class DeleteComputer {

    @Test(groups = "delete", dependsOnGroups = "create", testName = "Delete of a Computer")
    public void deleteComputerTest() {
        try {

            Properties prop = new DataReader().getThemAll();
            driver.findElement(By.cssSelector("#searchbox")).sendKeys(prop.getProperty("createComputerName"));
            driver.findElement(By.cssSelector("#searchsubmit")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main > table > tbody > tr > td:nth-child(1) > a")));
            driver.findElement(By.cssSelector("#main > table > tbody > tr > td:nth-child(1) > a")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main > form.topRight > input")));
            driver.findElement(By.cssSelector("#main > form.topRight > input")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main > div.alert-message.warning")));
            String confirmMsg = driver.findElement(By.cssSelector("#main > div.alert-message.warning")).getText();
            Reporter.log("Deletion of computer is succesfull!!! confirmationmessage is : " + confirmMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
