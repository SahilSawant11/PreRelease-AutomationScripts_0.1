	package Payments;

import java.util.Arrays;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import New_property_Wadhghat.BaseDriver;
import pojo.CMS_browser;

public class test123 extends BaseDriver{

	public static void main(String[] args) {


        driver = CMS_browser.openBrowser("https://cfcpanvelmc.org/Pages/Login.aspx");
        String[] ids = {"PNVLGPNPW4A019910","PNVL0339450","PNVL0358926","KM0728029202E403","NPE015078005BB1","KM171001026A601","KM2140A033009302","KM341,2,4,5,19,20,21,22,23,24,25,26005324Building-4-A503","KM341,2,4,5,19,20,21,22,23,24,25,26005891Building-12-B502","KL2030028059B","204","KL9E4001073BuildingNo-3303","KH34C15,160140261202","KH35I260270481503","KH069014010A901","KH066B007034A702","KH362035014E","1502","NPE171002023A8","NPW0615021013601","KM1857,580540A1","KH401002031L21102","KH231009155C1002","KH1940027056A103","KM6A37042019A303","KM1938041018A302","KH0414D020144H304","KL3E5005032KL-5-2616","KH0540065021BB1","KH35E28020034A504","KH064,5004268I337","KL152,6,3,4,1,9,5,7,8199542L7101","KM2529030522I304","KM168A009089B901","KM20720510077","NPE146028019B102","NPE06D-352870047(8)","NPE06E137102424","KH2022153044P703","KH1917,18006050A304","KM2172059020102","KL1617007025503","KH0516014006202","KH1590070371102","KL177005085B501","TP1624025014302","KH18360250151201","KH10253,254133067A1305","NPW0715,16267125E301","PNVLGPKL1EA0773","PNVLGPKH19A00109","PNVLGPKH13A0143","PNVLGPKH13A0186","PNVLGPKH13A0188","PNVLGPKH10A060026","PNVLGPKH3A0078","KLS01857F010069AA-2022","KH17009021","KH1760090A1","PNVL0327937","PNVL0332576","PNVL0335689","PNVL0343344","KM064,4A004092A607","KM0810011018A103","KM0820021034A204","KM069013045B110","KM1231007062C202","KM0522A026035A205","KM0614018063015","KM0826026018501","KM0540048017A303","KM0721027073B1104","KM1234010078A3411","KM1235011104D204","KM16100102727","KM0728029065A703","KM0728029137C204","KM0728029224E606","KM6A67032032A303","KM112060041B402","NPE15A24022069A205","KM169010101C703","KM204,5003090B105","KM1918018046A903","KM1615014070D101","KM6A5506501111","PNVL0388146","KM212,3002023A1101","KM2529030115B201","KM1843040004101","NPE10154127002002","NPE1067,68003007202","NPE10116-1170420176","NPE10221,232063001A001","NPE162b031025C302","NPE0326029005RH","05","KM1943046020A502","NPE0411+12008002002","NPW061001052A1601","KM1983037061B703","KM1850,63,64,64A,65047209E302","KM1982039025A602","NPE5A43,44,45046053B301","KM2033,34008054A403","NPE0412,13,16,17009003103","KM2033,34008145C506","KM2033,34008200E404","KM3557,1,2001127C304","KM361,22001181D604","KM2027020047A503","KM34134,135077006101","KM358B,801007171","KM2164052021403","KM359012157F301","KM20490320044","NPE112321800303","KM174,5,6,7007128C602","KM174,5,6,7007196D804","KM2217A,18,19,2000702910","KM2217A,18,19,20007034A601","KM3436030017A702","KM1869B070016A203","KM1869B070027A604","NPW0952065051C604","KM34153,154,155,156,157,158,159,160,161,164,165,162,163088162C1003","KM1019010061B603","KM1869B070066C001","NPW0120015032B816","KM1868072010A1101","KM221500106498","KL2012,13011027A502","KL2034032024","1002","KL10E5A0070331003","KL3E17024014303","KL068010073E71303","KL1717022014102","KL14A70230066","KL14A702301010","KL15B40130044","KL1120C027259B8201","KL14A405001515","KL1418,18A0070044","KL108008009A6003","NPW086-6055062D4-A004","KL08140080077","KL048008047B204","KL0121014019004","NPW086-3056090C-5-B101","KL4E12015036101102","KL1119025110A2304","KL1122030040A203","KL2E300806161","KL1121029106C304","TP024003015402","KL13210560033","KL022010058kl-5-127","TP1180030671005","KL1718021025702","KM0625029031B501","TP14117,118091073B403","TP192002021601","TP195005061B205","TP10100124025702","TP2378078063B704","KL0870160A3","KM3437029035A105","KM35102019044B102","TP1145043039705","KM0935,36043108F008","KL1E17009014A203","KL1E15006060415","KL1E30017102D404","KL1E32022088C601","KL1E32022118D601","KL1E134052021303","KM3641,42041103D006","KH34C21,220190131501","KH35E61055047406","KH34B15,18A,17,19,200120422302","KH35E2002035A1002","KH0414016052D8","KH34C140130341002","KH203003039B703","KH2019A03102222","KH20140380055","KH2014038047B105","KH20551370044","KH0718,27015076F-17","KH2055137230A6703","KH2038157050B603","KH30127,128004026503","KH2022153312Z402","KH3024107016602","KH2040040011","KH049014002A002","KH0220020093C702","KH35H8006047A1104","KH119008016404","KH35I3003023303","KH1154049013B02","KH1151A047017A203","KH054003211M203","KH1019417117217e+011085003A301","KH1522030055G39","KH10207,208,209100022A602","KH212602801512","KH1524031043H-23","KH064,500406363","KH1520015023D210","KH1520015069D52","KH064,5004094B705","KH1524031261I-217","KH064,5004229H631","KH12B/47-34216","KH1819035011201","KH1517012027B211","KH12B-652010033","KH1517012151B1010","KH2169D,69K,69J07904141","KH2169D,69K,69J079088C301","KH1251018142F703","KH12B-90341","KH1854,53050009202","KH1947036007003","KH03I/1040150D702","KH16100718612203","KH12C-32/31476","KH162A004058Building","3201","KH03E-60067033B302","KH19290170311302","KH13144096036B303","KH19136074012502","KH13133083018A206","KH12D-346390077","KH12D/3564501414","KH12F-2993201717","KH12F-7910560044","KH12G-1191276","KH1169064078B-126","KH1169064152B-276","KH1976,77044037404","KH1240150A5","KH1248046006102","KH10109B,109C,109D,109E,109F,109G056011B101","KH36NA002048L2204","KH36NA006025L6902","KH36NA017075L17306","KH36NA030014L301201","KH362038028E","4504","KH362053004E-19301","KH36NA052028E18504","KH362054007E-20601","KH1249047004401","KH0611,12017001SONNET101","KH12E-1C874023103","NPE16370390A1","NPE16006007","KM1034040030B102","KH35E16,17,19010057A1802","KH13120123014303","KM14012008202","KM14008077C104","KM14008094C406","TPNP233029044407","TPNP2158047050B601","TPNP2158047059B103","KL152,6,3,4,1,9,5,7,8199127L21102","NPW1122023206A602","NPW1122023293B1101","NPW1123023502B706","KH401013035L-13103"
};
        
        
        try {
            // Base URL
            String baseUrl = "https://panvelmc.in/pages/onlinepayment.aspx?UniqID=";

            // Loop through the array of IDs
            for (String id : ids) {
                // Construct the URL
                String url = baseUrl + id;

              driver.get(url);
                
              
              try {
            	  WebElement row = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GVPropTax']/tbody/tr[5]/td[2]")); // Use appropriate locator
                  String year = row.getText();
                  
                  WebElement interest = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GVPropTax']/tbody/tr[5]/td[16]")); // Use appropriate locator
                  String interest1 = interest.getText();
                  
                  WebElement total = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GVPropTax']/tbody/tr[5]/td[20]")); // Use appropriate locator
                  String total1 = total.getText();
                  
                  System.out.println( id + ": " + year + ": " + interest1+ ": " + total1);
                  
			} catch (Exception e) {
				
				try {
					 WebElement row = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GVPropTax']/tbody/tr[4]/td[2]")); // Use appropriate locator
	                  String year = row.getText();
	                  
	                  WebElement interest = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GVPropTax']/tbody/tr[4]/td[16]")); // Use appropriate locator
	                  String interest1 = interest.getText();
	                  
	                  WebElement total = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GVPropTax']/tbody/tr[4]/td[20]")); // Use appropriate locator
	                  String total1 = total.getText();
	                  
	                  System.out.println( id + ": " + year + ": " + interest1+ ": " + total1);
				} catch (Exception e2) {
					
	                  
	                  try {
	                	  WebElement row = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GVPropTax']/tbody/tr[3]/td[2]")); // Use appropriate locator
		                  String year = row.getText();
		                  
		                  WebElement interest = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GVPropTax']/tbody/tr[3]/td[16]")); // Use appropriate locator
		                  String interest1 = interest.getText();
		                  
		                  WebElement total = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GVPropTax']/tbody/tr[3]/td[20]")); // Use appropriate locator
		                  String total1 = total.getText();
		                  
		                  System.out.println( id + ": " + year + ": " + interest1+ ": " + total1);
					} catch (Exception e3) {
						System.out.println( id + ": Paid" );
					}
	                  
	                  
				}
				 
                  
                  
                  
                  
			}
             

         
                

                // Perform any actions you need on the page
                // For example, you could print the page title
               

                // Add any additional interactions or validations here
            }
        } finally {
            // Close the WebDriver instance
//            driver.quit();
        }
 
		 
	}

}
