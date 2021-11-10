package com.example.demo.case_use;

import com.example.demo.entity.Sheet;
import com.example.demo.service.SheetService;

import java.util.List;

public class GetSheetImplement implements GetSheet {

    private SheetService sheetService;

    public GetSheetImplement(SheetService sheetService) {
        this.sheetService = sheetService;
    }


    @Override
    public List<Sheet> getAll() {return sheetService.getAllSheets();}
}
