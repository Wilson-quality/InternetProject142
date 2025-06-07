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

public class InternetProject142 {
    //Atributo
    private WebDriver motorDoNavegador;

    // Funções  e Métodos
    @BeforeEach //Antes de cada teste inicia o motor do navegador
        public void iniciarMotor(){
            motorDoNavegador = new ChromeDriver();
            motorDoNavegador.manage().window().maximize();
             

        }
        
    @AfterEach //Depois de cada teste apaga da memória o motor do navegador, para iniciar o próximo teste com as configurações inicias
        public void finalizarMotor(){
            motorDoNavegador.quit();
        }


    @Test
    public void realizarLogin(){
        motorDoNavegador.get("https://the-internet.herokuapp.com/login"); //abrir o site
        WebDriverWait carregarPagina = new WebDriverWait(motorDoNavegador, Duration.ofSeconds(5)); //Aguardar até 5 seg até encontrar o elemento username
        carregarPagina.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));

      
//Usuario incorreto e senha correta 1
        motorDoNavegador.findElement(By.id("username")).clear(); //limpar o campo antes de preencher
        motorDoNavegador.findElement(By.id("password")).clear();
        motorDoNavegador.findElement(By.id("username")).sendKeys("UsuarioIncorreto"); //preencher o campo
        motorDoNavegador.findElement(By.id("password")).sendKeys("SuperSecretPassword!"); //preencher o campo
        motorDoNavegador.findElement(By.cssSelector("button.radius")).click(); //clicar no botão 

//Usuário incorreto e senha incorreta 2
        WebDriverWait carregarPagina2 = new WebDriverWait(motorDoNavegador, Duration.ofSeconds(5)); //Aguardar até 5 seg até encontrar o elemento username
        carregarPagina2.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        motorDoNavegador.findElement(By.id("username")).clear(); 
        motorDoNavegador.findElement(By.id("password")).clear();
        motorDoNavegador.findElement(By.id("username")).sendKeys("UsuarioIncorreto"); //preencher o campo
        motorDoNavegador.findElement(By.id("password")).sendKeys("SenhaIncorreta"); //preencher o campo
        motorDoNavegador.findElement(By.cssSelector("button.radius")).click(); //clicar no botão 

//Usuário incorreto e senha vazia 3
WebDriverWait carregarPagina3 = new WebDriverWait(motorDoNavegador, Duration.ofSeconds(5)); //Aguardar até 5 seg até encontrar o elemento username
carregarPagina3.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        motorDoNavegador.findElement(By.id("username")).clear(); 
        motorDoNavegador.findElement(By.id("password")).clear();
        motorDoNavegador.findElement(By.id("username")).sendKeys("UsuarioIncorreto"); //preencher o campo
        motorDoNavegador.findElement(By.id("password")).sendKeys(""); //preencher o campo
        motorDoNavegador.findElement(By.cssSelector("button.radius")).click(); //clicar no botão 

//Usuario vazio e senha correta 4
WebDriverWait carregarPagina4 = new WebDriverWait(motorDoNavegador, Duration.ofSeconds(5)); //Aguardar até 5 seg até encontrar o elemento username
carregarPagina4.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        motorDoNavegador.findElement(By.id("username")).clear(); 
        motorDoNavegador.findElement(By.id("password")).clear();
        motorDoNavegador.findElement(By.id("username")).sendKeys(""); //preencher o campo
        motorDoNavegador.findElement(By.id("password")).sendKeys("SuperSecretPassword!"); //preencher o campo
        motorDoNavegador.findElement(By.cssSelector("button.radius")).click(); //clicar no botão 

//Usuario Correto e senha incorreta 5
WebDriverWait carregarPagina5 = new WebDriverWait(motorDoNavegador, Duration.ofSeconds(5)); //Aguardar até 5 seg até encontrar o elemento username
carregarPagina5.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        motorDoNavegador.findElement(By.id("username")).clear(); 
        motorDoNavegador.findElement(By.id("password")).clear();
        motorDoNavegador.findElement(By.id("username")).sendKeys("tomsmith"); //preencher o campo
        motorDoNavegador.findElement(By.id("password")).sendKeys("SenhaIncorreta"); //preencher o campo
        motorDoNavegador.findElement(By.cssSelector("button.radius")).click(); //clicar no botão 

//Usuario Correto e senha Vazia 6
WebDriverWait carregarPagina6 = new WebDriverWait(motorDoNavegador, Duration.ofSeconds(5)); //Aguardar até 5 seg até encontrar o elemento username
carregarPagina6.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        motorDoNavegador.findElement(By.id("username")).clear(); 
        motorDoNavegador.findElement(By.id("password")).clear();
        motorDoNavegador.findElement(By.id("username")).sendKeys("tomsmith"); //preencher o campo
        motorDoNavegador.findElement(By.id("password")).sendKeys(""); //preencher o campo
        motorDoNavegador.findElement(By.cssSelector("button.radius")).click(); //clicar no botão 


//Usuario vazio e senha correta 7
WebDriverWait carregarPagina7 = new WebDriverWait(motorDoNavegador, Duration.ofSeconds(5)); //Aguardar até 5 seg até encontrar o elemento username
carregarPagina7.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        motorDoNavegador.findElement(By.id("")).clear(); 
        motorDoNavegador.findElement(By.id("password")).clear();
        motorDoNavegador.findElement(By.id("username")).sendKeys("tomsmith"); //preencher o campo
        motorDoNavegador.findElement(By.id("password")).sendKeys(""); //preencher o campo
        motorDoNavegador.findElement(By.cssSelector("button.radius")).click(); //clicar no botão 

        
//Usuario Vazio e senha Vazia 8
WebDriverWait carregarPagina8 = new WebDriverWait(motorDoNavegador, Duration.ofSeconds(5)); //Aguardar até 5 seg até encontrar o elemento username
carregarPagina8.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        motorDoNavegador.findElement(By.id("username")).clear(); 
        motorDoNavegador.findElement(By.id("password")).clear();
        motorDoNavegador.findElement(By.id("username")).sendKeys(""); //preencher o campo
        motorDoNavegador.findElement(By.id("password")).sendKeys(""); //preencher o campo
        motorDoNavegador.findElement(By.cssSelector("button.radius")).click(); //clicar no botão 

//Logic CORRETO
WebDriverWait carregarPagina9 = new WebDriverWait(motorDoNavegador, Duration.ofSeconds(5)); //Aguardar até 5 seg até encontrar o elemento username
carregarPagina9.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        motorDoNavegador.findElement(By.id("username")).clear(); 
        motorDoNavegador.findElement(By.id("password")).clear();
        motorDoNavegador.findElement(By.id("username")).sendKeys("tomsmith"); //preencher o campo
        motorDoNavegador.findElement(By.id("password")).sendKeys("SuperSecretPassword!"); //preencher o campo
        motorDoNavegador.findElement(By.cssSelector("button.radius")).click(); //clicar no botão 

                WebDriverWait wait2 = new WebDriverWait(motorDoNavegador, Duration.ofSeconds(5));
                wait2.until(ExpectedConditions.urlContains("secure"));
                assertEquals("https://the-internet.herokuapp.com/secure",motorDoNavegador.getCurrentUrl());
                System.out.println("Logado com sucesso!");

                
                 
                
             

    }
} //Fim da public class testLogin1