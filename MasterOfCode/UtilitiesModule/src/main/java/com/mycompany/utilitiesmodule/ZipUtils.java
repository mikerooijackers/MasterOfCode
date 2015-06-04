/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utilitiesmodule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gebruiker
 */
public class ZipUtils {
    public static byte[] convertFileToByteArray(File file) {
        FileInputStream is = null;
        byte[] blob = null;
        try {
            is = new FileInputStream(file);
            int fileSize = is.available();
            blob = new byte[fileSize];
            int bytes_read = 0;
            int offset = 0;
            while (bytes_read != -1 && offset < fileSize)
            {
                bytes_read = is.read(blob, offset, fileSize);
                offset += bytes_read;
            }   
            is.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ZipUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ZipUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(ZipUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return blob;
    }
    
    public static void writeByteArrayToFile(byte[] blob, File destination) {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(destination);
            os.write(blob);
            os.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ZipUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ZipUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                os.close();
            } catch (IOException ex) {
                Logger.getLogger(ZipUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
