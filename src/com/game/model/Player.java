package com.game.model;

import com.game.utils.Utils;

public class Player {
    private String id;
    private String name;

    public Player(String name) {
        this.id = Utils.getUUID();
        this.name = name;
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
}
