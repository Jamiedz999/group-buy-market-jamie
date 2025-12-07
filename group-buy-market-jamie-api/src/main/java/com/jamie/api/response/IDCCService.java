package com.jamie.api.response;

/**
 * @description:
 * @author: Jamie
 * @date: 06/12/2025 22:03
 */
public interface IDCCService {

    Response<Boolean> updateConfig(String key, String value);
}
