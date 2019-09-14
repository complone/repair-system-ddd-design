package com.lizhi.guide.util;

import javax.sql.rowset.serial.SerialBlob;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

public class DataTypeUtils {

    public  static Long TransferFromInttoLong(int preTransfer){
        Long result = Long.parseLong(String.valueOf(preTransfer));
        return result;
    }


    public static Integer TransferFromLongtoInt(Long preTranser){
        int result = Integer.parseInt(String.valueOf(preTranser));
        return result;
    }

    public static Blob TransferFromStringtoBlob(String preTransfer){
        Blob blob = null;
        try {
            blob = new SerialBlob(preTransfer.getBytes("GBK"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return blob;
    }

    public static String TransferFromBlobToString(Blob blob){
        String blobString = "";
        try {
            blobString = new String(blob.getBytes(1, (int) blob.length()),"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blobString;
    }

}
