package utility;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import pom.CounterPaymentPage;

public class CounterPaymentData {

	public static Map<String, String> map;
	
	public static Map<String, String> counterPaymentAllData(WebDriver driver)
	{
		map = new LinkedHashMap<String, String>();
		CounterPaymentData.counterPaymentPendingRow(driver);
		CounterPaymentData.counterPaymentCurrentRow(driver);
		CounterPaymentData.counterPaymentAllRow(driver);
		return map;
	}
	
	
	public static void counterPaymentPendingRow(WebDriver driver)
	{
		int TaxHeadTotal = 0;
		int TaxTotal = 0;
		int discount = 0;
		int NetTotal = 0;
		
		CounterPaymentPage counterpayment = new CounterPaymentPage(driver);
		List<Integer> p_list = counterpayment.Get_pendingList(driver);
		TaxTotal = p_list.get(p_list.size()-3);
		discount = p_list.get(p_list.size()-2);
		NetTotal = p_list.get(p_list.size()-1);
		
		for(int i=0;i<p_list.size()-3;i++)
		{
			TaxHeadTotal += p_list.get(i);
		}
		
		if(!(TaxHeadTotal == TaxTotal))
		{
			map.put("pTaxHeadTotal", "HeadTax and Total not Match");
		}
		
		if(!((TaxTotal-discount) == NetTotal))
		{
			map.put("pNetTotal", "NetTotal is incorrect");
		}
		
//		map.put("test1", "passPendingTest");
	}
	
	public static void counterPaymentCurrentRow(WebDriver driver)
	{
		int TaxHeadTotal = 0;
		int TaxTotal = 0;
		int discount = 0;
		int NetTotal = 0;
		
		CounterPaymentPage counterpayment = new CounterPaymentPage(driver);
		List<Integer> c_list = counterpayment.Get_currentList(driver);
		TaxTotal = c_list.get(c_list.size()-3);
		discount = c_list.get(c_list.size()-2);
		NetTotal = c_list.get(c_list.size()-1);
		
		for(int i=0;i<c_list.size()-3;i++)
		{
			TaxHeadTotal += c_list.get(i);
		}
		
		if(!(TaxHeadTotal == TaxTotal))
		{
			map.put("cTaxHeadTotal", "HeadTax and Total not Match");
		}
		
		if(!((TaxTotal-discount) == NetTotal))
		{
			map.put("cNetTotal", "NetTotal is incorrect");
		}
//		map.put("test2", "passCurrentTest");
	}
	
	public static void counterPaymentAllRow(WebDriver driver)
	{
		int TaxHeadTotal = 0;
		int TaxTotal = 0;
		int discount = 0;
		int NetTotal = 0;
		
		CounterPaymentPage counterpayment = new CounterPaymentPage(driver);
		List<Integer> t_list = counterpayment.Get_totalList(driver);
		TaxTotal = t_list.get(t_list.size()-3);
		discount = t_list.get(t_list.size()-2);
		NetTotal = t_list.get(t_list.size()-1);
		
		for(int i=0;i<t_list.size()-3;i++)
		{
			TaxHeadTotal += t_list.get(i);
		}
		
		if(!(TaxHeadTotal == TaxTotal))
		{
			map.put("allTaxHeadTotal", "HeadTax and Total not Match");
		}
		
		if(!((TaxTotal-discount) == NetTotal))
		{
			map.put("allNetTotal", "NetTotal is incorrect");
		}
//		map.put("test3", "passAllTest");
	}
}
