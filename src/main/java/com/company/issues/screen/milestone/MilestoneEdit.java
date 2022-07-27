package com.company.issues.screen.milestone;

import io.jmix.ui.screen.*;
import com.company.issues.entity.Milestone;

@UiController("Milestone.edit")
@UiDescriptor("milestone-edit.xml")
@EditedEntityContainer("milestoneDc")
public class MilestoneEdit extends StandardEditor<Milestone> {
}