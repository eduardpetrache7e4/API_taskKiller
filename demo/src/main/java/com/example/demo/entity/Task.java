package com.example.demo.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="Task")
@RequiredArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //se crea id unico
    @Column(name="id_task", nullable = false, unique = true)  //nombre de la columna y algunas caracteristicas
    private Long id;

    @Column(length = 300)  //nombre de la columna y algunas caracteristicas
    private String content;

    private LocalDate startDate;

    private boolean done;

    //una tarea puede estar solo en una hoja
    @ManyToOne
    private Sheet sheet;

    public Task(String content, LocalDate startDate) {
        this.content = content;
        this.startDate = startDate;
        this.done=false;
    }


}
