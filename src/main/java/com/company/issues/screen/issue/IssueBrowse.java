package com.company.issues.screen.issue;

import com.company.issues.app.IssueService;
import com.company.issues.entity.User;
import io.jmix.core.SaveContext;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.screen.*;
import com.company.issues.entity.Issue;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Set;

@UiController("Issue.browse")
@UiDescriptor("issue-browse.xml")
@LookupComponent("table")
public class IssueBrowse extends MasterDetailScreen<Issue> {

    @Autowired
    private IssueService issueService;

    @Install(target = Target.DATA_CONTEXT)
    private Set<Object> commitDelegate(SaveContext saveContext) {
        Issue savedIssue = issueService.save(getEditedEntity());
        return Collections.singleton(savedIssue);
    }
    
    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onInitEntity(InitEntityEvent<Issue> event) {
        User currentUser = (User) currentAuthentication.getUser();
        event.getEntity().setAuthor(currentUser);
    }
}