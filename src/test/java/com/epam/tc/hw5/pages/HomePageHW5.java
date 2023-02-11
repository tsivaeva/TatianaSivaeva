package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.components.HeaderMenuComponentHW5;
import com.epam.tc.hw5.pages.components.SideMenuComponentHW5;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageHW5 extends MainPageHW5 {

    private final HeaderMenuComponentHW5 headerMenuComponent;

    private final SideMenuComponentHW5 sideMenuComponent;

    @FindBy(partialLinkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;

    public HomePageHW5(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        headerMenuComponent = new HeaderMenuComponentHW5();
        sideMenuComponent = new SideMenuComponentHW5();
        PageFactory.initElements(webDriver, headerMenuComponent);
        PageFactory.initElements(webDriver, sideMenuComponent);
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
