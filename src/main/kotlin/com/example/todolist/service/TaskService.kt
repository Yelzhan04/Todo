package com.example.todolist.service

import com.example.todolist.model.Task
import org.apache.catalina.User

/**
 * Сервис для работы с задачами.
 *
 * Этот сервис предоставляет методы для взаимодействия с задачами, такие как получение, сохранение,
 * поиск по идентификатору, удаление и обновление задач.
 */

interface TaskService {

    /**
     * Получить список всех задач.
     *
     * @return Список задач
     */
    fun getTask():List<Task>

    /**
     * Сохранить задачу.
     *
     * @param task Задача для сохранения
     * @return Сохраненная задача
     */
    fun save(task: Task):Task

    /**
     * Найти задачу по идентификатору.
     *
     * @param id Идентификатор задачи
     * @return Найденная задача
     */
    fun findbyId(id: Long):Task

    /**
     * Удалить задачу по идентификатору.
     *
     * @param id Идентификатор задачи
     */
    fun deleteById(id: Long)

    /**
     * Обновить задачу по идентификатору.
     *
     * @param id Идентификатор задачи
     * @param task Обновленные данные задачи
     * @return Обновленная задача
     */
    fun update(id: Long,task: Task):Task

}