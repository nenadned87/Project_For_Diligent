package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontPage extends BasicPage {

	public FrontPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		
	}
	
	//getter for register button
	public WebElement getRegister() {
		return this.driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[1]/div/button"));
	}
	//getter for email registration
	public WebElement getEmailAds() {
		return this.driver.findElement(By.name("email"));
	}
	//getter for first name in registration menu
	public WebElement getFristName() {
		return this.driver.findElement(By.name("first_name"));
	}
	//getter for set up password
	public WebElement getPassword() {
		return this.driver.findElement(By.name("password"));
	}
	//getter for submiting registration
	public WebElement getSubmRegButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[7]/div/button"));
	}
	//getter for sign in
	public WebElement getSignInButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button"));
	}
	// user name input
	public WebElement getUserName() {
		return this.driver.findElement(By.id("join_neu_email_field"));
	}
	//password input
	public WebElement getUserPass() {
		return this.driver.findElement(By.id("join_neu_password_field"));
	}
	//submit button
	public WebElement getSubmitButton() {
		return this.driver.findElement(By.name("submit_attempt"));
	}
	//radio check button
	public WebElement getCheckButton() {
		return this.driver.findElement(By.id("persisent"));
	}
	//message appearance
	public WebElement getWelcomeMessage() {
		return this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/div/h1[1]"));
	}
	//message appearance name
	public WebElement getWelcomeName() {
		return this.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div/div/h1[1]/a"));
	}
	
	//methods
	
	//registration method
	public void register(String email, String name, String password) {
		getRegister().click();
		getEmailAds().clear();
		getEmailAds().sendKeys(email);
		getFristName().clear();
		getFristName().sendKeys(name);
		getPassword().clear();
		getPassword().sendKeys(password);
		getSubmRegButton().click();
	}
	// signing in method
	public void singIn(String email, String password) {
		getSignInButton().click();
		getUserName().clear();
		getUserName().sendKeys(email);
		getUserPass().clear();
		getUserPass().sendKeys(password);
		getCheckButton().click();
		getSubmitButton().click();
	}
	//message for sign in
	public void getMessageWelcomeing() {
		getWelcomeMessage();
		getWelcomeName().getText();
	}
}
