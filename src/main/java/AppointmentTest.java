import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppointmentTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private SummaryPage summaryPage;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, driverWait);
        appointmentPage = new AppointmentPage(driver,driverWait);
        summaryPage = new SummaryPage(driver, driverWait);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test
    public void verifySuccessfulLogin() {
        loginPage.makeAnAppointment();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getUsername()));
        //login details
        loginPage.login("John Doe", "ThisIsNotAPassword");
        Assert.assertTrue(loginPage.isLoginButtonEnabled());
        loginPage.clickLoginButton();
        Assert.assertTrue(appointmentPage.isFormPresented());
    }

    @Test
    public void verifyAppointmentAndSummaryData(){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(appointmentPage.getFacilitySelect()));
        appointmentPage.setAppointment();
        Assert.assertEquals(summaryPage.getFacility().getText(),"Tokyo CURA Healthcare Center");
        Assert.assertEquals(summaryPage.getReadmission().getText(),"Yes");
        Assert.assertEquals(summaryPage.getProgram().getText(),"Medicare");
        Assert.assertEquals(summaryPage.getDate().getText(),"21/09/2022");
        Assert.assertEquals(summaryPage.getCommentSummary(),"No comment");
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }



}

