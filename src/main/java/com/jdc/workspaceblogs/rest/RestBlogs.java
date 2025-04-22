package com.jdc.workspaceblogs.rest;

import com.jdc.workspaceblogs.model.Blogs;
import com.jdc.workspaceblogs.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class RestDoctor {
    @Autowired
    private BlogsService blogsService;

    @GetMapping("/list")
    private ResponseEntity<List<Blogs>> list(){
        return  ResponseEntity.ok(blogsService.findAll());
    }

    @GetMapping("/findby/{id}")
    private ResponseEntity<Blogs> listIndividual(@PathVariable("id") Long id){
        return ResponseEntity.ok(blogsService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Blogs> create(@RequestBody CreateBlogs doctorDTO){
        try {
            Doctor savedDoctor = serviceDoctor.save(doctorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
