package com.juranoaa.sqlite.ormlite;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by SungGeun on 2015-10-10.
 */
public class House {

    // auto increment
    @DatabaseField(generatedId = true)
    Integer id;

    @DatabaseField
    String name;

    public House() {

    }

    public House(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public House(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
