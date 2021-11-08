package com.example.demo.case_use;

import com.example.demo.entity.Sheet;
import com.example.demo.service.SheetService;
import org.springframework.stereotype.Component;


@Component
public class CreateSheet {
    private SheetService sheetService;

    public CreateSheet(SheetService sheetService){
        this.sheetService=sheetService;
    }


    public Object save(Sheet newSheet) {
        return sheetService.save(newSheet);
    }
}
