package com.company.issues.security;

import com.company.issues.entity.Issue;
import com.company.issues.entity.Milestone;
import com.company.issues.entity.User;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "Reporter", code = "reporter")
public interface ReporterRole {
    @MenuPolicy(menuIds = "Issue.browse")
    @ScreenPolicy(screenIds = "Issue.browse")
    void screens();

    @EntityAttributePolicy(entityClass = Issue.class, attributes = "milestone", action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = Issue.class, attributes = {"id", "version", "deletedBy", "deletedDate", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate", "title", "description", "type", "author"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Issue.class, actions = EntityPolicyAction.ALL)
    void issue();

    @EntityPolicy(entityClass = Milestone.class, actions = EntityPolicyAction.READ)
    @EntityAttributePolicy(entityClass = Milestone.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    void milestone();

    @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.READ)
    void user();
}