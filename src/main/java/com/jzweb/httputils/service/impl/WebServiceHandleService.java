package com.jzweb.httputils.service.impl;

import com.jzweb.httputils.service.ActualHandleService;
import com.jzweb.httputils.service.HttpHandleService;
import com.jzweb.httputils.vo.ApiManage;
import com.jzweb.httputils.vo.ParamVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ryan
 * @version 1.0
 * @date 12/23/2019
 */
@Service("webservice")
public class WebServiceHandleService extends BaseHandleService implements ActualHandleService {

    @Override
    public Object handle(String company, ApiManage api, List<ParamVO> params) throws RuntimeException {
        return null;
    }

    @Override
    public Object getFromCache(String company, ApiManage api, List<ParamVO> params) throws RuntimeException {
        return null;
    }
}
