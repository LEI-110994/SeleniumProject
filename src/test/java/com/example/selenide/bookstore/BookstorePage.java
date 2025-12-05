package com.example.selenide.bookstore;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class BookstorePage {

    // Using generic IDs/names based on typical form structures for "Bookstore" example
    // Ideally we would inspect the specific Vaadin demo page if URL was reachable/known perfectly
    @FindBy(id = "book-name")
    private SelenideElement bookNameInput;

    @FindBy(id = "isbn")
    private SelenideElement isbnInput;

    @FindBy(id = "price")
    private SelenideElement priceInput;

    @FindBy(id = "add-button")
    private SelenideElement addButton;

    // Page Factory initialization happens automatically when using Selenide.page() or open() with class
    
    public void addProduct(String name, String isbn, String price) {
        bookNameInput.setValue(name);
        isbnInput.setValue(isbn);
        priceInput.setValue(price);
        addButton.click();
    }
}
