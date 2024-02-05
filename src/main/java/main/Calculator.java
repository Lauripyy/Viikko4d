package main;

import java.io.Serializable;
import java.util.Scanner;

public class Calculator implements Serializable{
    
private transient Scanner sc;
    public Calculator(Scanner sc){
        this.sc=sc;
    }
    
}
