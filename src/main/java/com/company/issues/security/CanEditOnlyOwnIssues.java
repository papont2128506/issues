package com.company.issues.security;

import com.company.issues.entity.Issue;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import org.springframework.context.ApplicationContext;

@RowLevelRole(name = "CanEditOnlyOwnIssuesRole", code = "CanEditOnlyOwnIssuesRole")
public interface CanEditOnlyOwnIssues {

    @PredicateRowLevelPolicy(entityClass = Issue.class, actions ={RowLevelPolicyAction.DELETE, RowLevelPolicyAction.UPDATE})
    default RowLevelBiPredicate<Issue, ApplicationContext> issues() {
        return (issue, applicationContext) -> {
            CurrentAuthentication currentAuthentication = applicationContext.getBean(CurrentAuthentication.class);
            return currentAuthentication.getUser().equals(issue.getAuthor());
        };
    }
}
