package com.example.taskkillerapi.services;
import com.example.taskkillerapi.entities.Llist;
import com.example.taskkillerapi.entities.Task;
import com.example.taskkillerapi.repositories.LlistRepository;
import com.example.taskkillerapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LlistService {

        @Autowired //
        LlistRepository llistRepository;

        @Autowired
        TaskRepository taskRepository;

        public ArrayList<Llist> getLlists(){
            return(ArrayList<Llist>) llistRepository.findAll();
        }

        public Llist saveLlist(Llist llist){
            return llistRepository.save(llist);
        }

        public Optional<Llist> findById(Long id){
            return llistRepository.findById(id);
        }

        public boolean deleteLlist(Long id){ //esta dentro de una funcion boolean porque asi si falla
            try {                          // no fallara el programa
                llistRepository.deleteById(id);
                return true;
            }catch (Exception ex){
                return false;
            }
        }

        public Llist addTaskToList(Long id, Task task){
            return llistRepository.findById(id)
                    .map(
                            llist->{
                                llist.addTaskToList(task);
                                taskRepository.save(task);
                                return llistRepository.save(llist);
                            }
                    ).get();
        }

        public Llist updateName(Llist newLlist, Long id) {
            return llistRepository.findById(id)
                            .map(
                                    llist->{
                                        llist.setName(newLlist.getName());
                                        return llistRepository.save(llist);
                                    }
                            ).get();

        }

    }
