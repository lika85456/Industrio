/**
 * Vytvoreno 19.05.2018 jako soucast Industrio.
 */
package com.lika85456.industrio;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//https://developer.android.com/training/data-storage/files
public class StorageManager {
    public static Context context;

    public static byte[] loadBytes(String name) throws IOException {
        FileInputStream inputStream = context.openFileInput(name);
        byte[] buffer = new byte[1024];
        int n;
        StringBuffer fileContent = new StringBuffer("");
        while ((n = inputStream.read(buffer)) != -1) {
            fileContent.append(new String(buffer, 0, n));
        }

        return fileContent.toString().getBytes();
        //nemusí vůbec fungovat
    }

    public static void saveBytes(String name, byte[] data) {
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(name, Context.MODE_PRIVATE);
            outputStream.write(data);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
