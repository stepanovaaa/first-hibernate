package hibernate;

import hibernate.entity.User;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;

@Log4j2
public class Main {
    public static void main(String[] args) {
//        log.info("tutorials start");
        // получаем готовый Session Factory и сразу создаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();

        User user = session.get(User.class, 1);

        log.info(user);

        session.close(); // закрыть сессию

        HibernateUtil.close(); // закрыть Session Factory
    }
}