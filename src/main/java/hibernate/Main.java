package hibernate;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

@Log4j2
public class Main {
    public static void main(String[] args) {
//        log.info("tutorials start");
        // получаем готовый Session Factory и сразу создаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();

        String qry = "select " +
                "    count(u.id), " +
                "    substring(u.email, position('@' in u.email)+1, length(u.email)) as domainmail " +
                "from todolist.user_data u " +
                "where u.email like '%@%' " +
                "group by substring(u.email, position('@' in u.email)+1, length(u.email))";
        NativeQuery<Object[]> sqlQuery = session.createNativeQuery(qry, Object[].class);

        log.info(sqlQuery.getResultList());

        for(Object obj: sqlQuery.getResultList()){
            Object[] objArray = (Object[]) obj;
            log.info(objArray[0]);
            log.info(objArray[1]);
            log.info("------");
        }

        session.close(); // закрыть сессию

        HibernateUtil.close(); // закрыть Session Factory
    }
}