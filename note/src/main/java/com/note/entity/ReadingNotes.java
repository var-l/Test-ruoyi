package com.note.entity;/*
 *@description
 *@author liuyang
 *@create 2024/4/27 11:34
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("reading_notes")
public class ReadingNotes extends BaseEntity{

    @TableId(type = IdType.AUTO)
    @TableField("id")
    private int id;

    @TableField("content")
    private String content;

    @TableField("deleted_time")
    private Date deletedTime;

    @TableField("deleted_at")
    private String  deletedAt;

    @TableField("role_id")
    private int  roleId;

    @TableField("created_at")
    private String  createdAt;

    @TableField("created_time")
    private Date createdTime;

    @TableField("updated_time")
    private Date updatedTime;

    @TableField("updated_at")
    private String updatedAt;

    @Override
    public String toString() {
        return "ReadingNotes{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", deletedTime=" + deletedTime +
                ", deletedAt='" + deletedAt + '\'' +
                ", roleId=" + roleId +
                ", createdAt='" + createdAt + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Date deletedTime) {
        this.deletedTime = deletedTime;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
