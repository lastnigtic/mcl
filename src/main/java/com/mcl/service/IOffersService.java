package com.mcl.service;

import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
public interface IOffersService {
    ServerResponse<PageInfo> getOfferList(int pageNum, int pageSize, String city);

    ServerResponse getOfferDetail(Integer joid);
}
