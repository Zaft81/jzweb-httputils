package com.jzweb.httputils.enums;

/**
 * 接口种类
 */
public enum ApiManageModeEnum implements BaseMappingEnum {
    /**
     * servlet
     */
    ServletApi("ServletApi","Servlet"),
    /**
     * rest方式
     */
    RestApi("RestApi","rest"),
    /**
     * webservice方式
     */
    WebServiceApi("WebServiceApi","WebService"),
    /**
     * 本地模拟测试
     */
    LocalTestApi("LocalTestApi","LocalTest");
    private String code, name;
    private ApiManageModeEnum(String code, String name){
        this.code = code;
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
}
