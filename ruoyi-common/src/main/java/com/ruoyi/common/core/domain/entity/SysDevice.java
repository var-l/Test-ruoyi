package com.ruoyi.common.core.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

/**
 * 设备信息表
 */
@EqualsAndHashCode(callSuper = true)
@TableName("device")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysDevice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(type = AUTO)
    @TableField("id")
    private int Id;

    @TableField("device_sn")
    private String deviceSn;

    @TableField("device_name")
    private String deviceName;

    @TableField("location")
    private String location;

    @TableField("status")
    private int status=0;

    @TableField("remark")
    private String remark;
    @TableField("delete_at")
    private Date deleteAt;

}
