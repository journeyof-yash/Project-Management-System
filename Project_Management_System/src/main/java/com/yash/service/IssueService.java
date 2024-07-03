package com.yash.service;

import com.yash.model.Issue;
import com.yash.model.User;
import com.yash.request.IssueRequest;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;
import java.util.Optional;

public interface IssueService {

    Issue getIssueById(Long issueId) throws Exception;

    List<Issue> getIssueByProjectId(Long projectId)throws Exception;

    Issue createIssue(IssueRequest issue , User user) throws Exception;

    void deleteIssue(Long issueId , Long userid)throws  Exception;

    Issue addUserToIssue(Long issueId , Long userid)throws Exception;

    Issue updateStatus(Long issueId , String status)throws Exception;




}
