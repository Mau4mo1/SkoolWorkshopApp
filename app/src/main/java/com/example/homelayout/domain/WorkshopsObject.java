package com.example.homelayout.domain;

public class WorkshopsObject {
    private int id;
    private String category;
    private String codeName;
    private String shortDesc;
    private boolean needsApp;

    public WorkshopsObject(int id, String category, String codeName, String shortDesc, boolean needsApp) {
        this.id = id;
        this.category = category;
        this.codeName = codeName;
        this.shortDesc = shortDesc;
        this.needsApp = needsApp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public boolean isNeedsApp() {
        return needsApp;
    }

    public void setNeedsApp(boolean needsApp) {
        this.needsApp = needsApp;
    }
}
