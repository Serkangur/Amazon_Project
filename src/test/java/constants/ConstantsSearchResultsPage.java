package constants;

import org.openqa.selenium.By;

public class ConstantsSearchResultsPage {
    public static By breadCrumbText= By.className("a-color-state");
    public static By secondPage= By.xpath("//a[@aria-label=\"2 sayfasına git\"]");
    public static By otherPageList=By.xpath("//a[@aria-label=\"Sonraki sayfaya git, sayfa 2\"]");
    public static By thirdProduct=By.xpath("(//img[@class=\"s-image\"])[3]");
    public static By cartCountValue=By.id("nav-cart-count");
    public static By pageList= By.cssSelector(".s-pagination-item");


}
