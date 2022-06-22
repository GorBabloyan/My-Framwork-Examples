package testCases;
import pageObjects.LoginPage;
import utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass
{
public int i = 1;

@Test
	public void test(){
	Assert.assertTrue(true);
}

}
//	@Test(dataProvider="LoginData")
//	public void loginDDT(String user,String pwd) throws InterruptedException, IOException {
//		LoginPage lp=new LoginPage(driver);
//
//		lp.setUserName(user);
//		lp.setPassword(pwd);
//		Assert.assertTrue(true);
//		lp.clickSubmit();
//		if(isAlertPresent())
//		{
//			driver.switchTo().alert().accept();//close alert
//			driver.switchTo().defaultContent();
//			captureScreen("loginDDT_" + i);
//			i++;
//			Assert.fail();
//		}
//		else
//		{
//			Assert.assertTrue(true);
//			lp.clickLogout();
//			//Thread.sleep(3000);
//			driver.switchTo().alert().accept();//close logout alert
//			driver.switchTo().defaultContent();
//		}
//	}
//	public boolean isAlertPresent() //user defined method created to check alert is present or not
//	{
//		try
//		{
//		driver.switchTo().alert();
//		return true;
//		}
//		catch(NoAlertPresentException e)
//		{
//			return false;
//		}
//	}
//
//
//	@DataProvider(name="LoginData")
//	String [][] getData() throws IOException
//	{
//		String path=System.getProperty("user.dir")+"/src/test/java/com_InetBanking_testData/LoginData.xlsx";
//		int rowNum=XLUtils.getRowCount(path, "Sheet1");
//		int colCount=XLUtils.getCellCount(path,"Sheet1",1);
//
//		String loginData[][]=new String[rowNum][colCount];
//		for(int i=1;i<=rowNum;i++){
//			for(int j=0;j<colCount;j++){
//				loginData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
//			}
//		}
//	return loginData;
//	}
//}
