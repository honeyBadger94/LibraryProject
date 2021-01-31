package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class BookManagementPage extends BasePage{

    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")
    private WebElement addBook;

    @FindBy(xpath = "//div[@class='modal-body']")
    private WebElement addBookPopup;

    @FindBy(css = "input[placeholder='Book Name']")
    private WebElement addBookName;

    @FindBy(css = "input[name='year']")
    private WebElement addBookYear;

    @FindBy(css = "input[name='author']")
    private WebElement addBookAuthor;

    @FindBy(css = "select[id='book_group_id']")
    private Select categories;

    @FindBy( css = "input[type='submit']")
    private WebElement saveChanges;

    public String bookName;
    public String year;
    public String authorName;



    public void clickOnAddBook(){
        BrowserUtils.clickOnElement(addBook);
    }

    public boolean popupIsVisible(){

        return addBook.isDisplayed();

    }


    public void fillOutThePopup(){

         Random ran = new Random();

         int x = ran.nextInt(20);

         Faker faker = new Faker();
         bookName = faker.book().title();
         year = ""+(2000+x);
         authorName = faker.book().author();

         BrowserUtils.enterText(addBookName,bookName);
         BrowserUtils.enterText(addBookAuthor,authorName);
         BrowserUtils.enterText(addBookYear,year);

         List<WebElement> arr = categories.getOptions();

        for (int i = 0; i <arr.size() ; i++) {
            System.out.println(arr.get(i).getText());
        }




         BrowserUtils.clickOnElement(saveChanges);
         BrowserUtils.wait(2000);



    }
}
