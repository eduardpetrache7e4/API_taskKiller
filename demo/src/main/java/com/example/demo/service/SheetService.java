package com.example.demo.service;

import com.example.demo.entity.Sheet;
import com.example.demo.repository.SheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SheetService {

    private SheetRepository sheetRepository;

    public SheetService(SheetRepository sheetRepository) { //inyectamos el repositorio
        this.sheetRepository = sheetRepository;
    }

    public List<Sheet> getAllSheets(){
        return sheetRepository.findAll();
    }

    public Sheet save(Sheet newSheet) {
        return sheetRepository.save(newSheet);
    }

    public void delete(Long id) {
        sheetRepository.deleteById(id);
    }

    public Sheet update(Sheet newSheet, Long id) {
        return
                sheetRepository.findById(id)
                        .map(
                                sheet->{
                                    sheet.setName(newSheet.getName());
                                    return sheetRepository.save(sheet);
                                }
                        ).get();

    }
}
