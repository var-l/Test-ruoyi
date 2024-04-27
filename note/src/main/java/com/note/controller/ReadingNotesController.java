package com.note.controller;/*
 *@description
 *@author liuyang
 *@create 2024/4/27 11:18
 */

import com.note.entity.ReadingNotes;
import com.note.service.ReadingNotesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/note/books")
public class ReadingNotesController extends BaseController {

    @Autowired
    private ReadingNotesService readingNotesService;
    @GetMapping("/getList")
    public List<ReadingNotes> getList(){
        System.out.println("你好");
       List<ReadingNotes> list = readingNotesService.selectList();
        return list;
    }

    @PostMapping("/create")
    public AjaxResult create(@Validated @RequestBody ReadingNotes readingNotes){
        return toAjax(readingNotesService.createReadingNotes(readingNotes));
    }
}
