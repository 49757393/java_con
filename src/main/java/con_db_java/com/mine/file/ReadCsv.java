package com.mine.file;


import java.io.*;    
import java.util.*;

public class ReadCsv { 
        public static List<List<String>> readCSV(String filePath, boolean hasTitle){
                List<List<String>> data=new ArrayList<>();
                String line=null;
                try {
                    //BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath));
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"utf-8"));
                    if (hasTitle){
                        //第一行信息，为标题信息
                        line = bufferedReader.readLine();
                        String[] items=line.split(",");
                        data.add(Arrays.asList(items));
                        System.out.println("标题行："+line);
                    }
        
                    int i=0;
                    while((line=bufferedReader.readLine())!=null){
                        i++;
                        //数据行
                        String[] items=line.split(",");
                        data.add(Arrays.asList(items));
                        //System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        
                return data;
            }
        public static void main(String[] args) 
        {
            
        System.out.println(readCSV("/home/yangliang/data.csv",false));
        }
}