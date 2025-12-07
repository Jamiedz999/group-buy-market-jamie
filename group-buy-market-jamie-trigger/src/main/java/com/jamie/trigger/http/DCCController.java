package com.jamie.trigger.http;

import com.jamie.api.response.IDCCService;
import com.jamie.api.response.Response;
import com.jamie.types.enums.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RTopic;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Jamie
 * @date: 06/12/2025 22:04
 */

@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/v1/gbm/dcc")
@RestController
public class DCCController implements IDCCService {

    @Resource
    private RTopic dccTopic;

    @RequestMapping(value = "update_config", method = RequestMethod.GET)
    @Override
    public Response<Boolean> updateConfig(String key, String value) {
        try{

            dccTopic.publish(key + "," + value);

            return Response.<Boolean>builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .info(ResponseCode.SUCCESS.getInfo())
                    .build();

        }catch (Exception e){

            return Response.<Boolean>builder()
                    .code(ResponseCode.UN_ERROR.getCode())
                    .info(ResponseCode.UN_ERROR.getInfo())
                    .build();
        }

    }
}
