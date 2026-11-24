package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.entities.task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface taskRepository extends JpaRepository<task, UUID> {
}
