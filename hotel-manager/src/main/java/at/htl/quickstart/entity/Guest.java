package at.htl.quickstart.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Guest.getAll", query = "select g from Guest g"),
})
@Entity
public class Guest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Guest() {
    }

    public Guest(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
