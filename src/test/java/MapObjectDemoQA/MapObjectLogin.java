package MapObjectDemoQA;



import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import semilleros.ClasesBase;

public class MapObjectLogin extends ClasesBase {
	
	// constructor de la clase
		@SuppressWarnings("rawtypes")
		public MapObjectLogin(AppiumDriver driver) {
			super(driver);
		} 


		protected By btIngresoUsuarioContra = By.id("com.clarocolombia.miclaro.debug:id/btnLoginEmail");
		protected By btCorreo = By.xpath("//android.widget.TextView[@text='Correo electrónico']");
		protected By txCorreo = By.xpath("//android.widget.EditText[@text='Usuario o correo electrónico']");
		protected By txContraseña = By.xpath("//android.widget.EditText[@text='Contraseña']");
		protected By btIniciarSesion = By.xpath("//android.widget.Button[@text='Iniciar sesión']");
		
		protected By btCancelarGuardado = By.id("com.clarocolombia.miclaro.debug:id/btn31");
		
		protected By imgPerfil = By.xpath("//android.widget.ImageView[@resource-id='com.clarocolombia.miclaro.debug:id/imgPerfil']");
}
