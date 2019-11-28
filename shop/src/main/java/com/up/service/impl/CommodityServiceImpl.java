package com.up.service.impl;

import com.up.entity.CommodityEntity;
import com.up.mapper.CommodityMapper;
import com.up.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    //商品添加方法
    @Override
    public void insertCommodity(CommodityEntity commodityEntity) {
        commodityMapper.insertCommodity(commodityEntity);
    }
    //查询商品信息
    @Override
    public List<CommodityEntity> queryCommodityList(CommodityEntity commodityEntity) {
        return commodityMapper.queryCommodityList(commodityEntity);
    }
}
