package com.taskmanager.taskmanager.abstracts;

import com.taskmanager.taskmanager.entities.task;

import java.util.List;
import java.util.UUID;

public interface taskService {
    List<task> findAll();
    void deleteTask(UUID taskId);
    task findOne(UUID taskId);
    task createTask(task task);
    task updateTask(UUID taskId , task task);
}
