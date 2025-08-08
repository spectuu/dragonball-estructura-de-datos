package taller.model;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

public class Character implements Serializable {

    private long id;

    private String name;
    private String ki;
    private String maxKi;
    private String race;
    private String gender;
    private String description;
    private String affiliation;
    private String deletedAt;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKi() {
        return ki;
    }

    public String getMaxKi() {
        return maxKi;
    }

    public String getRace() {
        return race;
    }

    public String getGender() {
        return gender;
    }

    public String getDescription() {
        return description;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Character;
    }

    @Override
    public String toString() {
        return "Character {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ki='" + ki + '\'' +
                ", maxKi='" + maxKi + '\'' +
                ", race='" + race + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", deletedAt='" + deletedAt + '\'' +
                '}';
    }

}
