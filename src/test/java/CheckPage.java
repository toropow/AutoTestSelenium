import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by anton on 6/6/17.
 */
public class CheckPage {
    private WebDriver driver;

    @Before
    public void precondition(){
        //System.setProperty("webdriver.gecko.driver","/home/anton/Documents/newFireFox/geckodriver");
        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @After
    public void closeDriver(){
        driver.quit();
    }

    @Test
    public void check() throws Exception{
        //TODO: step #1  - Go to http://google.com/ncr
        driver.get("http://google.com/ncr");

        //TODO: step #2  - Search for "selenium"
        WebElement query = driver.findElement(By.name("q"));
        query.clear();
        query.sendKeys("Selenium" + Keys.RETURN);
        Thread.sleep(1000);
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //TODO: step #3 - check 1 - First search result link to selenium page
        WebElement firstResult = driver.findElement(By.cssSelector(".srg .r>a"));
        String firstRes = firstResult.getAttribute("href");
        Assert.assertTrue("First result to search doesn't contains link to seleniumhq.org",firstRes.contains("seleniumhq.org"));

        //TODO: step #4 - Go to "Images"
      List<WebElement> listTop = driver.findElements(By.cssSelector(".hdtb-mitem.hdtb-imb .q.qs"));
      WebElement images=null;
        Thread.sleep(1000);
        for (WebElement element : listTop) {
            if (element.getText().contains("Images")){
                images= element;
                break;
            }
        }

            images.click();

        Thread.sleep(5000);

        //TODO: step #5 - check 2 - The first picture in the issue is related to the site seleniumhq.org
        WebElement firstImages = driver.findElement(By.cssSelector("a.rg_l"));
      String  linkImage = firstImages.getAttribute("href");
        System.out.println(linkImage);
        Assert.assertTrue("The image does't refer to the site seleniumhq.org",linkImage.contains("seleniumhq.org"));
       Thread.sleep(1000);

       //TODO: step #6 - Go to "All"
        listTop = driver.findElements(By.cssSelector(".hdtb-mitem.hdtb-imb .q.qs"));
        WebElement all=null;
        Thread.sleep(1000);
        for (WebElement element : listTop) {
            if (element.getText().contains("All")){
                all= element;
                break;
            }
        }
        Thread.sleep(1000);
        all.click();
        Thread.sleep(2000);

        //TODO: step #7 - check 3 - The first link to the search result is the same as in step 3
        WebElement firstResultAgain = driver.findElement(By.cssSelector(".srg .r>a"));
        String firstResAgain = firstResultAgain.getAttribute("href");
        Assert.assertEquals(firstRes,firstResAgain);
        System.out.println("First result "+ firstRes);
        System.out.println("First result again "+ firstResAgain);



    }


}
