package com.example.SpringMVCNoSQL.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employee")
public class Employee {

    @Id
    private Integer id;
    @Field(name = "name")
    private String name;
    @Field(name = "email")
    private String email;
    @Field(name = "location")
    private String location;
}
