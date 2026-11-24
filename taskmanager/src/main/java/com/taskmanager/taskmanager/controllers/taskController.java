package com.taskmanager.taskmanager.controllers;

import com.taskmanager.taskmanager.abstracts.taskService;
import com.taskmanager.taskmanager.entities.task;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class taskController {
    private final taskService taskService;
    public taskController(taskService taskService){
        this.taskService=taskService;
    }

    @GetMapping
    ResponseEntity<List<task>> findAll(){
        List<task> tasks = taskService.findAll();
        return new  ResponseEntity<List<task>>(tasks,HttpStatus.OK);

    }

    @GetMapping("/{taskId}")
    ResponseEntity<task> findOne(@PathVariable UUID taskId){
        task task = taskService.findOne(taskId);
        return new ResponseEntity<task>(task,HttpStatus.OK) ;

    }

    @PostMapping
    ResponseEntity<task> createTask(@RequestBody @Valid task task){
        task createdtask = taskService.createTask(task);
        return new ResponseEntity<task>(createdtask,HttpStatus.CREATED);

    }
    @DeleteMapping("/{taskId}")
    ResponseEntity<Void> deleteOne(@PathVariable UUID taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

    }
    @PutMapping("/{taskId}")
    ResponseEntity<task> updateOne(@PathVariable UUID taskId , @RequestBody task task  ){
        task updatedTask = taskService.updateTask(taskId,task);
        return new  ResponseEntity<task>(updatedTask,HttpStatus.OK);


    }
}
