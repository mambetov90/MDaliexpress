import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.*;


public class TattooFromAliexTest extends BaseFragment{

    String url = "https://www.aliexpress.com";

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--disable-popup-blocking");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void Tattoo() {
        closePopups();
        searchItem("tattoo");
        filterByPrice("min", "10");
        Assert.assertEquals(getPriceInputField("min").getAttribute("value"), "10");
        filterByPrice("max", "20");
        Assert.assertEquals(getPriceInputField("max").getAttribute("value"), "20");
    }
}
