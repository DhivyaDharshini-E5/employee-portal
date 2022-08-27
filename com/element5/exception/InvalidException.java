package com.element5.exception;

import java.lang.Exception;

public class InvalidException extends Exception {
   
    String message;
    public InvalidException(String error) {
    message = error;
    }
  
    public String toString() {
        return("InvalidException occured:"+message);  
    }
}