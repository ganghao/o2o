package com.hhhh.o2o.service;

import java.util.List;

import javax.imageio.IIOException;

import com.hhhh.o2o.entity.HeadLine;

public interface HeadLineService {

    /**
     * 根据传入的条件返回指定的头条列表
     * 
     * @param headLineCondition
     * @return
     * @throws IIOException
     */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IIOException;
}
