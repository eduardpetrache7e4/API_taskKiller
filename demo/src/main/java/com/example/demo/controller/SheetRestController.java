package com.example.demo.controller;

import com.example.demo.case_use.CreateSheet;
import com.example.demo.case_use.DeleteSheet;
import com.example.demo.case_use.GetSheet;
import com.example.demo.case_use.UpdateSheet;
import com.example.demo.entity.Sheet;
import com.example.demo.repository.SheetRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sheet")
public class SheetRestController {
    private CreateSheet createSheet;
    private GetSheet getSheet;
    private UpdateSheet updateSheet;
    private DeleteSheet deleteSheet;
    private SheetRepository sheetRepository;


    public SheetRestController(CreateSheet createSheet,
                               GetSheet getSheet,
                               UpdateSheet updateSheet,
                               DeleteSheet deleteSheet,
                               SheetRepository sheetRepository) {
        this.createSheet = createSheet;
        this.getSheet = getSheet;
        this.updateSheet = updateSheet;
        this.deleteSheet = deleteSheet;
        this.sheetRepository = sheetRepository;
    }


    @GetMapping("/")
    List<Sheet> get(){
        return getSheet.getAll();
    }

    @PostMapping("/")
    ResponseEntity<Sheet> newSheet(@RequestBody Sheet newSheet){
        return new ResponseEntity(createSheet.save(newSheet), HttpStatus.CREATED);
    }

    @DeleteMapping("({id}")
    ResponseEntity deleteSheet(@PathVariable Long id){
        deleteSheet.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<Sheet>replaceSheet(@RequestBody Sheet newSheet, @PathVariable Long id){
        return new ResponseEntity(updateSheet.update(newSheet,id),HttpStatus.OK);
    }


    @RequestMapping("/prueba")
    @ResponseBody
    public ResponseEntity<String>function(){
        return new ResponseEntity("Hola desde el sheet controller",HttpStatus.OK);
    }

    @GetMapping("/pageable")
    List<Sheet> getSheetPageable(@RequestParam int sheet, @RequestParam int size){ //pageable?page=0&size=2
        return sheetRepository.findAll(PageRequest.of(sheet,size)).getContent();
    }

}

