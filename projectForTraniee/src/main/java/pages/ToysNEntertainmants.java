package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToysNEntertainmants extends BasicPage {

	public ToysNEntertainmants(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	
	}
	public Actions actions = new Actions(driver);
	
	// navigator for toys and entertaiments
	public WebElement navForToysNE() {
		return this.driver.findElement(By.xpath("//*[@id=\"desktop-category-nav\"]/div[1]/div/ul/li[5]/a"));
	}
	//navigator for art and photography books
	public WebElement navForANF(){
		return this.driver.findElement(By.id("catnav-l4-11069"));
	}
	// get for filters
	public WebElement getForFilters() {
		return this.driver.findElement(By.xpath("//*[@id=\"search-filter-button\"]/span[2]"));
	}
	//select  from filters for free shipping
	public WebElement getForFreeShip() {
		return this.driver.findElement(By.id("special-offers-free-shipping"));
	}
	//select for price
	public WebElement getForPrice() {
		return this.driver.findElement(By.id("price-input-1"));
	}
	//select for color
	public WebElement getForColor() {
		return this.driver.findElement(By.id("attr_1-1"));
	}
	//select for location
	public WebElement getForLocation() {
		return this.driver.findElement(By.id("shop-location-input-1"));
	}
	// get for mouse over first picture
	public WebElement getFirstItem() {
		return this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[3]/div/div/div/ul/li[1]/div/a/div[1]/div/div/div/div/div/img"));
	}
	// get book beautiful scotland
	public WebElement getBook() {
		return this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[9]/div/div/div/ul/li[11]/div/div/a/div[1]/div/div/div/div/div/img"));
	}
	// favorites for scotland
	public WebElement getBookFavorites() {
		return this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[9]/div/div/div/ul/li[11]/div/div/div/button/div/span[2]"));
	}
	
	// get favorite icon of first element
	public WebElement getIconFavorites() {
		return this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[3]/div/div/div/ul/li[1]/div/div/button"));
	}
	
	//methods
	
	//open desired page
	public void getNavBarToysNE() throws InterruptedException {
		this.actions.moveToElement(navForToysNE());
		Thread.sleep(1000);
		this.actions.moveToElement(navForANF()).click();
		Thread.sleep(1000);
		
	}
	//filter page
	public void filteringPage() {
		getForFilters().click();
		getForFreeShip().click();
		getForPrice().click();
		getForColor().click();
		getForLocation().click();
		
	}
	//first item pick for favorites
	public void firstItemPickUp() {
		this.actions.moveToElement(getFirstItem());
		waiter.until(ExpectedConditions.visibilityOfElementLocated((By) getIconFavorites())).click();
	}
	//book scotland
		public void getScotladFavorites() {
			this.actions.moveToElement(getBook());
			waiter.until(ExpectedConditions.elementToBeClickable(getBookFavorites())).click();
		}
}
