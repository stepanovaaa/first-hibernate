package hibernate;

import hibernate.entity.User;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

@Log4j2
public class Main {
    public static void main(String[] args) {
//        log.info("tutorials start");
        // получаем готовый Session Factory и сразу создаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();

        String qry = "select * from todolist.user_data";
        NativeQuery sqlQuery = session.createNativeQuery(qry, User.class);
        sqlQuery.addEntity(User.class);
        sqlQuery.setMaxResults(10);

        List<User> list = sqlQuery.list();
        log.info(list);

        session.close(); // закрыть сессию

        HibernateUtil.close(); // закрыть Session Factory
    }
}