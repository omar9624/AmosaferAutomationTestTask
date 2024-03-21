package FlightMultiCityProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlightMultiCityTest extends Parameters{
	
	@BeforeTest
	public void setup() {
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement popupMsg = driver.findElement(By.cssSelector(".sc-iBmynh.izXFRL"));

		if (popupMsg.isDisplayed()) {
			WebElement buttonSAR = driver.findElement(
					By.cssSelector("button[class='sc-jTzLTM hQpNle cta__button cta__saudi btn btn-primary']"));
			buttonSAR.click();
		}
	}
	
	@Test
	public void flightMultiCityProccess() throws InterruptedException {
		WebElement multiCityTab = driver.findElement(By.xpath("//div[@data-testid='FlightSearchBox__MultiCityButton']"));
		multiCityTab.click();
		
		WebElement addMoreFlightsButton = driver.findElement(By.xpath("//div[@data-testid='FlightSearchBox__AddFlightButton']"));
		System.out.println(randomFlightsNumber);
		for(int i=0 ; i < randomFlightsNumber ; i++) {
			Thread.sleep(2000);
			addMoreFlightsButton.click();
		}
		Thread.sleep(2000);
		WebElement inputContainer = driver.findElement(By.id("uncontrolled-tab-example-tabpane-flights"));
		List<WebElement> inputList = inputContainer.findElements(By.tagName("input"));
		System.out.println(inputList.size());
		
		for(int i=2 ; i < inputList.size() ; i++) {
			if(i%2 == 0) {
				int randomorigin = random.nextInt(originCities.length);
				inputList.get(i).sendKeys(originCities[randomorigin]);
				inputList.get(i).sendKeys(Keys.ENTER);
				
			}else {
				int randomdestination = random.nextInt(destinationCities.length);
				inputList.get(i).sendKeys(destinationCities[randomdestination]);
				inputList.get(i).sendKeys(Keys.ENTER);
			}
		}
		
		WebElement searchFlightButton = driver.findElement(By.xpath("//button[@data-testid='FlightSearchBox__SearchButton']"));
		searchFlightButton.click();
		
		Thread.sleep(2000);
		WebElement popMsg = driver.findElement(By.cssSelector(".sc-elJkPf.jdSSTS"));
		if(popMsg.isDisplayed()) {
			WebElement gotitButton = popMsg.findElement(By.cssSelector(".sc-VigVT.jHPtub.btn.btn-primary"));
			gotitButton.click();
		}
		
				
	}
}
