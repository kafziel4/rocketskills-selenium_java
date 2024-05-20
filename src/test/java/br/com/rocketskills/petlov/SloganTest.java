package br.com.rocketskills.petlov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SloganTest {

	@Test
	@DisplayName("Deve exibir o slogan do site")
	void sloganTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://petlov.vercel.app");

		WebElement title = driver.findElement(By.cssSelector("h1"));

		assertEquals("Conectando corações, mudando vidas!", title.getAttribute("innerText"), "Verificando o Slogan");

		driver.close();
	}
}