package com.example.taskkillerapi.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "task")
@RequiredArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //se crea id unico
    @Column(name="id_task", nullable = false, unique = true)  //nombre de la columna y algunas caracteristicas
    private Long id;

    @Column(length = 300)  //nombre de la columna y algunas caracteristicas
    private String content;

    @Column
    private boolean done;

    @ManyToOne
    @JoinColumn(name = "list")
    private Llist list;



}
