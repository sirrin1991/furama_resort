package commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile<E> {

    public void write(E e, String path, boolean writeMode) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path, writeMode));
            bw.write(e.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void writeList(List<E> e,String path,boolean writeMode){
        BufferedWriter bw =null;
        try{
            bw = new BufferedWriter(new FileWriter(path,writeMode));
            for(E element : e){
                bw.write(element.toString());
                bw.newLine();
            }
            bw.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public List<String[]> read(String path) {
        BufferedReader br = null;
        List<String[]> list = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(path));
            String str;
            String[] strings;
            while ((str = br.readLine()) != null) {
                strings = str.split(",");
                list.add(strings);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
