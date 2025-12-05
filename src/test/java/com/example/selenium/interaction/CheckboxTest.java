package com.example.selenium.interaction;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class CheckboxTest {
    private WebDriver driver;
    private CheckboxPage checkboxPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless=new");
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkboxPage = new CheckboxPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCheckboxes() {
        // Checkbox 1 is initially unchecked
        assertFalse(checkboxPage.checkbox1.isSelected(), "Checkbox 1 should be initially unchecked");
        
        // Checkbox 2 is initially checked
        assertTrue(checkboxPage.checkbox2.isSelected(), "Checkbox 2 should be initially checked");

        // Click Checkbox 1 to check it
        checkboxPage.checkbox1.click();
        assertTrue(checkboxPage.checkbox1.isSelected(), "Checkbox 1 should be checked after click");

        // Click Checkbox 2 to uncheck it
        checkboxPage.checkbox2.click();
        assertFalse(checkboxPage.checkbox2.isSelected(), "Checkbox 2 should be unchecked after click");
    }
}
