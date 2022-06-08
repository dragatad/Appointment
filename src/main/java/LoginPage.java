import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By makeAnAppointmentBtn = By.id("btn-make-appointment");
    private By username = By.id("txt-username");
    private By password = By.id("txt-password");
    private By loginButton = By.id("btn-login");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getMakeAnAppointmentBtn() {
        return makeAnAppointmentBtn;
    }

    public By getUsername() {
        return username;
    }

    public By getPassword() {
        return password;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public void makeAnAppointment(){
        getDriver().findElement(makeAnAppointmentBtn).click();
    }

    public void enterUsername(String username){
        getDriver().findElement(this.username).sendKeys(username);
    }

    public void enterPassword(String password){
        getDriver().findElement(this.password).sendKeys(password);
    }

    public boolean isLoginButtonEnabled(){
        return getDriver().findElement(loginButton).isEnabled();
    }

    public void clickLoginButton(){
        getDriver().findElement(loginButton).click();
    }

    public void login(String username, String password){
        clearField(this.username);
        enterUsername(username);
        clearField(this.password);
        enterPassword(password);
    }




}
