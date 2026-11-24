package com.taskmanager.taskmanager.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class task {

    @Id
    @GeneratedValue(generator = "UUID")
    @Generated
    private UUID Id;

    @Column(nullable = false,name = "title")
    @NotBlank
    private String title;

    @Column(name = "description" , nullable = false)
    @NotBlank
    private String description;
}
