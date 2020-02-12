package com.jzweb.httputils.vo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jzweb.httputils.http.HttpUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Ryan
 * @version 1.0
 * @date 1/5/2020
 */
public class HttpDataHandle {
    private boolean result = false;
    private String msg = "";
    private static String json_code_key = "code";

    private String data;
    private JSONObject jsonData;


    public HttpDataHandle(String data)throws Exception {
        this.data = data;
        init();
    }

    private void init() {
        jsonData = JSONObject.parseObject(data);
        if(HttpUtil.SUCCESS.equals(jsonData.getString(json_code_key))) {
            result = true;
        } else {
            result = false;
        }
        msg = jsonData.getString("msg");
    }

    public boolean getResult() {
        return this.result;
    }

    public String getMsg() {
        return msg;
    }

    public JSONArray getArrayData(String key)throws Exception {
        if(StringUtils.isBlank(key)) {
            return null;
        }
        if(data == null) {
            return null;
        }

        JSONArray array = null;
//		if(HttpUtil.SUCCESS.equals(jsonData.getString(json_code_key))) {
//			array = jsonData.getJSONArray(key);
//			result = true;
//		}  else {
//			result = false;
//		}
        if(result && jsonData.containsKey(key)) {
            array = jsonData.getJSONArray(key);
        }  else {
        }
        return array;
    }

    public JSONObject getObjectData(String key)throws Exception {
        if(StringUtils.isBlank(key)) {
            return new JSONObject();
        }
        if(data == null) {
            return new JSONObject();
        }
        JSONObject json = new JSONObject();
//		if(HttpUtil.SUCCESS.equals(jsonData.getString(json_code_key))) {
//			json = jsonData.getJSONObject(key);
//			result = true;
//		}  else {
//			result = false;
//		}
        if(result) {
            json = jsonData.getJSONObject(key);
        }  else {
        }
        return json;
    }

    public JSONObject getReturnData() {
        return jsonData;
    }

    public String getStringData(String key) {
        if(StringUtils.isBlank(key)) {
            return null;
        }
        if(data == null) {
            return null;
        }

        return jsonData.getString(key);

    }
}
