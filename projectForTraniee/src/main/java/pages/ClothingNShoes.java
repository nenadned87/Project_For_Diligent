package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClothingNShoes extends BasicPage {

	public ClothingNShoes(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		
	}
	public Actions actions = new Actions(driver);
	
	// get for navigation bar
	public WebElement navigationForCnS() {
		return this.driver.findElement(By.xpath("//*[@id=\"desktop-category-nav\"]/div[1]/div/ul/li[2]/a"));
	}
	
	//get for man's option
	public WebElement getNavMan() {
		return this.driver.findElement(By.id("side-nav-category-link-10936"));
	}
	//get for boots
	public WebElement getMansBoots() {
		return this.driver.findElement(By.id("catnav-l4-11109"));
	}
	
	// for try catch element boots
	public WebElement getBootsMessage() {
		return this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/div/h1"));
	}
	//click on filter button
	public WebElement getFiltersForBoots() {
		return this.driver.findElement(By.xpath("//*[@id=\"search-filter-button\"]/span[2]"));
	}
	// on sale filter
	public WebElement getOnSaleCheck() {
		return this.driver.findElement(By.xpath("//*[@id=\"search-filter-form\"]/div/div[1]/div[2]/fieldset/div/div/div[2]/div/label"));
	}
	// any price filter
	public WebElement getAnyPriceCheck() {
		return this.driver.findElement(By.xpath("//*[@id=\"search-filter-form\"]/div/div[1]/div[4]/fieldset/div/div/div[1]/label"));
	}
	// bronze color filter
	public WebElement getColorCheck() {
		return this.driver.findElement(By.xpath("//*[@id=\"search-filter-form\"]/div/div[1]/fieldset[1]/div/div[1]/div[4]/div/label"));								
	}
	// size filter 6.5
	public WebElement getSizeCheck() {
		return this.driver.findElement(By.xpath("//*[@id=\"search-filter-form\"]/div/div[1]/fieldset[2]/div/div[1]/div[4]/div/label"));
	}
	// shop location filter - anywhere
	public WebElement getLocationCheck() {
		return this.driver.findElement(By.xpath("//*[@id=\"search-filter-form\"]/div/div[1]/div[5]/fieldset/div/div/div[1]/label"));
	}
	//item type filte - all items type
	public WebElement getItemTypeCheck() {
		return this.driver.findElement(By.xpath("//*[@id=\"search-filter-form\"]/div/div[1]/div[6]/fieldset/div/div/div[1]/label"));
	}
	//ship for serbia selector  - you need location selector
	public WebElement getShipButton() {
		return this.driver.findElement(By.name("ship_to"));
	}
	//selected filtreded item - boots
	public WebElement getFinalSearchBoot() {
		return this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[9]/div/div/div/ul/li/div/div/a/div[2]/div/h3"));
	}
	//apply button
	public WebElement getSubmitButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"search-filters-overlay\"]/div/div/div[2]/button[2]"));
	}
	//notification
	public WebElement getNotification() {
		return this.driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[4]/span/a/span[1]"));
	}
	//methods
	
	// method for mans boots page
	public void navigateOnMBoots() {
		this.actions.moveToElement(navigationForCnS());
		this.actions.moveToElement(getNavMan());
		this.actions.moveToElement(getMansBoots()).click().build().perform();
	}
	//method for filtering boots
	public void filteringMBoots() {
		this.actions.moveToElement(navigationForCnS());
		this.actions.moveToElement(getNavMan());
		this.actions.moveToElement(getMansBoots()).click().build().perform();
		getFiltersForBoots().click();
		getOnSaleCheck().click();
		getAnyPriceCheck().click();
		getColorCheck().click();
		getSizeCheck().click();
		getLocationCheck().click();
		getItemTypeCheck().click();
		Select shipTo = new Select(getShipButton());
		shipTo.selectByVisibleText("Serbia");
		getSubmitButton().click();
	}
	//method for getting result
	public void findResult() throws Exception {
		getFinalSearchBoot();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getFinalSearchBoot());
		Thread.sleep(500); 
		Boolean elementExist = true;
		try  {
			getFinalSearchBoot();
		}catch(Exception e){
			elementExist = false;
			System.out.print("We didn't find searched result");
		}
	}
	//method for notification
	public void getNotify() throws InterruptedException {
		this.actions.moveToElement(navigationForCnS());
		this.actions.moveToElement(getNavMan());
		this.actions.moveToElement(getMansBoots()).click().build().perform();
		getFiltersForBoots().click();
		getOnSaleCheck().click();
		getAnyPriceCheck().click();
		getColorCheck().click();
		getSizeCheck().click();
		getLocationCheck().click();
		getItemTypeCheck().click();
		Select shipTo = new Select(getShipButton());
		shipTo.selectByVisibleText("Serbia");
		getSubmitButton().click();
		getFinalSearchBoot().click();
		getNotification().getText();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getNotification());
		Thread.sleep(500); 
		Boolean elementExist = true;
		try  {
			getNotification();
		}catch(Exception e){
			elementExist = false;
			System.out.print("We didn't find notification");
		}
	}
}
