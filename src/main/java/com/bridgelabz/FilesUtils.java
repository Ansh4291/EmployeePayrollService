package com.bridgelabz;

import java.io.File;

public class FilesUtils {
    public static boolean deleteFiles(File contentAreDelete) {
        File[] allData = contentAreDelete.listFiles();
        if (allData != null)
        {
            for (File file : allData)
            {
                deleteFiles(file);
            }
        }
        return contentAreDelete.delete();
    }
}