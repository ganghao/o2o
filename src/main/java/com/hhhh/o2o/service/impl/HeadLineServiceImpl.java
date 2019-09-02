package com.hhhh.o2o.service.impl;

import java.util.List;

import javax.imageio.IIOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhhh.o2o.dao.HeadLineDao;
import com.hhhh.o2o.entity.HeadLine;
import com.hhhh.o2o.service.HeadLineService;

@Service
public class HeadLineServiceImpl implements HeadLineService{
    
    @Autowired
    private HeadLineDao headLineDao;

    @Override
    public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IIOException {
        return headLineDao.queryHeadLine(headLineCondition);
    }

}
