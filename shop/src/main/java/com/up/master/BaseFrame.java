package com.up.master;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * @PACKAGE com.up.master.BaseFrame
 * @DATE 2019/10/6 21:14
 * @AUTHOR LZ
 * @EFFECT
 **/

public class BaseFrame extends JFrame {

    private static long appId = 1300380414;
    private static String secretId = "AKIDax95oH1lLioiMkJuoOkqlTwIWXHotXnf";
    private static String secretKey = "A5KODmEWbQzMXS7e080c6LK2c0A4yhgS";
    private static String bucketName = null;
    private static long expired = 0;
/*
    public static void main(String[] args) {
        CloseableHttpClient http = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost();
        httpPost.setHeader("host","recognition.image.myqcloud.com");
        httpPost.setHeader("content-type","application/json");
        try {
            httpPost.setHeader("authorization",Test.appSign(appId, secretId, secretKey, bucketName, expired));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


    /*public static void main(String[] args) {
        JFrame frame=new JFrame("Java牛逼");
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel cards=new JPanel(new CardLayout());
        p1.add(new JButton("登录按钮"));
        p1.add(new JButton("注册按钮"));
        p1.add(new JButton("找回密码按钮"));
        p2.add(new JTextField("用户名文本框",20));
        p2.add(new JTextField("密码文本框",20));
        p2.add(new JTextField("验证码文本框",20));
        cards.add(p1,"card1");
        cards.add(p2,"card2");
        CardLayout cl=(CardLayout)(cards.getLayout());
        cl.show(cards,"card1");
        cl.show(cards,"card1");
        frame.add(cards);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}
