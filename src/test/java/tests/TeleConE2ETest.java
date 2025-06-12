package tests;

import java.net.MalformedURLException;
import org.testng.annotations.Test;

import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import page.medicoPages.MAddCogniTestPage;
import page.medicoPages.MAppointPeoplePage;
import page.medicoPages.MAppointmentDetailsPage;
import page.medicoPages.MAppointmentReqPage;
import page.medicoPages.MAppointmentsPage;
import page.medicoPages.MCommonPage;
import page.medicoPages.MHomePage;
import page.medicoPages.MLandingPage;
import page.medicoPages.MLoginPage;
import page.medicoPages.MMocaTestPage;
import page.userPages.UBookAppointmentPage;
import page.userPages.UChooseDrPage;
import page.userPages.UCommonPage;
import page.userPages.UHomePage;
import page.userPages.ULandingPage;
import page.userPages.ULoginPage;
import page.userPages.UTestPage;
import utils.TestUtils;

public class TeleConE2ETest extends DriverManager {

	private TestUtils utils;
//	Vishnu Kumar patientId = "f005d35a-9c9d-4bd3-94c6-cb589295d8c7"  , change appointment status to - APPOINTMENT_COMPLETED

	@Test
	public void medicoPositiveFlow() throws InterruptedException, MalformedURLException {

		// User Pages
		ULandingPage uLandingPage = new ULandingPage(userDriver);
		ULoginPage uLoginPage = new ULoginPage(userDriver);
		UHomePage uHomePage = new UHomePage(userDriver);
		UChooseDrPage uChooseDrPage = new UChooseDrPage(userDriver);
		UBookAppointmentPage uBookAppointmentPage = new UBookAppointmentPage(userDriver);
		UCommonPage uCommonPage = new UCommonPage(userDriver);
		UTestPage uTestPage = new UTestPage(userDriver);

		// Medico Pages
		MLandingPage mLandingPage = new MLandingPage(medicoDriver);
		MLoginPage mLoginPage = new MLoginPage(medicoDriver);
		MHomePage mHomePage = new MHomePage(medicoDriver);
		MAppointmentReqPage mAppointmentReqPage = new MAppointmentReqPage(medicoDriver);
		MAppointmentsPage mAppointmentsPage = new MAppointmentsPage(medicoDriver);
		MCommonPage mCommonPage = new MCommonPage(medicoDriver);
		MAddCogniTestPage mAddCogniTestPage = new MAddCogniTestPage(medicoDriver);
		MAppointmentDetailsPage mAppointmentDetailsPage = new MAppointmentDetailsPage(medicoDriver);
		MAppointPeoplePage mAppointPeoplePage = new MAppointPeoplePage(medicoDriver);
		MMocaTestPage mMocaTestPage = new MMocaTestPage(medicoDriver);

		// User Phone
		uLandingPage.navigateLandingPage();
		uLoginPage.login();
		uHomePage.navigateToDrPage();
		uChooseDrPage.selectDr();
		uBookAppointmentPage.bookAppointment();

		// Medico phone
		mLandingPage.navigateLandingPage();
		mLoginPage.login();
		mHomePage.viewPendingRequest();
		mAppointmentReqPage.acceptRequest();
		mHomePage.viewAllRequestBtn();
		utils.scrollToTextUntilEnd(medicoDriver, "Vishnu Kumar");
		mAppointmentsPage.acceptRequest();

		// User Phone
		((AndroidDriver) userDriver).openNotifications();
		uCommonPage.acceptMeeting();

		// Medico Phone
		mCommonPage.minimizeMeeting();

		// User Phone
		uCommonPage.minimizeMeeting();

		// Medico Phone
		mAppointmentDetailsPage.addAppointmentDetails();
		mAddCogniTestPage.selectTest();
		mAppointPeoplePage.startTest();

		mMocaTestPage.startTest();
		mMocaTestPage.startAssesment();
		mMocaTestPage.provideScore();
		mMocaTestPage.goNext();

		// User Phone
		uTestPage.submitTest();

		// Medico Phone
		mMocaTestPage.provideScore();
		mMocaTestPage.goNext();

		mMocaTestPage.drawClockTest(); 		// Draw clock test page
		mMocaTestPage.namingTest(); 		// Naming page
		mMocaTestPage.memoryTest(); 		// Memory page
		mMocaTestPage.attentionTest(); 		// Attention page
		mMocaTestPage.languageTest();       //Language Page
		mMocaTestPage.abstractionTest();    // Abstraction Page
		mMocaTestPage.delayedRecallTest();  // Delayed Recall page
		mMocaTestPage.orientationTest();	// Orientation page
		
	}
}
