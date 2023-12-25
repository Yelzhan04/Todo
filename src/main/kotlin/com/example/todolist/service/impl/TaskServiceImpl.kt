package com.example.todolist.service.impl

import com.example.todolist.model.Task
import com.example.todolist.repository.TaskRepository
import com.example.todolist.service.TaskService
import org.springframework.stereotype.Service


/**
 * Реализация сервиса для работы с задачами.
 * @Service это аннотация означает что класс предоставляет бизнес-логику
 * @property taskRepository Репозиторий задач.
 */

@Service
class TaskServiceImpl(private val taskRepository: TaskRepository):TaskService  {

    /**
     * Получить список всех задач.
     *
     * @return Список задач
     */
    override fun getTask(): List<Task> {
        return taskRepository.findAll()
    }

    /**
     * Сохранить задачу.
     *
     * @param task Задача для сохранения
     * @return Сохраненная задача
     */
    override fun save(task: Task):Task{
        return  taskRepository.save(task)
    }

    /**
     * Найти задачу по идентификатору.
     *
     * @param id Идентификатор задачи
     * @return Найденная задача
     * @throws NoSuchElementException если задача не найдена
     */
    override fun findbyId(id: Long):Task{
        return taskRepository.findById(id).orElseThrow{
            NoSuchElementException("User not found with id: $id")
        }
    }

    /**
     * Удалить задачу по идентификатору.
     *
     * @param id Идентификатор задачи
     */
    override fun deleteById(id: Long) {
        taskRepository.deleteById(id)
    }

    /**
     * Обновить задачу по идентификатору.
     *
     * @param id Идентификатор задачи
     * @param updatedTask Обновленные данные задачи
     * @return Обновленная задача
     * @throws NoSuchElementException если задача не найдена
     */
    override fun update(id: Long, updatedTask: Task): Task {
        val tasks = taskRepository.findById(id).orElseThrow{
            NoSuchElementException("User not found$id")
        }
        tasks.title = updatedTask.title
        tasks.description = updatedTask.description
        tasks.status = updatedTask.status

        return taskRepository.save(tasks)
    }


    }

