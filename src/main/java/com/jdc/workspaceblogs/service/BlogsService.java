package com.jdc.workspaceblogs.service;

import com.jdc.workspaceblogs.dto.BlogsDTO;
import com.jdc.workspaceblogs.model.Blogs;

import java.util.List;

public interface BlogsService {
    public List<Blogs> findAll(); // obtain all the  registered appointments
    public Blogs findById(Long id); // Obtains the Appointment by id
    public Blogs save(BlogsDTO blogsDTO); // Create a appointments
    public void deleteById(Long id);
    Blogs saves(Blogs blogs);
}
