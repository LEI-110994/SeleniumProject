package com.example.selenium.interaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage {
    
    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    public WebElement checkbox1;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    public WebElement checkbox2;

    public CheckboxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
