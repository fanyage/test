package com.up.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @PACKAGE com.up.utils.OCRClient
 * @DATE 2019/10/7 17:22
 * @AUTHOR LZ
 * @EFFECT
 **/

public class OCRClient {
    //腾讯云ocr身份证文字识别
    //腾讯云文字识别服务器域名
    public static final String HOST = "recognition.image.myqcloud.com";
    //使用 application/json 格式，参数为 url ，其值为图片链接
    public static final long APPID=1258856899;
    //secretida
    public static final String SECRET_ID = "AKIDgR1Sy5BwiQzIbz660auz2lIGD3DOefaP";
    //secretkey
    public static final String SECRET_KEY= "mJbnnnhkwxjJhquwoEA5kKgxBD5iEXVE";
    //请求的域名
    public static final String TARGETURL = "https://recognition.image.myqcloud.com/ocr/idcard";
    //图片路径
    public static final String IDURL="https://imgs6.oss-cn-beijing.aliyuncs.com/lzz.jpg";

    public static void main(String[] args) {
        try {
            //发送HTTP请求，先要创建一个httpclient
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //创建一个post请求
            HttpPost httpPost = new HttpPost(TARGETURL);
            //组装请求头信息
            httpPost.setHeader("host", "recognition.image.myqcloud.com");
            httpPost.setHeader("content-type", "application/json");
            httpPost.setHeader("authorization", Sign.appSign(APPID, SECRET_ID, SECRET_KEY, null, 0));
            //组装接口需要的参数
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("appid",APPID);
            jsonObject.put("card_type",0);
            jsonObject.put("url_list",IDURL);
            //将需要的参数放入HTTP请求中
            StringEntity stringEntity = new StringEntity(jsonObject.toString(),"utf-8");
            httpPost.setEntity(stringEntity);
            //发送请求
            CloseableHttpResponse response = httpClient.execute(httpPost);
            int code = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity);
            System.out.println(code);
            System.out.println(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
