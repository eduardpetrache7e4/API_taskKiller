package com.example.taskkillerapi.controllers;

import com.example.taskkillerapi.entities.Llist;
import com.example.taskkillerapi.entities.Task;
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

    @CrossOrigin
    @GetMapping()  //http://localhost:8081/api/lists/
    public ArrayList<Llist> getUsers(){
        return llistService.getLlists();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Llist> getUsersById(@PathVariable("id") Long id){
        return llistService.findById(id);
    }

    @CrossOrigin
    @PostMapping
    public Llist saveLlist(@RequestBody Llist llist){
        return this.llistService.saveLlist(llist);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Llist updateLlist(@RequestBody Llist newLlist, @PathVariable Long id){
        return this.llistService.updateName(newLlist, id);
    }

    @PostMapping("/{id}/task")
    public Llist addTaskToList(@RequestBody Task newTask, @PathVariable Long id){
        return this.llistService.addTaskToList(id,newTask);
    }



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
