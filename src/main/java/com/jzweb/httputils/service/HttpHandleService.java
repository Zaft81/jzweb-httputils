package com.jzweb.httputils.service;

import com.jzweb.httputils.vo.ParamVO;

import java.util.List;

public interface HttpHandleService {
    public void handle(String compNo, String code, List<ParamVO> params);
}
