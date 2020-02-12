package com.jzweb.httputils.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jzweb.httputils.service.ActualHandleService;
import com.jzweb.httputils.vo.ApiManage;
import com.jzweb.httputils.vo.ParamVO;
import org.apache.axis.client.Call;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

/**
 * webservice
 * @author Ryan
 * @version 1.0
 * @date 12/23/2019
 */
@Service("WebServiceApi")
public class WebServiceHandleService extends BaseHandleService implements ActualHandleService {

    protected static Logger logger = LoggerFactory.getLogger(WebServiceHandleService.class);

    @Override
    public Object handle(String company, ApiManage api, List<ParamVO> params) throws RuntimeException {
        try {
            JSONArray jsonData = new JSONArray();
            JSONObject json = new JSONObject();
            for (ParamVO param : params) {
                json.put(param.getKey(), param.getObj());
            }
            jsonData.add(json);

            String result = send(api, jsonData.toString());
            return result;
        } catch (Exception e) {
            logger.error(api.getRemoteUrl() + " webservice通信失败！", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 调用webservice接口，指定返回String，第一个参数名为arg0
     * @param api
     * @param data
     * @return
     * @throws RemoteException
     * @throws ServiceException
     * @throws MalformedURLException
     */
    private String send(ApiManage api, String data) throws RemoteException, MalformedURLException, ServiceException {
        org.apache.axis.client.Service service = new org.apache.axis.client.Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(api.getRemoteUrl()));
        call.setOperationName(new QName(api.getClazz(), api.getMethods()));
        call.addParameter("arg0", XMLType.XSD_STRING, ParameterMode.IN);
        call.setReturnType(XMLType.XSD_STRING);// 设置调用方法的返回值类型
        return (String) call.invoke(new String[] { data });
    }

    @Override
    public Object getFromCache(String company, ApiManage api, List<ParamVO> params) throws RuntimeException {
        return this.handle(company,api,params);
    }
}
