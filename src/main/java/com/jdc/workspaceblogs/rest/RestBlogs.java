package com.jdc.workspaceblogs.rest;

import com.jdc.workspaceblogs.dto.BlogsDTO;
import com.jdc.workspaceblogs.model.Blogs;
import com.jdc.workspaceblogs.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class RestBlogs {
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
    public ResponseEntity<Blogs> create(@RequestBody BlogsDTO blogsDTO){
        try {
            Blogs savedBlogs = blogsService.save(blogsDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBlogs);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            Blogs blogs = blogsService.findById(id);
            if (blogs == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("La cita con ID " + id + " no existe");
            }
            blogsService.deleteById(id);
            return ResponseEntity.ok(list());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("No se puede eliminar la cita porque está siendo utilizada por otros registros. " );
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la cita: " + e.getMessage());
        }
    }

    //Enpoint to update Appointment
    @PutMapping("/update/{id}")
    public Blogs update(@PathVariable Long id, @RequestBody BlogsDTO blogsDTO) {
        Blogs blogExist = blogsService.findById(id);
        if (blogExist == null) {
            return null;
        }

        blogExist.setTitle(blogsDTO.getTitle());
        blogExist.setText(blogsDTO.getText());
        blogExist.setPublicationDate(blogsDTO.getPublicationDate());
        blogExist.setAuthor(blogsDTO.getAuthor());

        return blogsService.saves(blogExist);
    }



}
