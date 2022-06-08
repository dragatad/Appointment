import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AppointmentPage extends BasePage{
    private By facilitySelect = By.id("combo_facility");
    private By hospitalReadmission = By.id("chk_hospotal_readmission");
    private By healthCareProgram1 = By.id("radio_program_medicare");
    private By healthCareProgram2 = By.id(("radio_program_medicaid"));
    private By healthCareProgram3 = By.id("radio_program_none");
    private By visitDate = By.id("txt_visit_date");
    private By comment = By.id("txt_comment");
    private By submit = By.id("btn-book-appointment");
    private By appointmentElements = By.id("appointment");

    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFacilitySelect() {
        return facilitySelect;
    }

    public By getHospitalReadmission() {
        return hospitalReadmission;
    }

    public By getHealthCareProgram1() {
        return healthCareProgram1;
    }

    public By getHealthCareProgram2() {
        return healthCareProgram2;
    }

    public By getHealthCareProgram3() {
        return healthCareProgram3;
    }

    public By getVisitDate() {
        return visitDate;
    }

    public By getComment() {
        return comment;
    }

    public By getSubmit() {
        return submit;
    }

    public By getAppointmentElements() {
        return appointmentElements;
    }

    public boolean isFormPresented(){
        //return getDriver().findElement(submit).isDisplayed();
        List<WebElement> elements = getDriver().findElements(By.id("appointment"));
        if(elements.size() == 0){
            return false;
        }
        return true;
    }

    public void setAppointment(){
        getDriver().findElement(facilitySelect).sendKeys("Tokyo CURA Healthcare Center");
        getDriver().findElement(hospitalReadmission).click();
        getDriver().findElement(healthCareProgram1).click();
        getDriver().findElement(visitDate).sendKeys("21/09/2022");
        getDriver().findElement(comment).sendKeys("No comment");
        getDriver().findElement(submit).click();
    }

    public void setAppointmentClick(){
        getDriver().findElement(submit).click();
    }

    public String appointmentDetails(){
        getDriver().navigate().back();
        List<String>elementsList = new ArrayList<>();
        return String.valueOf(elementsList.add(getDriver().findElement(appointmentElements).getText()));
    }



}
