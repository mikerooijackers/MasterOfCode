/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO: move methods to the right classes, perhaps to a different module.
 *
 * @author May
 */
public class ClientService {

    /**
     * Compiles the given application and shows a stack trace if the compilation
     * fails.
     *
     * @param path
     * @return false if compilation fails, true if it succeeds
     */
    public boolean requestCompile(String path) {

        if (path == null) {
            System.out.println("The project to compile cannot be found");
            return false;
        }
        try {
            new ProcessBuilder(
                    path, "param1", "param2").start();
        } catch (IOException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Compilation successful");
        return true;
    }
}
