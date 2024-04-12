package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.entity.SysDevice;

import java.util.List;

public interface ISysDeviceService {
    /**
     * 查询设备信息
     * @param sysDevice 设备信息
     * @return 设备信息集合
     */
    public List<SysDevice> selectDeviceList(SysDevice sysDevice);

    public boolean addDevice(SysDevice sysDevice);
}
