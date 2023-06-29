package com.daniel.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.crudspring.model.Course;
import com.daniel.crudspring.service.CourseService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    
    private final CourseService  courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Course> list(){
        return courseService.list();
    }

    @GetMapping("/{id}")
    public Course GetId(@PathVariable @NotNull @Positive Long id){
        return courseService.findById(id);
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody @Valid Course course){
     return courseService.create(course); 
    //ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Course course){
        return courseService.update(id,course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id ){
        courseService.delete(id);
    }
}