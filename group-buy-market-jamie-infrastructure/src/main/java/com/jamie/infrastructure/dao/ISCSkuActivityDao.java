package com.jamie.infrastructure.dao;

import com.jamie.infrastructure.dao.po.SCSkuActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: Jamie
 * @date: 05/12/2025 16:37
 */

@Mapper
public interface ISCSkuActivityDao {

    SCSkuActivity querySCSkuActivityBySCGoodsId(SCSkuActivity scSkuActivity);

}
