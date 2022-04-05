package testForPages;

import java.awt.AWTException;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pages.BasicPage;
import pages.ClothingNShoes;
import pages.FavoritesPage;
import pages.FrontPage;
import pages.ToysNEntertainmants;

public abstract class BasicTest2 {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait waiter;
	protected SoftAssert sa;
	

	protected BasicPage basicPage;
	protected ClothingNShoes clothingNShoes;
	protected FavoritesPage favoritesPage;
	protected FrontPage frontPage;
	protected ToysNEntertainmants toysPage;

	protected String baseUrl = "https://www.etsy.com/";
	protected String toysNEntUrl = baseUrl + "/c/books-movies-and-music/books/art-and-photography-books?ref=catnav-11049";
	protected String bootsUrl = baseUrl + "/c/shoes/mens-shoes/boots?ref=catnav-10923";
	protected String favoritesUrl = baseUrl + "/people/pl0cwg6kxyr2ob3b?ref=hdr-fav&tab=items";
	

	
	protected String email = "nenadgrbicned1987@gmail.com";
	protected String name = "Nenad";
	protected String password = "tgmtgm123123";

	@BeforeMethod

	public void beforeMethod() throws AWTException {

		
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		waiter = new WebDriverWait(driver, 10);
		SoftAssert sa = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
		clothingNShoes = new ClothingNShoes(driver, waiter, js);
		favoritesPage = new FavoritesPage(driver, waiter, js);
		frontPage = new FrontPage(driver, waiter, js);
		toysPage = new ToysNEntertainmants(driver, waiter, js);
		

	}

	@AfterMethod

	public void afterMethod(ITestResult result) {
		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(source, new File("./Screenshots/" + ".png"));
				System.out.println("Screenshot taken");

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
		driver.quit();
	}
}
