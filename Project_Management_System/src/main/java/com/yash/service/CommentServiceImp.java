package com.yash.service;

import com.yash.model.Comments;
import com.yash.model.Issue;
import com.yash.model.User;
import com.yash.repository.CommentRepository;
import com.yash.repository.IssueRepository;
import com.yash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImp implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private UserRepository userRepository;




    @Override
    public Comments createComment(Long issueId, Long userId, String comment, String content) throws Exception {

        Optional<Issue> issueOptional = issueRepository.findById(issueId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (issueOptional.isEmpty()){
            throw new Exception("issue not found with id"+userId);
        }
        if (userOptional.isEmpty()){
            throw new Exception("user not found with id"+userId);

        }

        Issue issue = issueOptional.get();
        User user = userOptional.get();

        Comments comments =  new Comments();

        comments.setIssue(issue);
        comments.setUser(user);
        comments.setCreatedDateTime(LocalDateTime.now());
        comments.setContent(content);

        Comments savedComment = commentRepository.save(comments);
        issue.getComments().add(savedComment);
        return savedComment;
    }

    @Override
    public void deleteComment(Long commentId, Long userId) throws Exception {

        Optional<Comments> commentsOptional = commentRepository.findById(commentId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (commentsOptional.isEmpty()){
            throw new Exception("comment not found with id"+commentId);
        }
        if (userOptional.isEmpty()){
            throw new Exception("user not found with id"+userId);
        }

        Comments comments = commentsOptional.get();
        User user = userOptional.get();

        if (comments.getUser().equals(user)){
            commentRepository.delete(comments);
        } else {
            throw new Exception("user does not have permission to delete this comment!");
        }

    }

    @Override
    public List<Comments> findCommentByIssueId(Long issueId) {
        return commentRepository.findByIssueId(issueId);
    }
}
