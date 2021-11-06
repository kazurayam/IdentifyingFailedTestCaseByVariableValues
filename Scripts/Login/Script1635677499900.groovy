import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser("")
WebUI.navigateToUrl("http://demoaut.katalon.com/profile.php#login")
WebUI.setText(createTestObject("//input[@id='txt-username']"), demo_usn)
WebUI.setText(createTestObject("//input[@id='txt-password']"), demo_pwd)
WebUI.click(createTestObject("//button[@id='btn-login']"))
WebUI.verifyElementPresent(createTestObject(
	"//button[@id='btn-book-appointment']"),
	2, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.closeBrowser() 

 
 TestObject createTestObject(String xpath) {
	 TestObject tObj = new TestObject(xpath)
	 tObj.addProperty("xpath", ConditionType.EQUALS, xpath)
	 return tObj
}