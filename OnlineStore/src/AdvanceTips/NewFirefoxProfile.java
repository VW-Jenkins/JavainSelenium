package AdvanceTips;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

//Firefox profile path:
//Windows XP / 2000 / Vista / 7	%AppData%MozillaFirefoxProfilesxxxxxxxx.default
//Linux	~/.mozilla/firefox/xxxxxxxx.default/
//Mac OS X	~/Library/Application Support/Firefox/Profiles/xxxxxxxx.default/



//How to start the Profile Manager
//In the Run dialog box, type in: ‘firefox.exe -p' and then Click OK
public class NewFirefoxProfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("profileToolsQA");
	
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(myprofile);
		
		WebDriver driver = new FirefoxDriver(options);
	
		
	}

}
