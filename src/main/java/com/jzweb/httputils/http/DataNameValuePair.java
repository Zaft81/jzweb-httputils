package com.jzweb.httputils.http;

import com.alibaba.fastjson.JSONObject;
import com.jzweb.httputils.security.Signature;

import java.net.URLEncoder;
import java.util.UUID;

/**
 * @author Ryan
 * @version 1.0
 * @date 1/5/2020
 */
public class DataNameValuePair {

    private StringBuffer buffer = new StringBuffer();
    private JSONObject json = new JSONObject();
    private String reqTime;

    private String salt = "";
    private String token = "";

    private String authKey;

    public DataNameValuePair setSalt(String salt) {
        this.salt = salt == null ? "" : salt;
        return this;
    }

    public DataNameValuePair setToken(String token) {
        this.token = token == null ? "" : token;
        return this;
    }

    public DataNameValuePair setParam(String key, String value) {
        json.put(key, value);
        return this;
    }

    public DataNameValuePair setParam(String key, Object value) {
        json.put(key, value);
        return this;
    }

    private void putInParam(String key, String value) {
        if (buffer.length() > 0) {
            buffer.append("&");
        }
        buffer.append(key).append("=").append(value);
    }

    public void sign() throws Exception {
        this.signIn(null);
    }

    public void sign(String encodeing) throws Exception {
        this.signIn(encodeing);
    }

    private void signIn(String encodeing) throws Exception {
        String info = json.size() == 0 ? UUID.randomUUID().toString().substring(0, 4) : json.toString();
        String allStr = info + getReqTime() + this.salt + this.token;
        String md5 = Signature.md5(allStr);


        if (encodeing != null && encodeing.length() > 0) {
            putInParam("info", URLEncoder.encode(info, encodeing));
        } else {
            putInParam("info", info);
        }
        putInParam("sign", md5);
        putInParam("authKey", UUID.randomUUID().toString().replaceAll("-", ""));
    }

    public String getParamStr() {
        return buffer.toString();
    }

    public String getReqTime() {
        return reqTime;
    }


    public DataNameValuePair setReqTime(long reqTime) {
        this.reqTime = String.valueOf(reqTime);
        return this;
    }


    public String getAuthKey() {
        return authKey;
    }

    public DataNameValuePair setAuthKey(String authKey) {
        this.authKey = authKey;
        return this;
    }

    public String toString() {
        return json.toString();
    }


}
