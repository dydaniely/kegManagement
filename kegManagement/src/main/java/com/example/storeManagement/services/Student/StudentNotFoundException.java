package com.example.storeManagement.services.Student;

/**
 * Created by Daniel on 1/10/2017.
 */
public class StudentNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbgeneric;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author ISDDYT
 */
public class JAXBGeneric {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner s= new Scanner(System.in);
        System.out.println("Please Enter schema Filename");
        String schema=s.next();
          System.out.println("Specify The Generated  files source folder");
          String dir=s.next();
            System.out.println("Specify The package where the generated files stored");
        String packageFile=s.next();
        
        String command ="xjf " + schema + "-p " + packageFile + "-d " + dir;  
         JAXBGeneric obj= new JAXBGeneric();
        String outPut=obj.executeCommand(command);
        
        
    }

    private String executeCommand(String command) {
        StringBuffer  buffer=new StringBuffer();
        Process p;
        try{
            p=Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(p.getInputStream()));
        
            String line;
            while ((line=bufferedReader.readLine())!=null){
                buffer.append(line);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    return  buffer.toString();
    }
    
    
    
}

}

