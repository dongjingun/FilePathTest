package com.example.admin.filepathtest;

import android.os.Environment;

import java.io.*;

/**
 * Created by admin on 2016/8/17.
 */
public class javatext {

    public static void main(String[]arg) throws IOException {
        String root= "D:\\";
        String path=root+File.separator+"zzzzzz"+File.separator+"s.txt";
        File file =new File(path);
        if (!file.exists()){
          file.getParentFile().mkdirs();
        }
        // 文件不存在会自动创建,但是父路径不存在不会自动创建
//        FileOutputStream out=new FileOutputStream(path);
//        String str="hello";
//        byte []bytes=str.getBytes();
//        out.write(bytes);
//
//        out.close();
//        FileWriter writer=new FileWriter(file,true);
//        writer.append("------nonono----"+writer.getEncoding());
//        writer.close();
      //-------------读取----带缓存-----字节流----------------
        InputStream in =new FileInputStream(file);
        StringBuffer sb= new StringBuffer();
        byte[]bytes=new byte[1024];
        int len;
        while ((len=in.read(bytes))!=-1){
            sb.append(new String(bytes,0,len));

        }
        System.out.println(sb);


//        ----------读取---字符---------
//        BufferedReader reader = new BufferedReader(new FileReader(file));
//
//        StringBuffer sb =new StringBuffer();
//        String str;
//        while ((str=reader.readLine())!=null){
//            sb.append(str);
//        }
//        System.out.println(sb);


//        ---------------------------------

    }

}
