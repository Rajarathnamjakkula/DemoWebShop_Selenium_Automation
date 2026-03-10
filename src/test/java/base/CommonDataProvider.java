package base;

import org.testng.annotations.DataProvider;

public class CommonDataProvider {
	@DataProvider(name = "registrationData")
	public static Object[][] registrationData() {
		return new Object[][] { { "jk", "raja", "raja@gmail0.com", "1234567", "1234567" } };
	}

	@DataProvider(name = "SearchData")
	public static Object[][] SearchData() {
		return new Object[][] { { "internet" }, { "english" }, { "health" }, { "maths" } };

	}

	@DataProvider(name = "LoginData")
	public static Object[][] LoginData() {
		return new Object[][] { { "raja@gmail0.com", "1234567" } };
	}

	@DataProvider(name = "InvalidCredentialsData")
	public static Object[][] InvalidCredentialsData() {
		return new Object[][] { { "raja@gmail0.com", "redrfghk" }, { "rathnam@gmail.com", "9852695265" },
				{ "rajarathnam2001@gmail.com", "djashjhsbjh" } };
	}

	@DataProvider(name = "wrong_mail_id")
	Object[][] getwrong_mail_id() {
		return new Object[][] { { "12345" }, { "rajakaka@gmail" }, { "raja.com" } };
	}
}
