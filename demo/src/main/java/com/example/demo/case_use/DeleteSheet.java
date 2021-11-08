package com.example.demo.case_use;


import com.example.demo.service.SheetService;

public class DeleteSheet {

    private SheetService sheetService;

    public DeleteSheet(SheetService sheetService){
        this.sheetService=sheetService;
    }


    public void remove(Long id) {
        sheetService.delete(id);
    }

}
