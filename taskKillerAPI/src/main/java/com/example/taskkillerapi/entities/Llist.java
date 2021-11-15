package com.example.taskkillerapi.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="list")
@RequiredArgsConstructor
public class Llist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //se crea id unico
    @Column(name="id_list", nullable = false, unique = true)  //nombre de la columna y algunas caracteristicas
    private Long id;

    @Column(length = 50)
    private String name;

    //varias tareas pueden ser parte de una hoja    //@JsonManagedReference//@JsonIgnore
     @Column
     @OneToMany(mappedBy = "llist", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
     private List<Task> tasks=new ArrayList<>();

    public void addTaskToList(Task task){
        tasks.add(task);
    }
}
