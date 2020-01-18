package com.jzweb.httputils.vo;

import com.jzweb.httputils.http.Constant;

/**
 * @author Ryan
 * @version 1.0
 * @date 12/21/2019
 */
public class ApiManage {
    private String remoteUrl;
    private String clazz;
    private String methods;
    private Boolean cache = Boolean.FALSE;
    private Boolean state = Boolean.TRUE;
    private String salt;
    private String charset = Constant.ENCODING;

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public Boolean getCache() {
        return cache;
    }

    public void setCache(Boolean cache) {
        this.cache = cache;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Override
    public String toString() {
        return "ApiConfig{" +
                "remoteUrl='" + remoteUrl + '\'' +
                ", clazz='" + clazz + '\'' +
                ", methods='" + methods + '\'' +
                ", cache=" + cache +
                ", state=" + state +
                ", salt='" + salt + '\'' +
                '}';
    }
}
