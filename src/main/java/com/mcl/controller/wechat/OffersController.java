package com.mcl.controller.wechat;

import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@RestController
@RequestMapping(value = "/offers/")
public class OffersController {

    /**
     * 获取招聘信息列表
     * @param openid
     * @param pageNum
     * @param pageSize
     * @param city
     * @return
     */
    @RequestMapping(value = "list.do" ,method = RequestMethod.POST)
    public ServerResponse<PageInfo> getOfferList( @RequestParam(value="openid")String openid,
                                                  @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,@RequestParam(value = "city",defaultValue = "北京") String city){
        return null;
    }

    /**
     * 查看具体的招聘信息
     * @param joid
     * @return
     */
    @RequestMapping(value = "detail.do" ,method = RequestMethod.POST)
    public ServerResponse getOfferDetail(int joid){
        //这里记得还要返回多一个公司的id
        return null;
    }

}
