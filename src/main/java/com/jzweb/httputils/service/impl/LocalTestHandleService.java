package com.jzweb.httputils.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jzweb.httputils.service.ActualHandleService;
import com.jzweb.httputils.vo.ApiManage;
import com.jzweb.httputils.vo.ParamVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ryan
 * @version 1.0
 * @date 2/12/2020
 */
@Service("LocalTestApi")
public class LocalTestHandleService extends BaseHandleService implements ActualHandleService {

    @Override
    public Object handle(String company, ApiManage api, List<ParamVO> params) throws RuntimeException {
        JSONObject object = new JSONObject();
        return object.toString();
    }

    @Override
    public Object getFromCache(String company, ApiManage api, List<ParamVO> params) throws RuntimeException {
        return this.handle(company, api, params);
    }
}
