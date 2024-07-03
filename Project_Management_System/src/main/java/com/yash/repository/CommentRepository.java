package com.yash.repository;

import com.yash.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments , Long> {

    List<Comments> findByIssueId(Long issueId);


}
