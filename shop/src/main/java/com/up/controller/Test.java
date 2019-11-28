package com.up.controller;

import com.alibaba.fastjson.JSONObject;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Random;

/**
 * @PACKAGE com.up.controller.Test
 * @DATE 2019/10/6 15:23
 * @AUTHOR LZ
 * @EFFECT
 **/

public class Test {
    //腾讯云ocr身份证文字识别
    //腾讯云文字识别服务器域名
    public  static  final String HOST="recognition.image.myqcloud.com";

    //使用 application/json 格式，参数为 url ，其值为图片链接
    public static final long APPID=1258856899;

    //secretida
    public static final String SECRET_ID = "AKIDgR1Sy5BwiQzIbz660auz2lIGD3DOefaP";

    //secretkey
    public static final String SECRET_KEY= "mJbnnnhkwxjJhquwoEA5kKgxBD5iEXVE";
    //请求的域名
    public static final String TARGETURL = "https://recognition.image.myqcloud.com/ocr/idcard";
    //图片路径
    public static final String IDURL="";

    public static void main(String[] args) {
        //创建一个httpclients
        CloseableHttpClient aDefault = HttpClients.createDefault();
        //创建一个post请求
        HttpPost httpPost = new HttpPost(TARGETURL);
        //组装请求头信息
        httpPost.setHeader("host","recognition.image.myqcloud.com");
        httpPost.setHeader("content-type","application/json");
        try {
            httpPost.setHeader("authorization",Test.appSign(APPID,SECRET_ID,SECRET_KEY,null,0));
        //组装接口需要的参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appid", APPID);
        jsonObject.put("card_type",0);
        jsonObject.put("url_list",IDURL);
        //将需要的参数放入http请求中
        StringEntity stringEntity = new StringEntity(jsonObject.toString(),"utf-8");
        httpPost.setEntity(stringEntity);
        //发送请求
        CloseableHttpResponse response = aDefault.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity);
            System.out.println(statusCode);
            System.out.println(string);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 生成 Authorization 签名字段
     *
     * @param appId
     * @param secretId
     * @param secretKey
     * @param bucketName
     * @param expired
     * @return
     * @throws Exception
     */
    public static String appSign(long appId, String secretId, String secretKey, String bucketName,
                                 long expired) throws Exception {
        long now = System.currentTimeMillis() / 1000;
        int rdm = Math.abs(new Random().nextInt());
        String plainText = String.format("a=%d&b=%s&k=%s&t=%d&e=%d&r=%d", appId, bucketName,
                secretId, now, now + expired, rdm);
        byte[] hmacDigest = HmacSha1(plainText, secretKey);
        byte[] signContent = new byte[hmacDigest.length + plainText.getBytes().length];
        System.arraycopy(hmacDigest, 0, signContent, 0, hmacDigest.length);
        System.arraycopy(plainText.getBytes(), 0, signContent, hmacDigest.length,
                plainText.getBytes().length);
        return Base64Encode(signContent);
    }

    /**
     * 生成 base64 编码
     *
     * @param binaryData
     * @return
     */
    public static String Base64Encode(byte[] binaryData) {
        String encodedstr = Base64.getEncoder().encodeToString(binaryData);
        return encodedstr;
    }

    /**
     * 生成 hmacsha1 签名
     *
     * @param binaryData
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] HmacSha1(byte[] binaryData, String key) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
        mac.init(secretKey);
        byte[] HmacSha1Digest = mac.doFinal(binaryData);
        return HmacSha1Digest;
    }

    /**
     * 生成 hmacsha1 签名
     *
     * @param plainText
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] HmacSha1(String plainText, String key) throws Exception {
        return HmacSha1(plainText.getBytes(), key);
    }


}
