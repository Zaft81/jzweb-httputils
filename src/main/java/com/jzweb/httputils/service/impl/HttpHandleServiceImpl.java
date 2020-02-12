package com.jzweb.httputils.service.impl;

import com.jzweb.httputils.config.ApiConfig;
import com.jzweb.httputils.service.ActualHandleService;
import com.jzweb.httputils.service.HttpHandleService;
import com.jzweb.httputils.vo.ParamVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Ryan
 * @version 1.0
 * @date 12/23/2019
 */
@Service
public class HttpHandleServiceImpl implements HttpHandleService {

    @Autowired
    private Map<String, ActualHandleService> actualHandleServices;
    @Autowired
    private ApiConfig apiConfig;

    @Override
    public Object handle(String compNo, String code, List<ParamVO> params) throws RuntimeException{
        if(StringUtils.isBlank(code)){
            throw new RuntimeException(code + " :: 接口未设置");
        }


        return actualHandleServices.get(code).handle(compNo,null,params);
    }
}
