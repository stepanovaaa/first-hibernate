package hibernate;

import lombok.extern.log4j.Log4j2;
import hibernate.entity.User;
import org.hibernate.Session;
@Log4j2
public class Main {
    public static void main(String[] args) {
        log.info("tutorials start");
        // получаем готовый и сразу создаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();
        // открыть транзакцию
        session.getTransaction().begin();

        User user = new User(); // состояние NEW (transient)
        user.setEmail("newfrommap1@mail.com");
        user.setUsername("newfrom1");
        user.setPassword("s;klgh;jgh");

        session.persist(user); // // состояние managed (persistent - управляемый объект - контейнером)

        session.getTransaction().commit(); // сохранить изменения
        session.close(); // закрыть транзакцию
        // detached
        HibernateUtil.close();
    }
}