package com.example.a91214.listview;

import android.content.Context;
import java.io.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemNotFoundException;

/**
 * Created by 91214 on 2018/10/18.
 */
/*
public class HolidayOperater {
    private String file = "yiheng.txt";
    public ArrayList<Holiday> readObject(Context context) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = context.openFileInput(file);
            ois = new ObjectInputStream(fis);
            return (ArrayList<Holiday>) ois.readObject();


        } catch (FileNotFoundException e) {

        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof InvalidClassException) {
                File data = context.getFileStreamPath(file);
                data.delete();


            }


        } finally {
            try {
                ois.close();

            } catch (Exception e) {


            }
            try {
                fis.close();
            } catch (Exception e) {
            }


        }
        return null;}

    public void saveObject(Context context,Serializable ser){
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            fos=context.openFileOutput(file,Context.MODE_PRIVATE);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(ser);
            oos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                oos.close();}
            catch (Exception e){
                e.printStackTrace();}
                try {
                    fos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }}}
    }
*/

