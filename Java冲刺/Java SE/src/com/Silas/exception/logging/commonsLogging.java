package com.Silas.exception.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class commonsLogging {
    static void main() {
        Log log = LogFactory.getLog(commonsLogging.class);
        log.info("Start...");
        log.warn("end...");

        try{
            String str = null;
            System.out.println(str.length());
        }catch(NullPointerException e){
            log.error("got exception",e);
        }
    }
}
