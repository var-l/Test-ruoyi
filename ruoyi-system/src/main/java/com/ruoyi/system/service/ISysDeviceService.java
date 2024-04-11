package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.entity.SysDevice;
import com.ruoyi.common.core.domain.entity.SysUser;

import java.util.List;

public interface ISysDeviceService {
    /**
     * 查询设备信息
     * @param sysDevice
     * @return
     */
    public List<SysDevice> selectDeviceList(SysDevice sysDevice);
}
