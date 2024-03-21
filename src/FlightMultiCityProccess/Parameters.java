package FlightMultiCityProccess;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	WebDriver driver = new ChromeDriver();

	String url = "https://www.almosafer.com/en";

	Random random = new Random();

	int randomFlightsNumber = random.nextInt(5);

	String[] originCities = { "Amman, Jordan", "Dubai, United Arab Emirates",
			"Riyadh, Saudi Arabia - King Khaled International Airport", "Doha, Qatar - Hamad International Airport",
			"Dammam, Saudi Arabia - King Fahad International Airport",
			"Istanbul, Turkey" };
	String[] destinationCities = { "Madinah, Saudi Arabia - Prince Mohammad Bin Abdulaziz International Airport",
			"Cairo, Egypt - Cairo International Airport", "Bari, Italy - Palese Airport",
			"Turkistan, Kazakhstan - Hazrat Sultan International Airport",
			"Columbus, United States - Port Columbus International Airport",
			"Miami, United States - Miami International Airport" };
}
