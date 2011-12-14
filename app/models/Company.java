package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Company extends Model {
    public String name;
}
