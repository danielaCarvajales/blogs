package com.jdc.workspaceblogs.service.implement;

import com.jdc.workspaceblogs.dto.BlogsDTO;
import com.jdc.workspaceblogs.model.Blogs;
import com.jdc.workspaceblogs.repository.BlogRepository;
import com.jdc.workspaceblogs.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplementsBlogs implements BlogsService {

    @Autowired
private BlogRepository blogRepository;
    @Override
    public List<Blogs> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blogs findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blogs save(BlogsDTO blogsDTO) {
        Blogs blog = new Blogs();
        blog.setTitle(blogsDTO.getTitle());
        blog.setText(blogsDTO.getText());
        blog.setPublicationDate(blogsDTO.getPublicationDate());
        blog.setAuthor(blogsDTO.getAuthor());

       return blogRepository.save(blog);
    }




    @Override
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blogs saves(Blogs blogs) {
        return blogRepository.save(blogs);

    }
}
