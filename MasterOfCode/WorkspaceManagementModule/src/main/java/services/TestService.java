/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JordiK
 */
public class TestService {
    public TestService() {
        
    }
    
    public String runTestGroup(String group, String directory) {
        String command = "cmd.exe /c mvn test -Dgroup=" + group;
        return runCommand(command, directory);
    }
    
    public String runSingleTest(String test, String directory) {
        String command = "cmd.exe /c mvn test -Dtest=" + test;
        return runCommand(command, directory);
    }
    
    public String runCommand(String command, String directory) {
        String output = "";
        Process p;
        try {
            p = Runtime.getRuntime().exec(command, null, new File(directory));
            p.waitFor();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = r.readLine()) != null) {
                output += line + "\n";
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
}
