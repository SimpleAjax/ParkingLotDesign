package com.ajax.parkinglot.models.sections;

public abstract class Section {
    String sectionId;
    Section parentSection;

    public Section(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionId() {
        String parentId = parentSection == null ? "" : parentSection.getSectionId();
        return parentId + sectionId;
    }

    public void setParentSection(Section parentSection) {
        this.parentSection = parentSection;
    }
}
