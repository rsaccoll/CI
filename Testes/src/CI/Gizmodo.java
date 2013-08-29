package CI;

import java.io.File;
import java.io.IOException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(BlockJUnit4ClassRunner.class)
public class Gizmodo extends TestCase 
{

  private static ChromeDriverService service;
  private WebDriver driver;

  @BeforeClass
  public static void createAndStartService() throws IOException 
  {
    service = new ChromeDriverService.Builder()
        .usingDriverExecutable(new File("E://Dev//lib//Chrome//chromedriver.exe"))
        .usingAnyFreePort()
        .build();
    service.start();
  }

  @AfterClass
  public static void createAndStopService() 
  {
    service.stop();
  }

  @Before
  public void createDriver() 
  {
    driver = new RemoteWebDriver(service.getUrl(),
        DesiredCapabilities.chrome());
  }

  @After
  public void quitDriver() 
  {
    driver.quit();
  }

  @Test
  public void testeNavegacao() throws Exception 
  {
	  driver.get("http://www.autocarro.com.br/");
	  WebElement busca = driver.findElement(By.id("ab"));
	  WebElement botao = driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/form/div/input[2]"));
	  busca.sendKeys("Opala");
	  botao.click();
	  Thread.sleep(8000);
	  
	  
  }
}
