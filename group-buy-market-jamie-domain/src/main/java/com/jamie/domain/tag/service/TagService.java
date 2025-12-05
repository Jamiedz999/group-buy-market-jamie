package com.jamie.domain.tag.service;

import com.jamie.domain.tag.adapter.repository.ITagRepository;
import com.jamie.domain.tag.model.entity.CrowdTagsJobEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Jamie
 * @date: 05/12/2025 11:38
 */

@Service
@Slf4j
public class TagService implements ITagService{

    @Resource
    private ITagRepository repository;
    @Override
    public void exexTagBatchJob(String tagId, String batchId) {
        // 1
        CrowdTagsJobEntity crowdTagsJobEntity = repository.queryCrowdTagsJobEntity(tagId,batchId);

        //2, 采集用户数据

        List<String> userIdList = new ArrayList<String>(){{
            add("xiaofuge");
            add("jamie");
        }};

        for (String userId : userIdList) {
            repository.addCrowTagsUserId(tagId, userId);
        }
        //3.更新人群标签统计量
        repository.updateCrowTagsStatistics(tagId, userIdList.size());

    }
}
