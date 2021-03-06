package com.mcl.controller.wechat;

/**
 * Created by yz on 2018/2/7.
 */

import com.mcl.common.ServerResponse;
import com.mcl.util.PropertiesUtil;

import com.mcl.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * 用于获取openid
 */
@RestController
@RequestMapping(value = "/weapp/")
public class WeAppController {

    @Autowired
    private RedisUtil redisUtil;

    //请求地址
    private static final String TargetURL = PropertiesUtil.getProperty("weapp.url");

    private static final String APPID = PropertiesUtil.getProperty("weapp.appid");

    private static final String SECRET = PropertiesUtil.getProperty("weapp.secret");

    private static final String GRANT_TYPE = PropertiesUtil.getProperty("weapp.granttype");



    @RequestMapping(value = "openid.do",method = RequestMethod.GET)
    public ServerResponse getOpenId(String jscode) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();

        String url = TargetURL + "?" + "grant_type="+GRANT_TYPE+"&appid="+APPID+"&secret="+SECRET+"&js_code="+jscode;

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse res = client.execute(httpGet);

        // 4.处理请求结果
        String tmp = null;
        String content = "";
        if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            //打印输出
            InputStream inputStream = res.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while((tmp=reader.readLine())!=null){
                if(org.apache.commons.lang3.StringUtils.isNotBlank(tmp))
                    content += tmp;
            }
            System.out.println(content);
        }
        if(StringUtils.isNotBlank(content))
            return ServerResponse.createBySuccess(content);

        return ServerResponse.createByErrorMessage("没有返回");
    }

    /**
     * 收集formid
     * @param openid
     * @param formid
     * @return
     */
    @RequestMapping(value = "collectformid.do",method = RequestMethod.POST)
    public ServerResponse getOpenId(String openid,String formid){
        if(StringUtils.isBlank(openid)||StringUtils.isBlank(formid))
            return ServerResponse.createByErrorMessage("参数为空");

        redisUtil.setFormId(openid,formid);

        return ServerResponse.createBySuccess("收集成功");
    }

    /**
     * 获取formid
     * @param openid
     * @return
     */
    @RequestMapping(value = "checkuserformid.do",method = RequestMethod.POST)
    public ServerResponse checkUserFormid(String openid){
        if(StringUtils.isBlank(openid))
            return ServerResponse.createByErrorMessage("参数为空");

        return ServerResponse.createBySuccess(redisUtil.getAllFormId(openid));
    }
}
