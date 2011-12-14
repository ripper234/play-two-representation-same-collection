package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Project extends Model {
    public Project(){}
    public Project(String field, String status){
        this.theField = field;
        this.status = status;
    }

    @ManyToOne
    public Position position;

    public String theField;
    public String status;
}


