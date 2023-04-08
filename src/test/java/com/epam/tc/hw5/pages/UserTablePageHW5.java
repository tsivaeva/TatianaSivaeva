package com.epam.tc.hw5.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class UserTablePageHW5 extends MainPageHW5 {

    public UserTablePageHW5(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "tbody > tr")
    private List<WebElement> listTypeDropdowns;

    @FindBy(css = "td > a")
    private List<WebElement> listUsers;

    @FindBy(css = ".user-descr")
    private List<WebElement> listImages;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private List<WebElement> listCheckboxes;

    @FindBy(xpath = "//*[@class = 'panel-body-list logs']//li")
    private List<WebElement> logs;

    @FindBy(css = "[class='user-descr']")
    private List<WebElement> descInTable;

    @FindBy(xpath = "//td[1]")
    private List<WebElement> numberInTable;

    public List<WebElement> getlistTypeDropdowns() {
        return listTypeDropdowns;
    }

    public List<WebElement> getListUsers() {
        return listUsers;
    }

    public List<WebElement> getListImages() {
        return listImages;
    }

    public List<WebElement> getListCheckboxes() {
        return listCheckboxes;
    }

    public List<String> getUserRightsDropdownOptions() {
        listTypeDropdowns.get(0).click();
        return webDriver.findElements(By.xpath("//tr[2]/td[2]/select/option"))
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void selectVipCheckBox(String name) {
        String xpath = "//a[contains(text(),'%s')]" +
                "/ancestor::td/ancestor::tr//div[@class='user-descr']/input[@type='checkbox']";
        webDriver.findElement(By.xpath(String.format(xpath, name))).click();
    }

    public void assertNumberOfLogItems(int numOfLogs) {
        assertThat(logs.size()).isEqualTo(numOfLogs);
    }

    public boolean isLogWithTextDisplayed(String logText) {
        return webDriver.findElement(By.xpath("//li[contains(. ,'" + logText + "')]")).isDisplayed();
    }

    public List<String> getUserInTableValues() {
        return listUsers.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getNumberInTableValues() {
        return numberInTable.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getDescInTableValues() {
        return descInTable.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .map(n -> n.replaceAll("\\s", " "))
                .map(n -> n.replaceAll("Vip", " "))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
