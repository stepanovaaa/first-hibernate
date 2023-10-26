package hibernate;

import hibernate.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Log4j2
public class Main {
    public static void main(String[] args) {
        log.info("tutorials start");
        // получаем готовый Session Factory и сразу создаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();
//        // подготовка запроса - полцчение всех пользователей
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.select(root); // конечный запрос select из таблицы User
//
//        Predicate p1 = criteriaBuilder.gt(root.get("id"), 1000);
//        Predicate p2 = criteriaBuilder.lt(root.get("id"), 1005);
//
//        criteriaQuery.select(root).where(criteriaBuilder.and(p1,p2));
//
//        // Выполнение запроса с получением результата
//        Query query = session.createQuery(criteriaQuery);
//        List<User> users = query.getResultList();

//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaDelete<User> criteriaDelete = cb.createCriteriaDelete(User.class);
//        Root<User> root = criteriaDelete.from(User.class);
//        criteriaDelete.where(cb.equal(root.get("id"),5003));
//
//        Transaction transaction = session.beginTransaction();
//        session.createQuery(criteriaDelete).executeUpdate();
//        transaction.commit();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<User> criteriaUpdate = cb.createCriteriaUpdate(User.class);
        Root<User> root = criteriaUpdate.from(User.class);

        criteriaUpdate.set("email", "sgoihdfugh@gmail.ru");
        criteriaUpdate.where(cb.equal(root.get("id"), 3));

        Transaction transaction = session.beginTransaction();
        session.createQuery(criteriaUpdate).executeUpdate();
        transaction.commit();

        session.close(); // закрыть сессию

        HibernateUtil.close(); // закрыть Session Factory
    }
}