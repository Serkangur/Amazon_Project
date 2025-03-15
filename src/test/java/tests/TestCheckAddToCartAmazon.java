package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

import static base.BasePage.delay;

public class TestCheckAddToCartAmazon extends BaseTest {
    HomePage homepage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CartPage cartPage;

    @Test
    public void test_check_amazon_add_to_cart(){
        homepage = new HomePage(driver);
        Assert.assertEquals("You are not on the Amazon home page", base_url, homepage.getCurrentUrl());
        homepage.clickCookieAcceptButton();
        homepage.inputSearchBoxElement("samsung");
        homepage.clickSearchSubmitButton();

        searchResultsPage = new SearchResultsPage(driver);
        Assert.assertTrue("Samsung results not displayed",searchResultsPage.getBreadcrumbText().contains(searchResultsPage.searchWord));
        //Arama kelimesini String olarak tanımlayıp çekmek mantıklımı? (searchResultsPage.searchWord)
        searchResultsPage.goToSecondPage();
        Assert.assertTrue("You are not on page 2",searchResultsPage.getCurrentUrl().contains(searchResultsPage.pageCount));
        //Contains ile doğrulama yapmak doğrumu burada?
        searchResultsPage.selectThirdProduct();

        productPage = new ProductPage(driver);
        Assert.assertTrue("You are not on the product page",productPage.isAddToCartPresent().isDisplayed());
        productPage.clickAddToCart();
        Assert.assertEquals("Product missing or not added to cart", productPage.cartCount,productPage.isProductAdded());
        productPage.clickCartIcon();

        cartPage = new CartPage(driver);
        Assert.assertEquals("You are not on the cart page",cartPage.cart_header,cartPage.isOnCartPage());
        Assert.assertTrue(productPage.savedProductName.contains(cartPage.getCartPageProductTitle()));
        //Assert.assertEquals("Incorrect product added to cart.",productPage.savedProductName,cartPage.cartPageProductTitleText());
        //Yukarıdaki işlemde ürünler dinamik olduğu için hata verebiliyor bazı ürünlerde bundan dolayı Contains kullanmak mantıklımı?
        cartPage.clickDeleteButton();
        Assert.assertEquals("There are products in the cart", cartPage.cartCount,cartPage.isProductDeleted());
        cartPage.clickHomePageLogo();
        Assert.assertEquals("You are not on the Amazon home page", amazon_title, homepage.getHomePageTitle());







    }
}
