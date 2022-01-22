package com.example.wafdemo1.dao;

import java.io.InputStream;

/**
 * @author zc
 * @Description TODO
 * @date 2021/12/28 10:52 下午
 * @Version 1.0
 */
public class QrcodeUtil {
   public static InputStream getUrl(){
        return QrcodeUtil.class.getResourceAsStream("/test.txt");
    }
}
