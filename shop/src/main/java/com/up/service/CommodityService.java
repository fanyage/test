package com.up.service;

import com.up.entity.CommodityEntity;

import java.util.List;

public interface CommodityService {

    void insertCommodity(CommodityEntity commodityEntity);

    List<CommodityEntity> queryCommodityList(CommodityEntity commodityEntity);
}
