package entities;

import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @ManyToOne
    @JoinColumn(name = "directors_id")
    private Directors directors;
    @Column(name = "budget_total")
    private Integer budget;
    @Column(name = "box_office_total")
    private Integer boxOfficeTotal;
    @Column(name = "awards")
    private String awards;

    public Film() {
    }

    public Film(Integer id, String name, Genre genre, Directors directors, Integer budget, Integer boxOfficeTotal, String awards) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.directors = directors;
        this.budget = budget;
        this.boxOfficeTotal = boxOfficeTotal;
        this.awards = awards;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Directors getDirectors() {
        return directors;
    }

    public void setDirectors(Directors directors) {
        this.directors = directors;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getBoxOfficeTotal() {
        return boxOfficeTotal;
    }

    public void setBoxOfficeTotal(Integer boxOfficeTotal) {
        this.boxOfficeTotal = boxOfficeTotal;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", directors=" + directors +
                ", budget=" + budget +
                ", boxOfficeTotal=" + boxOfficeTotal +
                ", awards='" + awards + '\'' +
                '}';
    }
}
