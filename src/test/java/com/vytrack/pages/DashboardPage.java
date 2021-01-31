package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    public void navigateToCategories(String categoryName){

        String xPath = "//a[@href='#"+categoryName+"']";

        WebElement element= Driver.getDriver().findElement(By.xpath(xPath));

        BrowserUtils.clickOnElement(element);
    }

}
