package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.entities.task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface taskRepository extends JpaRepository<task, UUID> {
}
