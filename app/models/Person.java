package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person extends Model {
    public String name;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Position> positions;
}
