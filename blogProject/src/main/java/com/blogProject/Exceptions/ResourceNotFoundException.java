package com.blogProject.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String filedName;
    private int filedValue;


    public ResourceNotFoundException(String resource, String filedName, int filedValue) {
        super(String.format("%s not found with %s : %d", resource,filedName,filedValue));
        this.resource = resource;
        this.filedName = filedName;
        this.filedValue = filedValue;
    }
    

    

}
