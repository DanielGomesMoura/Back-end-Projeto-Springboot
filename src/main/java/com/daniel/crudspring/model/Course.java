package com.daniel.crudspring.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity

@SQLDelete(sql = "update course set status = 'Inativo' where id = ?")
@Where(clause = "status = 'Ativo'")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;
    
    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String name;
    
    @NotNull
    @Length(max = 20)
    @Pattern(regexp = "Back-End|Front-End")
    @Column(length = 20, nullable = false)
    private String category;
    
    @Length(max = 20)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 20, nullable = false)
    private String status = "Ativo";
}
