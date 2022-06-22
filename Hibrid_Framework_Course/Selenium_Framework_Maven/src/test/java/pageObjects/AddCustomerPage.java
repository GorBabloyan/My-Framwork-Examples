package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    WebDriver driver;
    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    WebElement lnkAddNewCustomer;

    @FindBy(how = How.NAME, using = "name")
    @CacheLookup
    WebElement customerName;

    @FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
    @CacheLookup
    WebElement genderM;
    @FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
    @CacheLookup
    WebElement genderF;

    @FindBy(how = How.ID_OR_NAME, using = "dob")
    @CacheLookup
    WebElement dateOfBirth;

    @FindBy(how = How.NAME, using = "addr")
    @CacheLookup
    WebElement address;

    @FindBy(how = How.NAME, using = "city")
    @CacheLookup
    WebElement city;

    @FindBy(how = How.NAME, using = "state")
    @CacheLookup
    WebElement state;

    @FindBy(how = How.NAME, using = "pinno")
    @CacheLookup
    WebElement pin;

    @FindBy(how = How.NAME, using = "telephoneno")
    @CacheLookup
    WebElement mobileNum;

    @FindBy(how = How.NAME, using = "emailid")
    @CacheLookup
    WebElement email;

    @FindBy(how = How.NAME, using = "password")
    @CacheLookup
    WebElement password;

    @FindBy(how = How.NAME, using = "sub")
    @CacheLookup
    WebElement submit;

    @FindBy(how = How.NAME, using = "res")
    @CacheLookup
    WebElement reset;




    public void addNewCustomerButton() {
        lnkAddNewCustomer.click();
    }

    public void addName(String cName) {
        customerName.sendKeys(cName);
    }

    public void setGender(String cGender) {
        if (cGender.equals("female")){
            genderF.click();
        }
        else {
            genderM.click();
        }
    }

    public void setDateOfBirth(String mm, String dd, String yy) {
        dateOfBirth.sendKeys(mm);
        dateOfBirth.sendKeys(dd);
        dateOfBirth.sendKeys(yy);
    }

    public void setAddress(String cAddress) {
        address.sendKeys(cAddress);
    }

    public void setCity(String cCity) {
        city.sendKeys(cCity);
    }

    public void setState(String cState) {
        state.sendKeys(cState);
    }

    public void setPin(int cPin) {
        pin.sendKeys(String.valueOf(cPin));
    }

    public void setMobileNum(String cNum) {
        mobileNum.sendKeys(cNum);
    }

    public void setEmail(String cEmail) {
        email.sendKeys(cEmail);
    }

    public void setPassword(String cPassword) {
        password.sendKeys(cPassword);
    }

    public void setSubmit() {
        submit.click();
    }

}
