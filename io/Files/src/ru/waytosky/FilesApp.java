/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Ayrat
 */
public class FilesApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        FilesUtils_J8.deleteInDirectory("C:\\123");
//        FileChooser fChooser=new FileChooser();
//        File f = fChooser.showOpenDialog(new Stage());
        //Path path = Paths.get(FilesUtils.getApplicationFilePath());
        //java.nio.file.InvalidPathException: Illegal char <:> at index 4: 
        //file:/E:/INFO_tools/JAVA/advance/io/Files/build/classes/ru/waytosky/app.properties
//        System.out.println(FilesUtils.getApplicationFilePath());
        System.out.println(FilesUtils.copyFileToDirectory(
                "//netdisk/users/715/БикчентаевАА/Post/CHANCELLERY/Chancellery_UI.jar", 
                "d:/testcopy/dest/Chancellery_UI.jar"));
    }
    
}
