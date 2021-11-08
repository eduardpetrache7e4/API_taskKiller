package com.example.demo.case_use;

import com.example.demo.entity.Sheet;
import com.example.demo.entity.Task;
import com.example.demo.service.SheetService;

public class UpdateSheet {
    private SheetService sheetService;

    public UpdateSheet(SheetService sheetService) {
        this.sheetService = sheetService;
    }

    public Sheet update(Sheet newSheet, Long id) {
        return sheetService.update(newSheet,id);
    }

}
