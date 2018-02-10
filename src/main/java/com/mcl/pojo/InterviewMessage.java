package com.mcl.pojo;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/9 0009.
 */
public class InterviewMessage {

    private String touser; //接收者的openid

    private String template_id; //所需下发的模版消息的id

    private String form_id; //表单提交场景下返回的formid，缺了就不行

    private String data; //模版内容

    public InterviewMessage(String touser, String template_id, String form_id, String jobname, String companyname, String msg) {
        this.template_id = template_id;
        this.touser = touser;
        this.form_id = form_id;
        this.data = assembleData(jobname, companyname, msg);
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String assembleData(String jobname, String companyname, String msg) {
        return
                "{\"keyword1\": {" +
                        "\"value\": \"" + jobname + "\"" +
                        "},  " +
                        "\"keyword2\": {" +
                        "\"value\": \"" + companyname + "\"" +
                        "},  " +
                        "\"keyword3\": {" +
                        "\"value\": \"" + msg + "\"" +
                        "}}";
    }


    public JSONObject getMessageJson(){
        JSONObject data = new JSONObject(this.getData());
        JSONObject json = new JSONObject();
        json.put("data", data);
        json.put("template_id", this.getTemplate_id());
        json.put("form_id", this.getForm_id());
        json.put("touser", this.getTouser());

        return json;
    }


}
