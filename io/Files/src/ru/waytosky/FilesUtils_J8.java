/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.waytosky;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 *
 * @author Ayrat
 */
public class FilesUtils_J8 {
    public static void deleteInDirectory(String path)throws IOException{
        
        Files.walk(Paths.get(path))
//                .filter(Files::isRegularFile)
                .filter(f->{try{
                    return 
//                            Files.isRegularFile(f)&&
                            (Files.getLastModifiedTime(f).toMillis()<(new Date()).getTime()-10000);
                }catch(IOException e){
                    return true;
                }
                            })
                .map(Path::toFile)
                .forEach(File::delete);
        
    }
}
