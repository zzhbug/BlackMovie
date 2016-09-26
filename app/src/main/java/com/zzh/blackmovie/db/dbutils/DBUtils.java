package com.zzh.blackmovie.db.dbutils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class DBUtils {

    public static String urlToMD5(String url) {
        StringBuffer buffer = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(url.getBytes());
            byte[] digest = md.digest();
            int i;

            buffer = new StringBuffer("");
            for (int offset = 0; offset < digest.length; offset++) {
                i = digest[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buffer.append("0");
                    buffer.append(Integer.toHexString(i));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }
}
