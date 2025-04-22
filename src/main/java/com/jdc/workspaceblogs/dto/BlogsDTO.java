package com.jdc.workspaceblogs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class BlogsDTO {
    private String title;
    private String text;
    private Date publicationDate;
    private String author;
}
