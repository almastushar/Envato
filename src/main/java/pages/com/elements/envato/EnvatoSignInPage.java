package pages.com.elements.envato;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnvatoSignInPage {
	WebDriver driver;

	public EnvatoSignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='signInUsername']")
	WebElement UserName;

	@FindBy(xpath = "//input[@id='signInPassword']")
	WebElement Password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SignInBtn;

	public void EnterUserName(String userName) {
		UserName.sendKeys(userName);
	}

	public void EnterPassword(String password) {
		Password.sendKeys(password);
	}

	public void ClickSignInBtn() {
		SignInBtn.click();
	}
}
