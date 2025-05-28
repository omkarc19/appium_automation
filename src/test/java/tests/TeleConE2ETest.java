package tests;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import page.medicoPages.MedicoAppointmentReqPage;
import page.medicoPages.MedicoAppointmentsPage;
import page.medicoPages.MedicoHomePage;
import page.medicoPages.MedicoLandingPage;
import page.medicoPages.MedicoLoginPage;
import page.userPages.UserBookAppointmentPage;
import page.userPages.UserChooseDrPage;
import page.userPages.UserHomePage;
import page.userPages.UserLandingPage;
import page.userPages.UserLoginPage;
import utils.TestUtils;

public class TeleConE2ETest extends DriverManager { 

	private TestUtils utils;
	@Test
	public void medicoPositiveFlow() throws InterruptedException, MalformedURLException {

		// User Phone
		UserLandingPage userLandingPage = new UserLandingPage(userDriver);
		UserLoginPage userLoginPage	= new UserLoginPage(userDriver);
		UserHomePage userHomePage = new UserHomePage(userDriver);
		UserChooseDrPage userChooseDrPage = new UserChooseDrPage(userDriver);
		UserBookAppointmentPage userBookAppointmentPage = new  UserBookAppointmentPage(userDriver);
		
		//MedicoPages
		MedicoLandingPage medicoLandingPage = new MedicoLandingPage(medicoDriver);
		MedicoLoginPage medicoLoginPage	= new MedicoLoginPage(medicoDriver);
		MedicoHomePage medicoHomePage = new MedicoHomePage(medicoDriver);
		MedicoAppointmentReqPage medicoAppointmentReqPage = new MedicoAppointmentReqPage(medicoDriver);
		MedicoAppointmentsPage medicoAppointmentsPage = new MedicoAppointmentsPage(medicoDriver);
		
		userLandingPage.navigateLandingPage();
		userLoginPage.login();
		utils.swipeUp(userDriver);
		utils.scrollToTextUntilEnd(userDriver, "Consult our top experts");
		userHomePage.navigateToDrPage();
		userChooseDrPage.selectDr();
		userBookAppointmentPage.bookAppointment();
				
		// Medico phone
		medicoLandingPage.navigateLandingPage();
		medicoLoginPage.login();
		medicoHomePage.viewPendingRequest();
		medicoAppointmentReqPage.acceptRequest();
		medicoHomePage.viewAllRequestBtn();
		utils.scrollToTextUntilEnd(medicoDriver, "Vishnu Kumar");
		medicoAppointmentsPage.acceptRequest();
	
		// User Phone
		 ((AndroidDriver) userDriver).openNotifications();
		 userDriver.findElement(By.id("com.manastik.dadt:id/llAccept")).click();
		 
		// Medico Phone
		 medicoDriver.findElement(AppiumBy.accessibilityId("Toggle Picture-in-Picture mode")).click();
	}
}
