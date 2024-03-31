package com.test1;

import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;
import java.util.Date;

public class CSVUtils {
    
    private static final String NEW_LINE_SEPARATOR = "\n";

    /**
     *
     *
     * @param w
     * @param DELIMITER
     * @param values
     * @throws IOException
     */
    public static void writeLine(Writer w, String DELIMITER, String ...values)  throws IOException {
    	StringBuilder sb = new StringBuilder();
        for (String value : values) 
        	sb.append(value).append(DELIMITER);

        sb.append(NEW_LINE_SEPARATOR);
        w.append(sb);
    }

    /**
     *  add days to the calendar
     *
     * @param date
     * @param days
     * @return
     */
    public static Date changeDate(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);

        return cal.getTime();
    }
}
