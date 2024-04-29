package com.note.mapper;

import com.note.entity.ReadingNotes;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReadingNotesMapper {
    public List<ReadingNotes> selectList(ReadingNotes readingNotes);

    public int createReadingNotes(ReadingNotes data);
}
