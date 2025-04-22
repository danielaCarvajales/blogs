package com.jdc.workspaceblogs.model;



import jakarta.persistence.*;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.util.Date;

@Entity
@Table(name = "Blogs")
@Data
public class Blogs {

    @Serial
    private static final long serialVersionUID = 1L;

    // Mapping of primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_blogs")
    private Long idBlogs;

    // Mapeo de campos
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "text")
    private String text;

    @NotNull
    @Column(name = "publication_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "author")
    private String author;
}
