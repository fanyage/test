package com.up.master;

import com.up.service.MixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @PACKAGE com.up.master.Mix
 * @DATE 2019/10/6 19:42
 * @AUTHOR LZ
 * @EFFECT
 **/

/**
 * 此类方法除去all & judge方法外禁止外部调用
 */
@Controller
@RequestMapping("mix")
public class Mix {
    @Autowired
    private MixService mixService;

    private Map<String, Object> map = new HashMap<String, Object>() {{
        put("data", "");
        put("massage", "");
        put("hi", "");
    }};

    private static Pattern p = Pattern.compile("[^0-9]");

    public static void main(String[] args) {
    }
    @RequestMapping("all")
    public ModelAndView all(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/mix/show");
        return modelAndView;
    }
    /**
     * 判断
     * @param str
     */
    @RequestMapping("judge")
    @ResponseBody
    public Map judge(String str){
        int time = new Date().getHours();
        String hint = "";
        if (time < 5) {
            hint = "凌晨";
        }
        if (time > 5 && time < 10) {
            hint = "早上";
        }
        if (time >= 10 && time < 16) {
            hint = "中午";
        }
        if (time >= 16 && time < 19) {
            hint = "下午";
        }
        if (time >= 19) {
            hint = "晚上";
        }
        map.put("hi", "好");
        String trim = str.trim();
        trim = trim.toUpperCase();
        if (trim.contains("什么")) {
            map.put("data", trim);
            map.put("massage", 2);
            return map;
        }
        if (trim.contains("你好") || trim.contains("HI") || trim.contains("HELLO")) {
            int i = 0;
            if (trim.contains("我叫")) {
                i = trim.indexOf("我叫") + 2;
                map.put("hi", hint + "好," + str.substring(i,trim.length()) + ".");
            } else if (trim.contains("我是")) {
                i = trim.indexOf("我是") + 2;
                map.put("hi", hint + "好," + str.substring(i,trim.length()) + ".");
            }
            map.put("data", trim);
            map.put("massage", 2);
            return map;
        }
        return map;
    }

    /**
     * 学习
     * @param ask
     * @param answer
     */
    public void study(String ask, String answer){

    }

}
