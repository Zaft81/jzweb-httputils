package com.jzweb.httputils.service;

import com.jzweb.httputils.vo.ApiManage;
import com.jzweb.httputils.vo.ParamVO;

import java.util.List;

public interface ActualHandleService {
    /**
     * 传输数据
     *
     * @param company
     * @param api
     * @param params
     * @return
     * @throws RuntimeException
     */
    Object handle(String company, ApiManage api, List<ParamVO> params) throws RuntimeException;

    /**
     * 缓存
     *
     * @param company
     * @param api
     * @param params
     * @return
     * @throws RuntimeException
     */
    Object getFromCache(String company, ApiManage api, List<ParamVO> params) throws RuntimeException;
}
