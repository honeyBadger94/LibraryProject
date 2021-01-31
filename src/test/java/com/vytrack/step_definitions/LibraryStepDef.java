package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.BookManagementPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utils.ConfigurationReader;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LibraryStepDef {

    LoginPage lp = new LoginPage();
    DashboardPage dp = new DashboardPage();
    BookManagementPage bmp = new BookManagementPage();
    @Given("{string} is on Dashboard page")
    public void is_on_dashboard_page(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        lp.Login(string);
    }

    @When("librarian clicks at the add book button")
      public void librarian_clicks_at_the_add_book_button() {

        dp.navigateToCategories("books");

        bmp.clickOnAddBook();





    }

    @Then("add book windows pops up")
    public void add_book_windows_pops_up() {

        Assert.assertTrue(bmp.popupIsVisible());

    }


    @When("librarian fills all the info")
    public void librarian_fills_all_the_info() {

        bmp.fillOutThePopup();



    }

    @When("clicks save changes button")
    public void clicks_save_changes_button() {
   }

    @Then("system should show the newly added book on the book table")
    public void system_should_show_the_newly_added_book_on_the_book_table() {



    }

   @Then("insertion of the new book should be verified by DB")
    public void insertion_of_the_new_book_should_be_verified_by_db() {

    }

    @Then("insertion of the new book new book should be verified by API")
    public void insertion_of_the_new_book_new_book_should_be_verified_by_api() {

    }

}
