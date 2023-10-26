package hibernate;

import hibernate.entity.User;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;

import java.util.List;

@Log4j2
public class Main {
    public static void main(String[] args) {
        log.info("tutorials start");
        // получаем готовый Session Factory и сразу создаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();
        // подготовка запроса - полцчение всех пользователей
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root); // конечный запрос select из таблицы User

        // Выполнение запроса с получением результата
        Query query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();

        session.close(); // закрыть сессию

        HibernateUtil.close(); // закрыть Session Factory
    }
}