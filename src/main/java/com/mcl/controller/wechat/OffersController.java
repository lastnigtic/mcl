package com.mcl.controller.wechat;

import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
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
     * @param city
     * @return
     */
    @RequestMapping(value = "list.do" ,method = RequestMethod.GET)
    public ServerResponse<PageInfo> getOfferList( @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                                  @RequestParam(value = "city",required = false) String city){
        return iOffersService.getOfferList(pageNum,pageSize,city);
    }

    /**
     * 查看具体的招聘信息
     * @param joid
     * @return
     */
    @RequestMapping(value = "detail.do" ,method = RequestMethod.POST)
    public ServerResponse getOfferDetail(Integer joid){
        return iOffersService.getOfferDetail(joid);
    }

}
