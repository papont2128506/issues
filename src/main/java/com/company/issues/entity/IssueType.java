package com.company.issues.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum IssueType implements EnumClass<Integer> {

    BUG(10),
    FEATURE(20);

    private Integer id;

    IssueType(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static IssueType fromId(Integer id) {
        for (IssueType at : IssueType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}