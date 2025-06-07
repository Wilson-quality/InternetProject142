import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginInternetProjeect142v2 {

    private WebDriver motorDoNavegador;

    @BeforeEach
    public void iniciarMotor() {
        motorDoNavegador = new ChromeDriver();
        motorDoNavegador.manage().window().maximize();
        motorDoNavegador.get("https://the-internet.herokuapp.com/login");
        new WebDriverWait(motorDoNavegador, Duration.ofSeconds(5))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
    }

    @AfterEach
    public void finalizarMotor() {
        motorDoNavegador.quit();
    }

    private void fazerLogin(String usuario, String senha) {
        motorDoNavegador.findElement(By.id("username")).clear();
        motorDoNavegador.findElement(By.id("password")).clear();
        motorDoNavegador.findElement(By.id("username")).sendKeys(usuario);
        motorDoNavegador.findElement(By.id("password")).sendKeys(senha);
        motorDoNavegador.findElement(By.cssSelector("button.radius")).click();
    }

    @Test
    public void loginUsuarioIncorretoSenhaCorreta() {
        fazerLogin("UsuarioIncorreto", "SuperSecretPassword!");
        // Aqui você pode validar a mensagem de erro
    }

    @Test
    public void loginUsuarioIncorretoSenhaIncorreta() {
        fazerLogin("UsuarioIncorreto", "SenhaIncorreta");
    }

    @Test
    public void loginUsuarioIncorretoSenhaVazia() {
        fazerLogin("UsuarioIncorreto", "");
    }

    @Test
    public void loginUsuarioVazioSenhaCorreta() {
        fazerLogin("", "SuperSecretPassword!");
    }

    @Test
    public void loginUsuarioCorretoSenhaIncorreta() {
        fazerLogin("tomsmith", "SenhaIncorreta");
    }

    @Test
    public void loginUsuarioCorretoSenhaVazia() {
        fazerLogin("tomsmith", "");
    }

    @Test
    public void loginUsuarioVazioSenhaVazia() {
        fazerLogin("", "");
    }

    @Test
    public void loginCorreto() {
        fazerLogin("tomsmith", "SuperSecretPassword!");
        new WebDriverWait(motorDoNavegador, Duration.ofSeconds(5))
            .until(ExpectedConditions.urlContains("secure"));
        assertEquals("https://the-internet.herokuapp.com/secure", motorDoNavegador.getCurrentUrl());
        System.out.println("Logado com sucesso!");
    }
}

    

