import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SummaryPage extends AppointmentPage {
    private By facility = By.id("facility");
    private By readmission = By.id("hospital_readmission");
    private By program = By.id("program");
    private By date = By.id("visit_date");
    private By commentSummary = By.id("comment");

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getFacility() {
        return getDriver().findElement(facility);
    }

    public WebElement getReadmission() {
        return getDriver().findElement(readmission);
    }

    public WebElement getProgram() {
        return getDriver().findElement(program);
    }

    public WebElement getDate() {
        return getDriver().findElement(date);
    }

    public By getCommentSummary() {
        return commentSummary;
    }


}
