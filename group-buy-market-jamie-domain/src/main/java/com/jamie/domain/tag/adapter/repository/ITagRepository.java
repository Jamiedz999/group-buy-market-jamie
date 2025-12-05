package com.jamie.domain.tag.adapter.repository;

import com.jamie.domain.tag.model.entity.CrowdTagsJobEntity;

/**
 * @description:
 * @author: Jamie
 * @date: 05/12/2025 11:41
 */
public interface ITagRepository {


    public CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId);

    public void addCrowTagsUserId(String tagId, String userId);

    public void updateCrowTagsStatistics(String tagId, int size);
}
