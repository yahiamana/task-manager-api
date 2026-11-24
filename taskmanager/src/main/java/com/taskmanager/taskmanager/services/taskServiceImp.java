package com.taskmanager.taskmanager.services;

import com.taskmanager.taskmanager.abstracts.taskService;
import com.taskmanager.taskmanager.entities.task;
import com.taskmanager.taskmanager.repository.taskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class taskServiceImp implements taskService {
    private  final taskRepository taskRepository;
    public taskServiceImp(taskRepository taskRepository){
        this.taskRepository=taskRepository;
    }
    @Override
    public List<task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(UUID taskId) {
        task task = findOne(taskId);
        taskRepository.delete(task);


    }

    @Override
    public task findOne(UUID taskId) {
        return taskRepository.findById(taskId)
        .orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "not found"

                )
        );
    }

    @Override
    public task createTask(task task) {
        return taskRepository.save(task);
    }

    @Override
    public task updateTask(UUID taskId, task task) {
        task existTask = taskRepository.findById(taskId).orElseThrow(()->
           new     ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "not found"
                ));
        existTask.setTitle(task.getTitle());
        existTask.setDescription(task.getDescription());
        return taskRepository.save(existTask);
    }
}
