package com.test1;

import java.io.IOException;
import java.io.Writer;

public class CSVUtils {

    
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void writeLine(Writer w, String DELIMITER, String ...values)  throws IOException {    	
    	StringBuilder sb = new StringBuilder();
        for (String value : values) 
        	sb.append(value).append(DELIMITER);

        sb.append(NEW_LINE_SEPARATOR);
        w.append(sb);
    }

}