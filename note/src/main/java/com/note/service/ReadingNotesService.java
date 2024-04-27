package com.note.service;

import com.note.entity.ReadingNotes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReadingNotesService {
    /**
     * 查询所有
     *
     * @return ReadingNotesList
     */
   public List<ReadingNotes> selectList();

   public int createReadingNotes(ReadingNotes data);
}
