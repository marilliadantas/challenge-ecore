package runner.base_class;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage() {
        driver = BaseSteps.browser;
        actions = new Actions(driver);
    }

    public void waitElementVisible(By element, int seconds) {
        wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void visitPage(String url) {
        driver.get(url);
    }

    public void fill(By locator, String texto){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(texto);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void pressEnter(){
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void selectCombo(By locator, String nome){
        WebElement element = driver.findElement(locator);
        Select combo = new Select(element);

        combo.selectByVisibleText(nome);
    }

    public void clickLink(By locator){
        driver.findElement(locator).click();
    }

    public void clickRadio(By locator){
        driver.findElement(locator).click();
    }

    public void clickAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getValueByText(By locator){
        return driver.findElement(locator).getText();
    }

    public String getValue(By locator){
        return  driver.findElement(locator).getAttribute("value");
    }

    public boolean getExistingValue(String texto){
        return driver.getPageSource().contains(texto);
    }

    public boolean checkButtonClicked(By locator){
        return driver.findElement(locator).isSelected();
    }
}
