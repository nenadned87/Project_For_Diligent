package pages;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class BasicPage {
	
	
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;
	
	public BasicPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super();
		this.driver = driver;
		this.waiter = waiter;
		this.js = js;
	}
	
	
	
}
