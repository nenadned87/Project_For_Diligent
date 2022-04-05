package testForPages;

import org.testng.annotations.Test;

public class TestingForChrome extends BasicTest {

	
	@Test
	
	public void firstTest() {
		
		driver.get(baseUrl);
		frontPage.register(email,name,password);
		sa.assertTrue(frontPage.getWelcomeMessage().getText().contains("Welcome to Etsy, Nenad!"),"Error") ;
		
	}
	
	public void secondTest() throws InterruptedException {
		
		driver.get(baseUrl);
		Thread.sleep(1000);
		frontPage.singIn(email, password);
		Thread.sleep(1000);
		sa.assertTrue(frontPage.getWelcomeMessage().getText().contains("Welcome back, Nenad!"), "Error");
	}
	
	public void thridTest() throws InterruptedException {
		driver.get(toysNEntUrl);
		toysPage.getNavBarToysNE();
		Thread.sleep(1000);
		sa.assertTrue(toysPage.messageForTNE().getText().contains("Art & Photography Books"), "Error");
	}
	
	public void fourthTest() throws InterruptedException {
		driver.get(toysNEntUrl);
		toysPage.filteringPage();
		Thread.sleep(1000);
		sa.assertEquals(toysPage.getBookFavorites().isEnabled(), true);
	}
	
	public void fifthTest() throws InterruptedException {
		driver.get(favoritesUrl);
		Thread.sleep(500);
		favoritesPage.removeFromFavorites();
		sa.assertEquals(favoritesPage.getBookFavoritesScotland().isDisplayed(), false);
		
	}
}
