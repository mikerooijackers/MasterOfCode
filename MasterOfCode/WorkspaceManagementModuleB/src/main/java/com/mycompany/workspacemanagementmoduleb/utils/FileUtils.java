/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.workspacemanagementmoduleb.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 *
 * @author Gebruiker
 */
public class FileUtils {

    /**
     *
     * @param file
     * @param extension
     * @return
     */
    public static boolean checkFileExtension(File file, String extension) {
        String fileName = file.getName();
        int index = fileName.lastIndexOf('.');
        String foundExtension = "";

        if (index >= 0) {
            foundExtension = fileName.substring(index);
        }

        return extension.equals(foundExtension);
    }

    /**
     *
     * @param file
     * @param destination
     */
    public static void extractJARFile(File file, String destination) {
        InputStream is = null;
        FileOutputStream fos = null;

        try {
            JarFile jar = new JarFile(file);
            Enumeration enumeration = jar.entries();

            while (enumeration.hasMoreElements()) {
                JarEntry entry = (JarEntry) enumeration.nextElement();
                File f = new File(destination + java.io.File.separator + entry.getName());

                if (entry.isDirectory()) { // if its a directory, create it
                    f.mkdir();
                    continue;
                }

                is = jar.getInputStream(entry); // get the input stream
                fos = new FileOutputStream(f);

                while (is.available() > 0) {  // write contents of 'is' to 'fos'
                    fos.write(is.read());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param file
     * @param destination
     */
    public static void extractZIPFile(File file, String destination) {
        try {
            ZipFile zipFile = new ZipFile(file);
            zipFile.extractAll(destination);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @param sourceFile
     * @return
     */
    public static String readContentOfSourceCode(File sourceFile) {
        String output = "";
        FileReader reader = null;
        try {
            reader = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                output += line + "\n";
            }

            int length = output.length();
            if (length > 0) {
                output = output.substring(0, length - 1);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return output;
    }
}
