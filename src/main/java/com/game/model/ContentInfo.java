package com.game.model;


public class ContentInfo {
    private int id;
    private int type;
    private String context;
    private int queue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }


}
