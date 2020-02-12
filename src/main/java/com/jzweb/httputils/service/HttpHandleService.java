package com.jzweb.httputils.service;

import com.jzweb.httputils.vo.ParamVO;

import java.util.List;

public interface HttpHandleService {
    Object handle(String compNo, String code, List<ParamVO> params)throws RuntimeException;
}
