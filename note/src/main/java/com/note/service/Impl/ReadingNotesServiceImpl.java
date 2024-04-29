package com.note.service.Impl;
/*

 *@author liuyang
 *@create 2024/4/27 14:09
 */

import com.note.entity.ReadingNotes;
import com.note.mapper.ReadingNotesMapper;
import com.note.service.ReadingNotesService;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.ruoyi.common.utils.SecurityUtils.getLoginUser;

@Service
public class ReadingNotesServiceImpl implements ReadingNotesService {

    @Autowired
    private ReadingNotesMapper readingNotesMapper;

    @Override
    public List<ReadingNotes> selectList(ReadingNotes readingNotes) {
        System.out.println(readingNotes);
        return readingNotesMapper.selectList(readingNotes);
    }

    @Override
    public int createReadingNotes(ReadingNotes data) {
        System.out.println(data);
        System.out.println("接收的参数"+data);
        data.setCreatedTime(new Date());
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        data.setCreatedAt(String.valueOf(user.getUserId()));
        System.out.println(data);
        int rows = readingNotesMapper.createReadingNotes(data);
        System.out.println("新增状态"+rows);
        return rows;
    }
}
