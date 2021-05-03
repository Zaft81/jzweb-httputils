package com.jzweb.httputils.service.impl;

import com.jzweb.httputils.http.HttpUtil;
import com.jzweb.httputils.service.ActualHandleService;
import com.jzweb.httputils.vo.ApiManage;
import com.jzweb.httputils.vo.ParamVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * servlet
 * @author Ryan
 * @version 1.0
 * @date 12/23/2019
 */
@Service("ServletApi")
public class ServletHandleService extends BaseHandleService implements ActualHandleService {

    protected static Logger logger = LoggerFactory.getLogger(ServletHandleService.class);

    @Override
    public Object handle(String company, ApiManage api, List<ParamVO> params) throws RuntimeException {
        if(!StringUtils.isBlank(api.getClazz()) && !StringUtils.isBlank(api.getMethods())) {
            HttpUtil httpUtil = new HttpUtil(company,getCharset(api));
            try {
                boolean rtn = httpUtil.post(api.getRemoteUrl(), api.getClazz(),api.getMethods(), api,params);
                String result = httpUtil.getResult();
                logger.info("throw finished！company: {}  apiCode: {}  return info: {}", company, api.getRemoteUrl(), result);
                if(rtn) {
                    return result;
                } else {
                    throw new Exception(result);
                }

            } catch (Exception e) {
                logger.error("通信异常！company: {}  apiCode: {} ex: {} ", company, api.getRemoteUrl(), e.getMessage());
                logger.error("通信失败！", e);
                throw new RuntimeException(e);
            }
        } else {
            logger.info(api.getRemoteUrl()+" 接口未设置");
            throw new RuntimeException(api.getRemoteUrl()+" 接口未设置");
        }
    }

    @Override
    public Object getFromCache(String company, ApiManage api, List<ParamVO> params) throws RuntimeException {
        return this.handle(company,api,params);
    }
}
