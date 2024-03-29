package com.jzweb.httputils.http;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Ryan
 * @version 1.0
 * @date 1/5/2020
 */
public class HttpConnection {
    private String authComp = null;
    private String result;
    private boolean rtn = false;
    private String encodeing = null;
    public HttpConnection() {}
    public HttpConnection(String authComp) {
        this.authComp = authComp;
    }

    public HttpConnection setAuthComp(String authComp) {
        this.authComp = authComp;
        return this;
    }

    public String getEncodeing() {
        if(this.encodeing == null || this.encodeing.length()==0) {
            return Constant.ENCODING;
        } else {
            return this.encodeing;
        }
    }
    public HttpConnection setEncodeing(String encodeing) {
        this.encodeing = encodeing;
        return this;
    }
    public String getResult() {
        return result;
    }
    public boolean isSuccess() {
        return rtn;
    }


    /**
     *
     * @param path
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public HttpConnection post(String path, DataNameValuePair param) throws Exception{
        param.sign(getEncodeing());
        HttpURLConnection conn = null;
        ObjectInputStream ois = null;
        try {
            URL url = new URL(path);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(Constant.METHOD_POST);
            conn.setRequestProperty("ReqTime-Time", param.getReqTime());
            conn.setRequestProperty("auth-comp", authComp);
            //conn.setRequestProperty("Content-length", "" + bs.length);
            //conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //conn.setRequestProperty("Content-type", "application/text;charset=GBK");
            //conn.setRequestProperty("contentType", "GBK");
            conn.setConnectTimeout(120000);
            conn.setReadTimeout(120000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);



            PrintWriter out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),getEncodeing()));
            out.println(param.getParamStr());
            out.close();

            conn.getOutputStream().flush();
            conn.getOutputStream().close();
            ois = new ObjectInputStream(conn.getInputStream());
            result = (String) ois.readObject();
            rtn = true;
        }catch(Exception e) {
            //result = e.getMessage();
            try {
                closeConnection(ois, conn);
            } catch (IOException ex) {
                ex.printStackTrace();
                throw ex;
            }
            throw e;
        }
        return this;
    }

    public HttpConnection get(String path, DataNameValuePair param) throws Exception{
        param.sign();
        HttpURLConnection conn = null;
        ObjectInputStream ois = null;
        try {
            URL url = new URL(path);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(Constant.METHOD_GET);
            conn.setRequestProperty("ReqTime-Time", param.getReqTime());
            conn.setRequestProperty("auth-comp", authComp);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.getOutputStream().write(param.getParamStr().getBytes(Constant.ENCODING));
            conn.getOutputStream().flush();
            conn.getOutputStream().close();
            ois = new ObjectInputStream(conn.getInputStream());

            result = (String) ois.readObject();
            rtn = true;
        }catch(Exception e) {
            //result = e.getMessage();
            try {
                closeConnection(ois, conn);
            } catch (IOException ex) {
                ex.printStackTrace();
                throw ex;
            }
            throw e;
        }
        return this;
    }

    private void closeConnection(ObjectInputStream ois,HttpURLConnection conn)throws IOException{
        if (ois != null) {
            ois.close();
        }
        if (conn != null) {
            conn.disconnect();
        }
    }



}
