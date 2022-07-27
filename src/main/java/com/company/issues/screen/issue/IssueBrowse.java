package com.company.issues.screen.issue;

import io.jmix.ui.screen.*;
import com.company.issues.entity.Issue;

@UiController("Issue.browse")
@UiDescriptor("issue-browse.xml")
@LookupComponent("table")
public class IssueBrowse extends MasterDetailScreen<Issue> {
}