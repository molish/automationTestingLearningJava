package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'user-account user-account_has-ticker_yes user-account_has-accent-letter_yes legouser__current-account i-bem')]")
    private WebElement userMenu;

    @FindBy(css = "div.legouser__menu-header span.user-account__name")
    private WebElement userName;

    @FindBy(xpath = "//*[contains(@class, 'menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_exit')]")
    private WebElement logoutBtn;

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.legouser__menu-header span.user-account__name")));
        String userNameText = userName.getText();
        for (WebElement child : userName.findElements(By.cssSelector("*"))){
            userNameText = userNameText.replaceFirst(child.getText(), "").replaceFirst("\n", "");
        }
        return userNameText;
    }

    public void entryMenu() {
        userMenu.click();
    }

    public void userLogout() {
        logoutBtn.click();
    }
}

