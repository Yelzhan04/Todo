package com.example.todolist.controller

import com.example.todolist.model.Task
import com.example.todolist.service.TaskService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
/**
 * REST контроллер для управления задачами.
 *
 * Контроллер обеспечивает взаимодействие между клиентским приложением и сервисом задач.
 *
 * @property taskService Сервис для работы с задачами.
 *
 * @RestController: Аннотация, которая объявляет класс как контроллер REST.
 *
 * @RequestMapping("api/v1/task"): Аннотация, указывающая базовый путь для всех методов контроллера.
 */
@RestController
@RequestMapping("api/v1/task")
class TaskController(
    private val taskService: TaskService
) {

    /**
     * @GetMapping: Аннотация для обработки HTTP-запросов типа GET.
     *
     * Получить список всех задач.
     *
     * @return Список задач
     */
    @GetMapping
    fun getAll(): List<Task> = taskService.getTask()

    /**
     * @GetMapping: Аннотация для обработки HTTP-запросов типа GET.
     *
     * @PathVariable: Аннотация, которая связывает параметр метода с переменной из URI.
     *
     * Получить задачу по идентификатору.
     *
     * @param id Идентификатор задачи.
     *
     * @return Задача с указанным идентификатором.
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Task {
        return taskService.findbyId(id)
    }

    /**
     * @PostMapping: Аннотация для обработки HTTP-запросов типа POST.
     *
     * @RequestBody: Аннотация, которая связывает параметр метода с телом HTTP-запроса.
     *
     * Создать новую задачу.
     *
     * @param task Данные для создания задачи.
     *
     * @return Созданная задача.
     */
    @PostMapping("")
    fun create(@RequestBody task: Task): Task {
        return taskService.save(task)
    }

    /**
     * @PutMapping: Аннотация для обработки HTTP-запросов типа PUT.
     *
     * @PathVariable: Аннотация, которая связывает параметр метода с переменной из URI.
     *
     * Обновить задачу по идентификатору.
     *
     * @param id Идентификатор задачи для обновления.
     *
     * @param task Обновленные данные задачи.
     *
     * @return Обновленная задача.
     */
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody task: Task): Task {
        return taskService.update(id, task)
    }

    /**
     * @DeleteMapping: Аннотация для обработки HTTP-запросов типа DELETE.
     *
     * @PathVariable: Аннотация, которая связывает параметр метода с переменной из URI.
     *
     * Удалить задачу по идентификатору.
     *
     * @param id Идентификатор задачи для удаления.
     */
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        taskService.deleteById(id)
    }
}