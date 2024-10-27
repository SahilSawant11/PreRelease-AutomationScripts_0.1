package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCalculation {

	public static String CurrentDate()
	{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String s = formatter.format(date);
		return s;
	}
}
