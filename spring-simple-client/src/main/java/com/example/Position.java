package com.example;

/**
 * Created by sai on 16-8-5.
 */
public class Position
{

    private String id;
    private String name;
    private String companyName;
    private String groupName;
    private String functionName;
    private String subFuncName;

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", functionName='" + functionName + '\'' +
                ", subFuncName='" + subFuncName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getSubFuncName() {
        return subFuncName;
    }

    public void setSubFuncName(String subFuncName) {
        this.subFuncName = subFuncName;
    }
}
