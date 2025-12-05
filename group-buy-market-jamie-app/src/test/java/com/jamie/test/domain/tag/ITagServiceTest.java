package com.jamie.test.domain.tag;

import com.jamie.domain.tag.service.ITagService;
import com.jamie.infrastructure.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBitSet;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Jamie
 * @date: 05/12/2025 12:38
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ITagServiceTest {


    @Resource
    private ITagService tagService;
    @Resource
    private IRedisService redisService;

    @Test
    public void test_tag_job(){
        tagService.exexTagBatchJob("JAMIEJAMIEJAMIE", "10001");
    }

    @Test
    public void test_get_tag_bitmap(){
        RBitSet bitSet = redisService.getBitSet("JAMIEJAMIEJAMIE");
        log.info("test result: {}", bitSet.get(redisService.getIndexFromUserId("xiaofuge")));
        log.info("test result: {}", bitSet.get(redisService.getIndexFromUserId("fgrh")));
    }

}
