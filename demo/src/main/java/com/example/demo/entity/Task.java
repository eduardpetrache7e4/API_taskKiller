package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //se crea id unico
    @Column(name="id_task", nullable = false, unique = true)  //nombre de la columna y algunas caracteristicas
    private Long id;

    @Column(length = 300)  //nombre de la columna y algunas caracteristicas

    private String content;

    private LocalDate startDate;

    //una tarea puede estar solo en una hoja
    @ManyToOne
    private Sheet sheet;
}
