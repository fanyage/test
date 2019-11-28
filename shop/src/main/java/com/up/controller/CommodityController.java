package com.up.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.up.entity.CommodityEntity;
import com.up.service.CommodityService;
import com.up.utils.FileUtil;
import com.up.utils.LzOosUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

import static com.up.utils.LzOosBi.BACKET_NAME;
import static com.up.utils.LzOosBi.FOLDER;

@Controller
@RequestMapping("commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    //商品添加
    @RequestMapping("insertCommodity")
    public String insertCommodity(CommodityEntity commodityEntity) {
        commodityService.insertCommodity(commodityEntity);
        //初始化OSSClient
        OSSClient ossClient=LzOosUtil.getOSSClient();
        if (commodityEntity.getPhoto()!=null){
            String photo = commodityEntity.getPhoto();
            File file=new File(photo);
            LzOosUtil.uploadObject2OSS(ossClient, file, BACKET_NAME, FOLDER);
        }
        return "redirect:toQueryCommodity";
    }

    //跳转到商品增加页面
    @RequestMapping("toCommodityInsert")
    public String toCommodityInsert() {
        return "view/commodity/insertCommodity";
    }


    //文件上传,获取图片路径
    //文件上传
    @RequestMapping(value="uploadFile",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String uploadFile(HttpServletRequest req, MultipartHttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile multipartFile ){
        request = (MultipartHttpServletRequest) req;
        multipartFile = request.getFile("file");
        String realPath = FileUtil.multipartFileUploadToLocalhost(request, multipartFile,"upload");
        //获取源文件名
        String fileMultipartFileName = multipartFile.getOriginalFilename();
        JSONObject json=new JSONObject();
        json.put("aaa", realPath);
        json.put("fileName", fileMultipartFileName);
        return json.toString();
    }
    //跳转到商品展示页面
    @RequestMapping("toQueryCommodity")
    public  String toQueryCommodity(){
     return "view/commodity/commodityList";
    }
    //商品查询展示
    @RequestMapping("queryCommodityList")
    public ModelAndView queryCommodityList(CommodityEntity commodityEntity){
        ModelAndView mv=new ModelAndView();
        //查询商品表所有信息
        List<CommodityEntity> queryCommodity=commodityService.queryCommodityList(commodityEntity);
        mv.addObject("commodityList",queryCommodity);
        mv.setViewName("view/commodity/commodityTable");
        return mv;
    }
}

