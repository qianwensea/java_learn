package com.shi.base64;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author 千文sea
 * @create 2020-04-23 17:18
 */
public class Base64Test {
    @Test
    public void testBase64() throws Exception {
        String content = "这是需要的Base64编码的内容";
        //创建一个Base64编码器
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //执行Base64编码操作
        String encodeString = base64Encoder.encode(content.getBytes("UTF-8"));
        System.out.println(encodeString);

        //创建Base64解码器
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] decodeBuffer = base64Decoder.decodeBuffer(encodeString);
        String str = new String(decodeBuffer,"UTF-8");
        System.out.println(str);
    }

}
