import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginInternetProject142 {
    private WebDriver driver;
    
 
@BeforeEach 
//void =método
//() paretenses após a função "iniciar" está recebendo dados, no meio do código sem ser após uma função está enviado dados.
public void iniciar () {
driver  = new ChromeDriver(); // Instanciar o objeto do Selenium com o ChromeDriver
driver.manage().window().maximize();} //Maximiza a janela do Browser

@Test
    public void testarLoginIncorreto() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebDriverWait esperar = new WebDriverWait(driver, Duration.ofSeconds(5));
        esperar.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

//Login incorreto
        //6 Testes 
        testarLoginIncorreto("usuarioIncorreto", "SuperSecretPassword!"); //Usuario incorreto e senha correta
        testarLoginIncorreto("usuarioIncorreto", "SenhaIncorreta"); //Usuário incorreto e senha incorreta
        testarLoginIncorreto("usuarioIncorreto", ""); //Usuário incorreto e senha vazia
        testarLoginIncorreto("", "SuperSecretPassword!"); //Usuario vazio e senha correta
        testarLoginIncorreto("", "SenhaIncorreta"); //Usuario vazio e senha correta
        testarLoginIncorreto("", ""); // Usuario e senha Vazios

        //2 Testes (, Usuário incorreto e senha vazia, Usuario e senha Vazios)
        testarLoginIncorreto("tomsmith", "Senhaincorreta"); // Usuario Correto e senha incorreta
        testarLoginIncorreto("tomsmith", ""); //Usuario Correto e senha Vazia
                    

        driver.quit();
    }
    @Test
    
    public void testarLoginCorreto() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebDriverWait esperar = new WebDriverWait(driver, Duration.ofSeconds(5));
        esperar.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        testarLoginCorreto("tomsmith", "SuperSecretPassword!"); //Usuario Correto e correta
    }

    private void testarLoginIncorreto(String usuario, String senha) {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("username")).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.cssSelector("button.radius")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement mensagemErro = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        assertTrue(mensagemErro.getText().contains("invalid!"));

        System.out.println("Mensagem validada para usuário: " + usuario + " e senha: [" + senha + "]");
       
    }
                        
        private void testarLoginCorreto(String usuario, String senha) {
            driver.findElement(By.id("username")).sendKeys(usuario);
            driver.findElement(By.id("password")).sendKeys(senha);
            driver.findElement(By.cssSelector("button.radius")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
           // WebElement mensagemSucesso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
           // assertTrue(mensagemSucesso.getText().contains("secure"));
            wait.until(ExpectedConditions.urlContains("/secure"));
            assertTrue(driver.getCurrentUrl().contains("/secure"));

            System.out.println("Mensagem validada para usuário: " + usuario + " e senha: [" + senha + "]");
    
            driver.quit();
                
    }
       
    
    public static void incorreto(String[] args) {
        new LoginInternetProject142().testarLoginIncorreto();
        
    }
    
    public static void correto(String[] args) {
        new LoginInternetProject142().testarLoginCorreto();
    }
}
