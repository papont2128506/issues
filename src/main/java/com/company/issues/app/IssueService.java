package com.company.issues.app;

import com.company.issues.entity.Issue;
import io.jmix.core.DataManager;
import io.jmix.email.Emailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IssueService {
    @Autowired
    private DataManager dataManager;
    @Autowired
    private Emailer emailer;

    public Issue save(Issue issue) {
        Issue save = dataManager.save(issue);

//        emailer.sendEmail();
        return save;
    }
}