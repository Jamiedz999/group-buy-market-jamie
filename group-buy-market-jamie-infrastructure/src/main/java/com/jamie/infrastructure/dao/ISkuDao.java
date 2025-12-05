package com.jamie.infrastructure.dao;

import com.jamie.infrastructure.dao.po.Sku;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 17:21
 */
@Mapper
public interface ISkuDao {

    Sku querySkuByGoodsId(String goodsId);

}
