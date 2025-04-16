package pages;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

import static constants.ConstantsSearchResultsPage.*;

public class SearchResultsPage extends BasePage {
    public String searchWord = "samsung";
    public String pageCount = "page=2";

    public SearchResultsPage() {
        super();
    }

    //Retrieves the breadcrumb text from the search results page.
    public String getBreadcrumbText() {
        return getTextMethod(breadCrumbText);
    }

    //Clicks on the second page in the pagination.
    public void goToSecondPage() {
        clickToWebElement(secondPage);
    }

    public void clickToOtherPage(int pageNumber) {
        // Sayının bir eksiğini hesaplayıp, belirtilen sayfa kadar tıklama yapıyoruz
        for (int i = 1; i < pageNumber; i++) {
            clickToWebElement(otherPageList);
            delay(2);
        }
    }

    public void clickOnPaginationItemByIndex(int index) {
        List<WebElement> paginationList = driver.findElements(pageList);

        if (index >= 0 && index < paginationList.size()) {
            try {
                WebElement targetElement = paginationList.get(index);
                targetElement.click();
                System.out.println((index + 1) + ". pagination item’a tıklandı: " + targetElement.getText());
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element hatası alındı, tekrar denenecek...");
                paginationList = driver.findElements(pageList);
                paginationList.get(index).click();
            }
        } else {
            throw new IllegalArgumentException("Geçersiz index: " + index + ". Liste uzunluğu: " + paginationList.size());
        }
    }


    //Clicks on the third product in the search results.
    public void selectThirdProduct() {
        clickToWebElement(thirdProduct);
    }








}



