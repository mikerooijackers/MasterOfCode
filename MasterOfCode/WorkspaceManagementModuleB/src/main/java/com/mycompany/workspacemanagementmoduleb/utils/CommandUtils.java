/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.workspacemanagementmoduleb.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author JordiK
 */
public final class CommandUtils {
    
    private CommandUtils() {
        
    }
    
    /**
     *
     * @param directory
     * @param command
     * @return
     */
    public static String runCommand(String directory, String command) {
        Process p;
        String output = "";
        
        try {
            p = Runtime.getRuntime().exec(command, null, new File(directory));
            p.waitFor();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            String line = "";
            
            while((line = reader.readLine()) != null) {
                output += line + "\n";
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        return output;
    }
    
    /**
     *
     * @param directory
     * @param command
     * @return
     */
    public static String runCommand(File directory, String command) {
        Process p;
        String output = "";
        
        try {
            p = Runtime.getRuntime().exec(command, null, directory);
            p.waitFor();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            String line = "";
            
            while((line = reader.readLine()) != null) {
                output += line + "\n";
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        return output;
    }
}
