package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementUtil;

public final class AppointmentPage {

	private WebDriver driver;
	private ElementUtil util;
	
	public AppointmentPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	private final static By makeAppointmentText = By.xpath("//h2");
	private final static By btn_appointment = By.id("btn-book-appointment");
	private final static By dropdown_facility = By.id("combo_facility");
	private final static By check_readmission = By.id("chk_hospotal_readmission");
	private final static By radio_program = By.xpath("//input[@type='radio']");
	private final static By text_date = By.id("txt_visit_date");
	private final static By text_comments = By.id("txt_comment");
	
	
	public AppointmentPage selectFacility(String facilityName) {
		
		return this;
	}
	
	public AppointmentPage isReadmission(boolean readmission) {
		
		return this;
	}
	
	public AppointmentPage selectProgram(String programName) {
		
		return this;
	}
	
	public AppointmentPage enterDateOfVisit(String date) {
		
		return this;
	}
	
	public AppointmentPage enterComments(String comments){
		
		return this;
	}
	
	public void makeAppointment() {
		
	}
	
	
}
