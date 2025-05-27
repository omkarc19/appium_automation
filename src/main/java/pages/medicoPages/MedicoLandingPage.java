package pages.medicoPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class MedicoLandingPage extends BaseTest{
	public MedicoLandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = ".//*[@content-desc='Next']\"")
	private WebElement nextBtn;
	
	
}
