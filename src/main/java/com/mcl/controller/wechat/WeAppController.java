package com.mcl.controller.wechat;

/**
 * Created by yz on 2018/2/7.
 */

import ch.qos.logback.classic.gaffer.PropertyUtil;
import com.mcl.common.ServerResponse;
import com.mcl.util.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用于获取openid
 */
@RestController
@RequestMapping(value = "/weapp/")
public class WeAppController {

    //请求地址
    private static final String TargetURL = PropertiesUtil.getProperty("weapp.url");

    private static final String APPID = PropertiesUtil.getProperty("weapp.appid");

    private static final String SECRET = PropertiesUtil.getProperty("weapp.secret");

    private static final String GRANT_TYPE = PropertiesUtil.getProperty("weapp.granttype");


    @RequestMapping(value = "openid.do",method = RequestMethod.POST)
    public ServerResponse getOpenId(String jscode) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(TargetURL);

        //装填参数
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("grant_type", GRANT_TYPE));
        nvps.add(new BasicNameValuePair("appid", APPID));
        nvps.add(new BasicNameValuePair("secret", SECRET));
        nvps.add(new BasicNameValuePair("js_code", jscode));

        CloseableHttpResponse res = client.execute(httpPost);
        // 4.处理请求结果
        String tmp = null;
        String content = "";
        if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            //打印输出
            InputStream inputStream = res.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while((tmp=reader.readLine())!=null){
                if(org.apache.commons.lang3.StringUtils.isNotBlank(tmp))
                    content += tmp+"\r\n";
            }
            System.out.println(content);
        }
        if(StringUtils.isNotBlank(content))
            return ServerResponse.createBySuccess(content);

        return ServerResponse.createByErrorMessage("没有返回");
    }
}
