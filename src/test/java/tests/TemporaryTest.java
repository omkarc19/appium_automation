package tests;

import java.net.MalformedURLException;
import org.testng.annotations.Test;

import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import page.medicoPages.MAddCogniTestPage;
import page.medicoPages.MAddPrescriptionPage;
import page.medicoPages.MAppointPeoplePage;
import page.medicoPages.MAppointmentDetailsPage;
import page.medicoPages.MAppointmentReqPage;
import page.medicoPages.MAppointmentsPage;
import page.medicoPages.MCommonPage;
import page.medicoPages.MHomePage;
import page.medicoPages.MLandingPage;
import page.medicoPages.MLoginPage;
import page.medicoPages.MMocaTestPage;
import page.medicoPages.MPatientRehabPage;
import page.medicoPages.MPatientTestPage;
import page.medicoPages.MReferDrPage;
import page.medicoPages.MScorePage;
import page.medicoPages.MSummaryPage;
import page.medicoPages.mTemporaryPage;
import page.userPages.UBookAppointmentPage;
import page.userPages.UChooseDrPage;
import page.userPages.UCommonPage;
import page.userPages.UHomePage;
import page.userPages.ULandingPage;
import page.userPages.ULoginPage;
import page.userPages.UTestPage;
import utils.TestUtils;

public class TemporaryTest extends DriverManager {

	private TestUtils utils;
//	Vishnu Kumar patientId = "f005d35a-9c9d-4bd3-94c6-cb589295d8c7"  , change appointment status to - APPOINTMENT_COMPLETED

	@Test
	public void medicoPositiveFlow() throws InterruptedException, MalformedURLException {
		// Medico Pages
		MHomePage mHomePage = new MHomePage(medicoDriver);
		MAppointmentReqPage mAppointmentReqPage = new MAppointmentReqPage(medicoDriver);
		MAppointmentsPage mAppointmentsPage = new MAppointmentsPage(medicoDriver);
		MCommonPage mCommonPage = new MCommonPage(medicoDriver);
		MAddCogniTestPage mAddCogniTestPage = new MAddCogniTestPage(medicoDriver);
		MAppointmentDetailsPage mAppointmentDetailsPage = new MAppointmentDetailsPage(medicoDriver);
		MAppointPeoplePage mAppointPeoplePage = new MAppointPeoplePage(medicoDriver);
		MMocaTestPage mMocaTestPage = new MMocaTestPage(medicoDriver);
		mTemporaryPage mTemporaryPage = new mTemporaryPage(medicoDriver);
		MScorePage mScorePage = new MScorePage(medicoDriver);
		MPatientTestPage  mPatientTestPage = new MPatientTestPage(medicoDriver);
		MReferDrPage mReferDrPage = new MReferDrPage(medicoDriver);
		MAddPrescriptionPage mAddPrescriptionPage = new MAddPrescriptionPage(medicoDriver);
		MPatientRehabPage mPatientRehabPage = new MPatientRehabPage(medicoDriver);
		MSummaryPage mSummaryPage = new MSummaryPage(medicoDriver); 
		
		mAddPrescriptionPage.clickSkipBtn();
		mPatientRehabPage.clickNextBtn();
		mSummaryPage.clickFinishAppointmentBtn();
		
	}
}
