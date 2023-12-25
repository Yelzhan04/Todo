package com.example.todolist.repository

import com.example.todolist.model.Task
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Репозиторий для работы с сущностью Task.
 *
 * Этот репозиторий предоставляет методы для выполнения операций CRUD (Create, Read, Update, Delete)
 * с сущностью Task в базе данных.
 *
 * @see Task
 */
@Repository
interface TaskRepository:JpaRepository<Task,Long>{

}