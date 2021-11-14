package com.example.taskkillerapi.controllers;

import com.example.taskkillerapi.entities.Llist;
import com.example.taskkillerapi.services.LlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/lists")
public class LlistController {

    @Autowired
    LlistService llistService;

    @GetMapping()  //http://localhost:8081/api/lists/
    public ArrayList<Llist> getUsers(){
        return llistService.getLlists();
    }

    @GetMapping("/{id}")
    public Optional<Llist> getUsersById(@PathVariable("id") Long id){
        return llistService.findById(id);
    }

    @PostMapping
    public Llist saveLlist(@RequestBody Llist llist){
        return this.llistService.saveLlist(llist);
    }

    @PutMapping("/{id}")
    public Llist updateLlist(@RequestBody Llist newLlist, @PathVariable Long id){
        return this.llistService.updateName(newLlist, id);
    }

   // @PutMapping("/addTask/{id}")
   // public Llist addTaskToList(@RequestBody Llist newLlist, @PathVariable Long id, Long task_id){
   //     return this.llistService.updateName(newLlist, id);
  //  }



    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean result=this.llistService.deleteLlist(id);
        if (result){
            return "Se elimino la lista";
        }else {
            return "No se pudo eliminar la lista";
        }
    }

    @RequestMapping("/prueba")
    @ResponseBody
    public ResponseEntity<String> function(){
        return new ResponseEntity("Hola desde el Llist controller", HttpStatus.OK);
    }


}
