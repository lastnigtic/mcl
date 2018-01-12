package com.mcl.controller.wechat;

import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.JobOffers;
import com.mcl.service.IOffersService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IOffersService iOffersService ;


    /**
     * 获取招聘信息列表
     * @param pageNum
     * @param pageSize
     * @param jobOffers
     * @param keywords
     * @return
     */
    @RequestMapping(value = "list.do" ,method = RequestMethod.POST)
    public ServerResponse<PageInfo> getOfferList(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                 @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                                 JobOffers jobOffers,@RequestParam(value = "keywords",required = false) String keywords){
        return iOffersService.getOfferList(pageNum,pageSize,jobOffers,keywords);
    }


    /**
     * 获取推荐招聘信息列表(按工资高的在前)
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "recommendlist.do" ,method = RequestMethod.POST)
    public ServerResponse<PageInfo> recommendList(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                 @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return iOffersService.recommendList(pageNum,pageSize);
    }

    /**
     * 查看具体的招聘信息
     * @param id
     * @return
     */
    @RequestMapping(value = "detail.do" ,method = RequestMethod.POST)
    public ServerResponse getOfferDetail(Integer id){
        return iOffersService.getOfferDetail(id);
    }



}
