package ru.gb.Lesson04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.gb.Lesson04.models.Person;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();

            Person person1 = new Person("Алексей", 30);
            Person person2 = new Person("Мария", 25);
            Person person3 = new Person("Иван", 40);

            session.beginTransaction();

            session.save(person1);
            session.save(person2);
            session.save(person3);

            session.getTransaction().commit();

            System.out.println("Объекты успешно сохранены!");
        }
    }
}
