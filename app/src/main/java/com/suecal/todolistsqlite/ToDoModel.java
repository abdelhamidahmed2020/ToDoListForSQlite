package com.suecal.todolistsqlite;

public class ToDoModel {
    private String toDoItem;
    private String toDoDate;
    private String toDoTime;
    private boolean completed;

    public ToDoModel(String toDoItem, String toDoDate, String toDoTime, boolean completed) {
        this.toDoItem = toDoItem;
        this.toDoDate = toDoDate;
        this.toDoTime = toDoTime;
        this.completed = completed;
    }

    public String getToDoItem() {
        return toDoItem;
    }

    public void setToDoItem(String toDoItem) {
        this.toDoItem = toDoItem;
    }

    public String getToDoDate() {
        return toDoDate;
    }

    public void setToDoDate(String toDoDate) {
        this.toDoDate = toDoDate;
    }

    public String getToDoTime() {
        return toDoTime;
    }

    public void setToDoTime(String toDoTime) {
        this.toDoTime = toDoTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
