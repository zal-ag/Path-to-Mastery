package com.Silas.exception.logging;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class JdkLogging {
    static void main() {
        Logger logger = Logger.getLogger(JdkLogging.class.getName());
        logger.info("Start process");
        try{
            "".getBytes("invalidCharsetName");
        }catch(UnsupportedEncodingException e){
            logger.severe(e.toString());
        }
        logger.info("Process end.");
    }
}
