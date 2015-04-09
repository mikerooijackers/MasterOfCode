/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gebruiker
 */
public class JMSSettings {
    public enum RunMode {
                            MANUAL, AUTOMATICALLY 
                        }
    
    public static final String CREATE_WORKSPACE_REQUEST = "CREATE_WORKSPACE_REQUEST";
    public static final String CREATE_WORKSPACE_REPLY = "CREATE_WORKSPACE_REPLY";
    private static RunMode runMode;
    private static HashMap<String, String> map;

    public static void setRunMode(RunMode runMode) {
       JMSSettings.runMode = runMode;
    }

    public static RunMode getRunMode() {
       return JMSSettings.runMode;
    }
    
    public static void init(String fileName) {
        runMode = RunMode.AUTOMATICALLY;
        File file = new File(fileName);
        map = new HashMap<String, String>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().replaceAll(" ", "");
                StringTokenizer tk = new StringTokenizer(line, "=");
                String key = tk.nextToken();
                String value = tk.nextToken();
                System.out.println(key + "=" + value);
                map.put(key, value);
            }

            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JMSSettings.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public synchronized static String get(String queue) {
        return map.get(queue);
    }   
}
