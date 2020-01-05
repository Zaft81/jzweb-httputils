package com.jzweb.httputils.vo;

/**
 * @author Ryan
 * @version 1.0
 * @date 12/21/2019
 */
public class ApiManage {
    private String remoteUrl;
    private String clazz;
    private String methods;
    private Boolean cache;
    private Boolean state;
    private String salt;

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
