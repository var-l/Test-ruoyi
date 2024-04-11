package com.ruoyi.system.service.impl;/*
 *@description
 *@author liuyang
 *@create 2024/4/10 16:31
 */

import com.ruoyi.common.core.domain.entity.SysDevice;
import com.ruoyi.system.mapper.SysDeviceMapper;
import com.ruoyi.system.service.ISysDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDeviceServiceImpl implements ISysDeviceService {
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private SysDeviceMapper sysDeviceMapper;
    @Override
    public List<SysDevice> selectDeviceList(SysDevice sysDevice) {
        return sysDeviceMapper.selectDeviceList(sysDevice);
    }
}
