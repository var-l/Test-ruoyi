package com.note.controller;/*
 *@description
 *@author liuyang
 *@create 2024/4/27 11:18
 */

import com.note.entity.ReadingNotes;
import com.note.service.ReadingNotesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/note/books")
public class ReadingNotesController extends BaseController {

    @Autowired
    private ReadingNotesService readingNotesService;
    @GetMapping("/getList")
    public TableDataInfo getList(ReadingNotes readingNotes ){
        logger.info("getList");
        logger.info(String.valueOf(readingNotes));
        startPage();
       List<ReadingNotes> list = readingNotesService.selectList(readingNotes);
       return getDataTable(list);
    }

    @PostMapping("/create")
    public AjaxResult create(@Validated @RequestBody ReadingNotes readingNotes){
        return toAjax(readingNotesService.createReadingNotes(readingNotes));
    }
}
