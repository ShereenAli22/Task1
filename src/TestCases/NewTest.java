package TestCases;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import java.time.Duration;

public class NewTest {
	WebDriver driver;
	
	 @BeforeMethod
    public void Setup() {
    	 System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
 		
	        driver= new ChromeDriver();
	        driver.manage().window().setSize(new Dimension(1024, 768));
			driver.get("https://www.amazon.eg/-/en/ref=nav_logo");
    }
	
	@Test(priority =1)
  public void FirstScenario()  {
		
		driver.findElement(By.xpath("//*[@id=\"nav-search-bar-form\"]/div[2]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("car accessories");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		
		
		
		WebElement element = driver.findElement(By.xpath("//*[@class='a-section a-padding-medium sw-atc-message-section']"));
		
		String strng = element.getText();
	
	    Assert.assertTrue(strng.contains("Added to Cart"));
	    System.out.println("First scenario passed and product"+ strng);
	    

		

 }
	 @Test(priority = 2)
	  public void SeconedScenario() throws InterruptedException  {
			driver.findElement(By.xpath("(//*[@class='nav-a  '])[1]")).click();
			// scroll up and down
		      Actions at = new Actions(driver);
		      at.sendKeys(Keys.PAGE_DOWN).build().perform();
			  driver.findElement(By.xpath("(//*[@class='CheckboxFilter-module__gridFilterOption_hdG5xZdR2ZvDkQKkl_d49'])[17]")).click();
			  driver.findElement(By.xpath("(//*[@class='CheckboxFilter-module__gridFilterOption_hdG5xZdR2ZvDkQKkl_d49'])[20]")).click();
		      at.sendKeys(Keys.PAGE_DOWN).build().perform();
		      at.sendKeys(Keys.PAGE_DOWN).build().perform();
		      //10% sale
		      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		      wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='a-row'])[16]")));
			  driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[6]//*[@class=\"LinkFilterOption-module__linkFilterOptionListElement_AzC4LFMfeFF1CkwveJM01\"]")).click();
			  WebElement x=driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[6]//*[@class=\"LinkFilterOption-module__linkFilterOptionListElement_AzC4LFMfeFF1CkwveJM01\"]"));
			    Coordinates cordina=((Locatable)x).getCoordinates();
				cordina.inViewPort();
			  driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[6]//*[@class=\"LinkFilterOption-module__linkFilterOptionListElement_AzC4LFMfeFF1CkwveJM01\"]")).click();
			 
			  //  page 3
			  WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		      wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='a-text-center notranslate'])//*[@class='a-normal'][2]")));
			  driver.findElement(By.xpath("(//*[@class='a-text-center notranslate'])//*[@class='a-normal'][2]")).click();
			  WebElement z=driver.findElement(By.xpath("(//*[@class='a-text-center notranslate'])//*[@class='a-normal'][2]"));
			    Coordinates cordinat=((Locatable)z).getCoordinates();
				cordinat.inViewPort();
			  driver.findElement(By.xpath("(//*[@class='a-text-center notranslate'])//*[@class='a-normal'][2]")).click();
			  driver.findElement(By.xpath("(//*[@class='DealGridItem-module__dealItemDisplayGrid_e7RQVFWSOrwXBX4i24Tqg DealGridItem-module__withBorders_2jNNLI6U1oDls7Ten3Dttl DealGridItem-module__withoutActionButton_2OI8DAanWNRCagYDL2iIqN'])[1]")).click();

	 }
	 
	@AfterMethod
	public void Close () throws InterruptedException {	
		 ((ChromiumDriver) driver).getSessionStorage().clear();
	      ((ChromiumDriver) driver).getLocalStorage().clear();	
         driver.close();
	 }
}