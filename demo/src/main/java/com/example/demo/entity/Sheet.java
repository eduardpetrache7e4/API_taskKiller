package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Sheet")
@RequiredArgsConstructor
public class Sheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //se crea id unico
    @Column(name="id_sheet", nullable = false, unique = true)  //nombre de la columna y algunas caracteristicas
    private Long id;

    @Column(length = 50)
    private String name;

     //varias tareas pueden ser parte de una hoja
   //  @OneToMany(mappedBy = "sheet", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    // @JsonManagedReference
    // private List<Task> tasks=new ArrayList<>();

     public Sheet(String name) {
        this.name = name;
    }
    
}
