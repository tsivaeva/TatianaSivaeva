package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.components.HeaderMenuComponentHW5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageHW5 extends MainPageHW5 {

    private final HeaderMenuComponentHW5 headerMenuComponent;

    @FindBy(partialLinkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;

    public HomePageHW5(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        headerMenuComponent = new HeaderMenuComponentHW5();
        PageFactory.initElements(webDriver, headerMenuComponent);
    }

    public HeaderMenuComponentHW5 getHeaderMenuComponent() {
        return headerMenuComponent;
    }

    public WebElement getDifferentElements() {
        return differentElements;
    }

    public void clickServiceMenuItem(String item) {
        WebElement serviceMenuItem = webDriver.findElement(By.xpath("//a[contains(text(),'" + item + "')]"));
        serviceMenuItem.click();
    }
}
