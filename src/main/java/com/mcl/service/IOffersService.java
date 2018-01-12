package com.mcl.service;

import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.JobOffers;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
public interface IOffersService {
    ServerResponse<PageInfo> getOfferList(int pageNum, int pageSize, JobOffers jobOffers, String keywords);

    ServerResponse getOfferDetail(Integer joid);

    ServerResponse<PageInfo> recommendList(int pageNum, int pageSize);
}
