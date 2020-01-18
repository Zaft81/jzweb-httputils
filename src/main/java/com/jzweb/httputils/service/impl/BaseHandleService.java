package com.jzweb.httputils.service.impl;

import com.jzweb.httputils.http.Constant;
import com.jzweb.httputils.security.MD5;
import com.jzweb.httputils.vo.ApiManage;
import com.jzweb.httputils.vo.ParamVO;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author Ryan
 * @version 1.0
 * @date 12/23/2019
 */
public class BaseHandleService {
    protected static String SPLITCHAR = "-";
    protected static String SIGNKEY = "JZWEB-COMMON-HTTP";

    /**
     * 用url、class、method、以及参数的MD5码做缓存key，防止重复
     * @param api
     * @param params
     * @return
     */
    protected String getCacheKey(ApiManage api, List<ParamVO> params) {
        StringBuilder builder = new StringBuilder();
        builder.append(api.getRemoteUrl()).append(SPLITCHAR).append(api.getClazz()).append(SPLITCHAR).append(api.getMethods());
        for(ParamVO p : params) {
            if(p.getObj() instanceof String) {
                builder.append(p.getObj().toString());
            }
        }

        return MD5.sign(builder.toString(), SIGNKEY, Constant.ENCODING);
    }

    /**
     * 获取字符集编码
     * @param api
     * @return
     */
    protected String getCharset(ApiManage api) {
        if(api == null || StringUtils.isBlank(api.getCharset())) {
            return Constant.DEF_CHARSET;
        } else {
            return api.getCharset();
        }
    }
}
