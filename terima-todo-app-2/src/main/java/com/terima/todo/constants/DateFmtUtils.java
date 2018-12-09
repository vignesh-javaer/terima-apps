/**
 * 
 */
package com.terima.todo.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author vignesh
 *
 */
public class DateFmtUtils {
	
	public static String getDateByYYYYMMDDHHMMSS() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(date);
	}
	
	/**
	 * UID091837122304
	 * 
	 * @return
	 */
	public static String getDateByHHYYMMMMSSDD() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hhYYmmMMssdd");
		return sdf.format(date);
	}

	
}
