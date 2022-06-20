package com.example.internal.controller;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOFile {
    public static <T> ArrayList<T> doc(Context c, String filename) {
        ArrayList<T> list= new ArrayList<>();
        try{
            ObjectInputStream ois= new ObjectInputStream(c.openFileInput(filename));
            list= (ArrayList<T>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static <T> void ghi(Context c,String filename, ArrayList<T> list){
        try{
            ObjectOutputStream oos= new ObjectOutputStream(c.openFileOutput(filename,Context.MODE_PRIVATE));
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
