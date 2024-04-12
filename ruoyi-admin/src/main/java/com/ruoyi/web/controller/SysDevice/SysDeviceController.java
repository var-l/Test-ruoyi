package com.ruoyi.web.controller.SysDevice;/*
 *@description
 *@author liuyang
 *@create 2024/4/10 16:35
 */

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDevice;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.service.ISysDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.ruoyi.common.utils.PageUtils.startPage;


@RestController
@RequestMapping("/Device")
public class SysDeviceController extends BaseController {

    @Autowired
    private ISysDeviceService sysDeviceService;

    /**
     * 获取用户列表
     */
//    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDevice sysDevice)
    {
        startPage();
        List<SysDevice> sysDeviceList = sysDeviceService.selectDeviceList(sysDevice);
        return getDataTable(sysDeviceList);
    }
    @PostMapping("/addDevice")
    public AjaxResult addDevice(@Validated @RequestBody SysDevice device){
        System.out.println(device);
        return toAjax( sysDeviceService.addDevice(device));
    }
}
