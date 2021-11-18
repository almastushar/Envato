package pages.com.elements.envato;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnvatoDownloadGraphgicDesign {
	WebDriver driver;

	public EnvatoDownloadGraphgicDesign(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class=\"_1fNCQMJ9\"]")
	WebElement DownloadWithoutLicBtn;

	public void ClickDownloadIcon(int items) {
			WebElement DownloadIcon = driver.findElement(By.xpath("//li[@class='_2zvdzcaV _3VFL4QU3']["+items+"]//div[@class='_2FqP5dkb']//div[@class='_7FmbXsdm _16BUMJbO _3D8msGLf _22jsLmso']"));
			DownloadIcon.click();	
	}
	
	public void ClickDownloadWithoutLicBtn() {
		DownloadWithoutLicBtn.click();
	}

}
