package com.mcl.util;

import java.io.*;
import org.apache.commons.codec.binary.Base64 ;
/**
 * Created by Administrator on 2018/2/4 0004.
 */
public class PhotoBase64Util {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/tmp/1.jpg");
        InputStream inputStream = new FileInputStream(file);
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        String encodemsg = Base64.encodeBase64String(data);
        System.out.println("length:"+encodemsg.length());
        //System.out.println("data:"+encodemsg);
        inputStream.close();

        File cpfile = new File("D:/2.jpg");
        OutputStream outputStream = new FileOutputStream(cpfile);
        byte[] cpdata = Base64.decodeBase64(encodemsg);
        outputStream.write(cpdata);
        outputStream.flush();
        outputStream.close();

    }

}
