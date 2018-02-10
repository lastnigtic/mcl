package com.mcl.util;

import com.google.gson.Gson;
import com.mcl.pojo.InterviewMessage;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2018/2/8 0008.
 */
@Component
public class WeChatMessageSender {

    private static final String InterviewTemplateID = PropertiesUtil.getProperty("weapp.interviewtemplateid");

    private static final String TemplateURL = PropertiesUtil.getProperty("weapp.templateurl");

    Logger logger = LoggerFactory.getLogger(WeChatMessageSender.class);

    //TODO 发送消息模版
    public void sendInterviewMsg(String jobname,String companyname,String openid,String formid,String msg){

        //获取邀约面试实体
        InterviewMessage interviewMessage = new InterviewMessage(openid,InterviewTemplateID,formid,jobname,companyname,msg);

        //构建json
        JSONObject json =interviewMessage.getMessageJson();

        System.out.println(json);

        String token = new AccessTokenUtil().getAccessToken();

        logger.info("token:"+token);

        PrintWriter out = null;

        BufferedReader in = null;

        StringBuilder sb = null ;

        String urlstr = null ;

        try {
            urlstr = TemplateURL + "?access_token="+ token ;

            URL url = new URL(urlstr);

            URLConnection conn = url.openConnection();

            conn.setRequestProperty("accept","*/*");

            conn.setRequestProperty("connection","Keep-Alive");

            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            conn.setDoOutput(true);

            conn.setDoInput(true);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");

            out = new PrintWriter(outputStreamWriter);

            out.print(json.toString());

            out.flush();

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";

            sb = new StringBuilder();

            while ((line = in.readLine())!=null){
                sb.append(line);
            }

        } catch (UnsupportedEncodingException e) {

            logger.error("不支持的编码错误:openid:{},formid:{},jobname:{},companyname:{},msg:{}", openid,formid,jobname,companyname,msg);

        } catch (MalformedURLException e) {

            logger.error("URL错误:openid:{},formid:{},jobname:{},companyname:{},msg:{}", openid,formid,jobname,companyname,msg);

        } catch (IOException e) {

            logger.error("读写错误:openid:{},formid:{},jobname:{},companyname:{},msg:{}", openid,formid,jobname,companyname,msg);

        } finally {

            logger.info("url:{},openid:{},formid:{},jobname:{},companyname:{},msg:{}", urlstr,openid,formid,jobname,companyname,msg);

            logger.info("返回："+sb.toString());

            Result result = new Gson().fromJson(sb.toString(),Result.class);

            if(result.getErrcode()==0)
                logger.info("发送成功：url:{},openid:{},formid:{},jobname:{},companyname:{},msg:{}", urlstr,openid,formid,jobname,companyname,msg);
            else
                logger.info("发送错误：错误代码：{}，错误信息：{}，url:{},openid:{},formid:{},jobname:{},companyname:{},msg:{}",result.getErrcode(),result.getErrmsg(), urlstr,openid,formid,jobname,companyname,msg);

            if(out!=null)
                out.close();

            if(in!=null)
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("关闭流错误");
                }
        }
    }




    public static void main(String[] args) {



//        WeChatMessageSender sender = new WeChatMessageSender();
//
//        String jobname = "JavaScript开发岗位";
//
//        String companyname = "美团网";
//
//        String formid = "1518233294796";
//
////        String openid = "o4THs0CvTBQY5RhZba7dPxygwXig";
//
//        String openid = "o4THs0Hu3H_e-ZMfVzEGf85VefK8";
//
//
//        String msg = "请于2018年2月27号带上身份证复印件到美团总部办理入职手续，联系人电话：15521195093";
//
//        sender.sendInterviewMsg(jobname,companyname,openid,formid,msg);

//            System.out.print(new AccessTokenUtil().getAccessToken());
    }

    class Result{

        private Integer errcode;

        private String errmsg ;

        public Integer getErrcode() {
            return errcode;
        }

        public void setErrcode(Integer errcode) {
            this.errcode = errcode;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }
    }
}
