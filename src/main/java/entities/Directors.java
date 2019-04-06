package entities;

import javax.persistence.*;

@Entity
@Table(name = "directors")
public class Directors {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    public Directors() {
    }

    public Directors(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Directors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
