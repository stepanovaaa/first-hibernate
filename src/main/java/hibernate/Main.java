package hibernate;

import hibernate.entity.User;
import jakarta.persistence.Query;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;

import java.util.List;

@Log4j2
public class Main {
    public static void main(String[] args) {
        log.info("tutorials start");
        // получаем готовый Session Factory и сразу создаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From User", User.class);
        List<User> users = query.getResultList();

        log.info(users);

        session.close(); // закрыть сессию

        HibernateUtil.close(); // закрыть Session Factory
    }
}