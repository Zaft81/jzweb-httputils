package com.jzweb.httputils.service;

import com.jzweb.httputils.vo.ApiManage;
import com.jzweb.httputils.vo.ParamVO;

import java.util.List;

public interface ActualHandleService {
    /**
     * 实际通讯
     *
     * @param company 公司编号
     * @param api 接口设定
     * @param params 参数
     * @return
     * @throws RuntimeException
     */
    Object handle(String company, ApiManage api, List<ParamVO> params) throws RuntimeException;

    /**
     * 优先从缓存，若缓存不存在，则再通过远程
     *
     * @param company 公司编号
     * @param api 接口设定
     * @param params 参数
     * @return
     * @throws RuntimeException
     */
    Object getFromCache(String company, ApiManage api, List<ParamVO> params) throws RuntimeException;
}
