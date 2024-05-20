package br.com.rocketskills.petlov;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumTest {
	WebDriver driver;

	@BeforeEach
	void start() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterEach
	void finish() {
		driver.close();
	}

	@Test
	@DisplayName("Deve poder cadastrar um ponto de doação")
	void createPoint() {
		driver.get("https://petlov.vercel.app/signup");

		WebElement title = driver.findElement(By.cssSelector("h1"));

		assertEquals("Cadastro de ponto de doação", title.getAttribute("innerText"), "Verificando o título da página de cadastro");

		driver.findElement(By.cssSelector("input[name=name]")).sendKeys("Papito Point");
		driver.findElement(By.cssSelector("input[name=email]")).sendKeys("papito@point.net");
		driver.findElement(By.cssSelector("input[name=cep]")).sendKeys("04534011");
		driver.findElement(By.cssSelector("input[value='Buscar CEP']")).click();
		driver.findElement(By.cssSelector("input[name=addressNumber]")).sendKeys("1000");
		driver.findElement(By.cssSelector("input[name=addressDetails]")).sendKeys("Ao lado da padaria");
		driver.findElement(By.xpath("//span[text()=\"Cachorros\"]/..")).click();

		driver.findElement(By.className("button-register")).click();

		WebElement result = driver.findElement(By.cssSelector("#success-page p"));

		String target = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";

		assertEquals(target, result.getAttribute("innerText"), "Verificando a mensagem de sucesso");
	}
}
