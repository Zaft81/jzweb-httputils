package com.jzweb.httputils.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan
 * @version 1.0
 * @date 12/21/2019
 */
public class ParamVO {


    private String key;
    private Object obj;

    public ParamVO(String key, Object obj) {
        this.key = key;
        this.obj = obj;
    }

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }


    public static List<ParamVO> getParams(Map<String, Object> map){
        List<ParamVO> params = new ArrayList<>();
        if(map != null) {
            for (Map.Entry<String, Object> entry :map.entrySet()) {
//                if(KeyWordUtil.filter.containsKey(entry.getKey())) {
//                    continue;
//                }
                params.add(new ParamVO(entry.getKey(), entry.getValue()));
            }
        }
        return params;
    }

}
