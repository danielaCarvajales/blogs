package com.jdc.workspaceblogs.repository;

import com.jdc.workspaceblogs.model.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blogs, Long> {
}
