
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Set;


public class BaseFragment {
    public static WebDriver driver;

    public void closePopups() {
        Set<String> allWindowHandles = driver.getWindowHandles();
            for(String singleWindow:allWindowHandles){
                driver.switchTo().window(singleWindow);
                driver.findElement(By.xpath("//img[@class='btn-close']")).click();
            }
    }

    public void searchItem(String item){
        driver.findElement(By.id("search-key")).sendKeys(item);
        driver.findElement(By.className("search-button")).click();
    }

    public void filterByPrice(String observation, String price){
            getPriceInputField(observation).click();
            getPriceInputField(observation).sendKeys(price);
            getPriceInputField(observation).sendKeys(Keys.ENTER);
    }

    public WebElement getPriceInputField(String observation){
        return driver.findElement(By.xpath("//input[@placeholder='" + observation + "']"));
    }

}
