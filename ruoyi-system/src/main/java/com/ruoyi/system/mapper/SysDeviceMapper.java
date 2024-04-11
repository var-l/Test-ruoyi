package com.ruoyi.system.mapper;/*
 *@description
 *@author liuyang
 *@create 2024/4/10 16:21
 */
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDevice;

public interface SysDeviceMapper {
    /**
     * 条件查询设备信息
     * @param sysDevice 设备信息
     * @return 设备信息集合
     */
    public List<SysDevice> selectDeviceList(SysDevice sysDevice);
}
