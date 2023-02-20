package com.epam.tc.hw5.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuComponentHW5 {

    @FindBy(partialLinkText = "CONTACT FORM")
    private WebElement contactFormHeaderElement;

    @FindBy(partialLinkText = "SERVICE")
    private WebElement serviceHeaderElement;

    @FindBy(partialLinkText = "METALS & COLORS")
    private WebElement metalColorsHeaderElement;

    public WebElement getServiceHeaderElement() {
        return serviceHeaderElement;
    }

    public void clickOnServiceItem() {
        serviceHeaderElement.click();
    }
}
