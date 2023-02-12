package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.pages.components.HeaderMenuComponent;
import com.epam.tc.hw3.pages.components.SideMenuComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    private HeaderMenuComponent headerMenuComponent;

    private SideMenuComponent sideMenuComponent;

    @FindBy(css = "[class='icons-benefit icon-practise']")
    private WebElement iconPractise;

    @FindBy(css = "[class='icons-benefit icon-custom']")
    private WebElement iconCustom;

    @FindBy(css = "[class='icons-benefit icon-multi']")
    private WebElement iconMulti;

    @FindBy(css = "[class='icons-benefit icon-base']")
    private WebElement iconBase;

    @FindBy(className = "benefit-icon")
    private List<WebElement> listOfImages;


    @FindBy(className = "benefit-txt")
    private List<WebElement> listOfTests;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(partialLinkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        headerMenuComponent = new HeaderMenuComponent();
        sideMenuComponent = new SideMenuComponent();
        PageFactory.initElements(webDriver, headerMenuComponent);
        PageFactory.initElements(webDriver, sideMenuComponent);
    }

    public HeaderMenuComponent getHeaderMenuComponent() {
        return headerMenuComponent;
    }

    public SideMenuComponent getSideMenuComponent() {
        return sideMenuComponent;
    }

    public WebElement getIconPractise() {
        return iconPractise;
    }

    public WebElement getIconCustom() {
        return iconCustom;
    }

    public WebElement getIconMulti() {
        return iconMulti;
    }

    public WebElement getIconBase() {
        return iconBase;
    }

    public List<WebElement> getListOfImages() {
        return listOfImages;
    }

    public List<WebElement> getListOfTests() {
        return listOfTests;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public WebElement getDifferentElements() {
        return differentElements;
    }

}
