package com.jzweb.httputils.http;

import com.jzweb.httputils.http.DataNameValuePair;
import com.jzweb.httputils.http.HttpConnection;
import com.jzweb.httputils.vo.ApiManage;
import com.jzweb.httputils.vo.ParamVO;

import java.util.List;
import java.util.UUID;

/**
 * @author Ryan
 * @version 1.0
 * @date 1/5/2020
 */
public class HttpUtil {
    //private String compCode;
    public static final String SUCCESS = "0";
    public static final String FAILED = "1";

    private String result;
    private HttpConnection conn;

    public HttpUtil(String compCode) {
        //this.compCode = compCode;
        conn = new HttpConnection().setAuthComp(compCode);
    }

    public HttpUtil(String compCode,String encoding) {
        conn = new HttpConnection().setAuthComp(compCode).setEncodeing(encoding);
    }

    public boolean post(String url, String clazz, String method, ApiManage api, List<ParamVO> params) throws Exception {
        DataNameValuePair pair = new DataNameValuePair();
        for(ParamVO param : params) {
            pair.setParam(param.getKey(), param.getObj());
        }
        //pair.setParam(Constant.ErpStructParam.REMOTE_STATUS_KEY, Constant.ErpStructParam.REMOTE_STATUS_VALUE);
        pair.setSalt(api.getSalt());
        pair.setReqTime(System.currentTimeMillis());
        pair.setAuthKey(UUID.randomUUID().toString().split("-")[0]);//干扰用
        pair.setParam("method", method);
        pair.setParam("clazz", clazz);
        conn.post(url, pair);
        result = conn.getResult();
        return conn.isSuccess();
    }

    public boolean post(String url, DataNameValuePair pair) throws Exception {
        conn.post(url, pair);
        result = conn.getResult();
        return conn.isSuccess();
    }

    public String getResult() {
        return result;
    }

//    /**
//     * 数据输出
//     * @param args
//     */
//	public static void main(String[] args) {
//		DataNameValuePair pair = new DataNameValuePair();
//		pair.setAuthKey("123456").setSalt("1qaz").setReqTime(System.currentTimeMillis());
//    	pair.setParam("name", "Tom").setParam("age", "15").setParam("address", "hfksajdhfkshfk:=;''asdf奥斯卡大撒");
//		HttpUtil httpUtil = new HttpUtil("ejianlong");
//		try {
//			boolean rtn = httpUtil.post("http://127.0.0.1/erp/mp/mpServlet", "com.icsc.mp.atest.mpjcTest","test", pair);
//			if(!rtn) {
//				System.out.println(httpUtil.getResult());
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
