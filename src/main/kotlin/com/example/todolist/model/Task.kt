package com.example.todolist.model

import com.example.todolist.repository.TaskRepository
import jakarta.persistence.*
import org.springframework.context.annotation.Description
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
/*
* @Entity - это аннотация говорить Hibernate что это класс должен быть срхранен в бд
* @Table - создаем таблицу в бд,name = имя таблицы
* @Id @GeneratedValue - говорить о том что поля @Id  является первичным ключом
* @Column - создаем столбцы для таблицы
*
* */
@Entity
@Table(name = "tasks")
data class Task (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long = 0,

        @Column(name = "title", nullable = false)
        var title:String,

        @Column(name = "description")
        var description: String?=null,

        @Column(name = "status")
        var status:Boolean = false
)

