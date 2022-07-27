package com.company.issues.screen.milestone;

import io.jmix.ui.screen.*;
import com.company.issues.entity.Milestone;

@UiController("Milestone.browse")
@UiDescriptor("milestone-browse.xml")
@LookupComponent("milestonesTable")
public class MilestoneBrowse extends StandardLookup<Milestone> {
}