package com.mcl.util;

import com.google.gson.Gson;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
//import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2018/2/8 0008.
 */
public class AccessTokenUtil {

    public Logger logger = LoggerFactory.getLogger(AccessTokenUtil.class);

    private static final String TokenURL = PropertiesUtil.getProperty("weapp.tokenurl");

    private static final String Type = PropertiesUtil.getProperty("weapp.token_granttype");

    private static final String APPID = PropertiesUtil.getProperty("weapp.appid");

    private static final String SECRET = PropertiesUtil.getProperty("weapp.secret");

    public String getAccessToken(){

        String url = TokenURL + "?grant_type=" + Type + "&appid=" + APPID +"&secret=" + SECRET ;

        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse res = null ;

        try {
            res = client.execute(httpGet);
        } catch (IOException e) {
            logger.info("获取token失败...");
            return null ;
        }

        if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String result = null;// 返回json格式：
            try {
                result = EntityUtils.toString(res.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }
            TokenResult tokenResult = new Gson().fromJson(result,TokenResult.class);
            return tokenResult.getAccess_token();
        }
        return null;
    }

    class TokenResult{
        private String access_token ;
        private Integer expires_in ;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public Integer getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(Integer expires_in) {
            this.expires_in = expires_in;
        }
    }


}
