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
    @Column
    private LocalDate startDate;
    @Column
    private boolean done;

    @ManyToOne
    @JoinColumn(name = "sheet")
    private Sheet sheet;

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }


    public Task(String content, LocalDate startDate) {
        this.content = content;
        this.startDate = startDate;
        this.done=false;
    }


}
