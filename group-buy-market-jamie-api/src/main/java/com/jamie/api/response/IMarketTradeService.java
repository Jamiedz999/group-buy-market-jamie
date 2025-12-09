package com.jamie.api.response;

import com.jamie.api.dto.LockMarketPayOrderRequestDTO;
import com.jamie.api.dto.LockMarketPayOrderResponseDTO;

/**
 * @description:
 * @author: Jamie
 * @date: 08/12/2025 22:38
 */
public interface IMarketTradeService {

    Response<LockMarketPayOrderResponseDTO> lockMarketPayOrder(LockMarketPayOrderRequestDTO lockMarkeyPayOrderRequestDTO);

}
