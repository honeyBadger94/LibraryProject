package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "inputEmail")
    private WebElement inputEmail;

    @FindBy(id ="inputPassword")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;


    public void Login(String email,String password){

        BrowserUtils.enterText(inputEmail,email);
        BrowserUtils.enterText(inputPassword,password);
        BrowserUtils.clickOnElement(submit);


    }

    public void Login(String typeOfUser){
        String userName=null;
        String password=null;
        if(typeOfUser.equalsIgnoreCase("Student")){
            userName=ConfigurationReader.getProperty("student.email");
            password=ConfigurationReader.getProperty("student.password");

        }
        else if(typeOfUser.equalsIgnoreCase("Librarian")){
            userName=ConfigurationReader.getProperty("librarian.email");
            password=ConfigurationReader.getProperty("librarian.password");

        }
        Login(userName,password);

    }



}
