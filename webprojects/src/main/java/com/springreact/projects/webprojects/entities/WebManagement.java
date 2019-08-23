package com.springreact.projects.webprojects.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WebManagement {
    //@Id we can also add @Id annotation but already defined as id so spring will know that what I meant to be
    private String id;
    private String name;
}
