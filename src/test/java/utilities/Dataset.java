package utilities;

import org.testng.annotations.DataProvider;

import net.bytebuddy.asm.Advice.Return;

public class Dataset {
	
	@DataProvider(name = "invalidEmails")
	public static Object wrongEmailCombo() {
		Object[][] objects= {{"@@##^^", "1234567890", "Error: The username @@##^^ is not registered on this site. If you are unsure of your username, try your email address instead."},
					

		};
		return objects;

	}
	
	
	@DataProvider(name = "noCredentials")
	public static Object mail_pass_empty() {
		Object[][] objects= {{"", "", "Error: ইউজার নাম প্রয়োজন"},
					

		};
		return objects;

	}
	
	
	@DataProvider(name = "noPassword")
	public static Object emptyPassword() {
		Object[][] objects= {{"tigen52205@wireps.com", "", "Error: The password field is empty."},
					

		};
		return objects;

	}
	
	
	@DataProvider(name = "rightCredentials")
	public static Object correctLogin() {
		Object[][] objects= {{"tigen52205@wireps.com", "1234567890"}};
		return objects;

	}

}
