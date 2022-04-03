package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavoritesPage extends BasicPage {

	public FavoritesPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	
	}
	public Actions actions = new Actions(driver);
	// gets
	
	// navigator for favorite page
	public WebElement navFavoritePage() {
		return this.driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/span/a"));
	}
	
	// book selected favorites
	public WebElement getBookFavoritesScotland() {
		return this.driver.findElement(By.xpath("//*[@id=\"favorite_listings_panel\"]/div/div[1]/ul/li[1]/a/div[1]/div/div/div/div/div/img"));
		
	}
	// icon for remove book from favorites
	public WebElement favoriteBookIconRemove() {
		return this.driver.findElement(By.xpath("//*[@id=\"favorite_listings_panel\"]/div/div[1]/ul/li[1]/div/button/span[2]"));
	}
	
	// methods
	
	// removing stuff
	public void removeFromFavorites() {
		this.actions.moveToElement(getBookFavoritesScotland());
		waiter.until(ExpectedConditions.elementToBeClickable(favoriteBookIconRemove())).click();
	}
}
