package com.game.entity;

/**
 * Created by xiayifan on 2017/9/8.
 */
public class GameInfo {
    private int id;
    private String name;
    private String enName;
    private String publisher;
    private int type;
    private int net;
    private String version;
    private String desribe;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setNet(int net) {
        this.net = net;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDesribe(String desribe) {
        this.desribe = desribe;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEnName() {
        return enName;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getType() {
        return type;
    }

    public int getNet() {
        return net;
    }

    public String getVersion() {
        return version;
    }

    public String getDesribe() {
        return desribe;
    }

}
