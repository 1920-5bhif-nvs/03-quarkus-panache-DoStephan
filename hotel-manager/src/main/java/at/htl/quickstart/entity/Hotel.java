package at.htl.quickstart.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Hotel.getAll", query = "select h from Hotel h")
})
@Entity
public class Hotel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Hotel() {
    }

    public Hotel(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
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
