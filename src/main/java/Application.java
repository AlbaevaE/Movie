
import entities.Directors;
import entities.Film;
import entities.Genre;
import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;


import java.util.List;


public class Application {
    public static void main(String[] args) {
        deleteAll("Film");
        deleteAll("Genre");
        deleteAll("Directors");

        Genre genre = new Genre(1, "drama");
        Genre g1 = new Genre(2, "epic novel");
        Directors directors = new Directors(1, "Лоррэйн Леви");
        Directors d1 = new Directors(2, "Victor Fleming");
        Film film = new Film(1, "Gone with the Wind", g1, d1, 3977000, 400176459, "Лучший фильм,\n" +
                "Лучшая женская роль (Вивьен Ли),\n" +
                "Лучшая женская роль второго плана (Хэтти Макдэниел),\n" +
                "Лучший режиссёр (Виктор Флеминг),\n" +
                "Лучший адаптированный сценарий,\n" +
                "Лучший монтаж.\n" +
                " В 1989 году включён в Национальный регистр фильмов США");

        Film film1 = new Film(2, "Сын другой женщины", genre, directors, 2700000, 1285918, "-");


        createGenre(genre);
        createGenre(g1);
        createDirector(d1);
        createDirector(directors);
        createFilm(film);
        createFilm(film1);

        getFilm("Gone with the Wind");
        getDirectorFromFilm("Victor Fleming");
        getFilmByRevenue(1285918);
        getFilmByBudget(3977000);


    }

    public static Integer createGenre(Genre g) {         //методы создания
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(g);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + g.toString());
        return g.getId();
    }

    public static Integer createDirector(Directors d) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(d);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + d.toString());
        return d.getId();
    }

    public static Integer createFilm(Film f) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(f);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created" + f.toString());
        return f.getId();
    }

    public static List<Film> getFilm(String name) {           //методы получения информации
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Film> list = session.createQuery(
                "FROM Film where name like :p_name ")
                .setParameter("p_name", name)
                .list();
        session.close();
        System.out.println(list);
        return list;
    }

    public static List<Directors> getDirectorFromFilm(String directorName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Directors> directors = session.createQuery(
                "select directors " +
                        "from Film f " +
                        "where f.name like :p_directorName ")
                .setParameter("p_directorName", directorName)
                .list();
        session.close();
        System.out.println(directors);
        return directors;
    }

    public static List<Film> getFilmByRevenue(Integer revenue) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Film> film = session.createQuery("From Film  f where f.boxOfficeTotal =" +
                ":p_revenue").setParameter("p_revenue", revenue).list();
        session.close();
        System.out.println(film);
        return film;
    }

    public static List<Film> getFilmByBudget(Integer budget) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Film> film = session.createQuery("From Film f where f.budget =" +
                ":p_budget").setParameter("p_budget", budget).list();
        session.close();
        System.out.println(film);
        return film;
    }


    public static void deleteAll(String tableName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM " + tableName);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("DELETED ALL");
    }
}
