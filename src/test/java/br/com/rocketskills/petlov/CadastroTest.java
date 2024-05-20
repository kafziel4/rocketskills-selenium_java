package br.com.rocketskills.petlov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CadastroTest {
	@Test
	@DisplayName("Deve poder cadastrar um ponto de doação")
	void createPoint() {
		open("https://petlov.vercel.app/signup");
		$("h1").shouldHave(text("Cadastro de ponto de doação"));

		$("input[name=name]").setValue("Estação Pet");
		$("input[name=email]").setValue("estacao@pet.com.br");
		$("input[name=cep]").setValue("04534011");
		$("input[value='Buscar CEP']").click();
		$("input[name=addressNumber]").setValue("1000");
		$("input[name=addressDetails]").setValue("Ao lado da padaria");
		$(By.xpath("//span[text()=\"Cachorros\"]/..")).click();
		$(".button-register").click();

		String target = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";

		$("#success-page p").shouldHave(text(target));
	}
}
