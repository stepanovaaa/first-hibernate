# first-hibernate
Изучение фреймворка Hibernate по курсу https://javabegin.ru/courses/osnovy-hibernate


SDK: openjdk-21

Система сборки: Gradle 

Библиотеки: Lombok 1.18.30

БД: postgresql 42.6.0

Jakarta JPA: Hibernate 6.3.1.Final

Логировщик: log4j 2.21.1


src\main\resources\hibernate.cfg.xml содержит объект-контейнер, в котором создается одно соединение с БД. В нем хранится информация для поключения к БД.

hibernate.HibernateUtil - класс для инициализации Hibernate. Переменная класса содержит информацию о соединении с БД. Геттер похволяет использовать переменную в других классах. Метод close закрывает соединение.

hibernate.entity.User - класс(объект), представляющий таблицу user_data из БД. Он помещается в Hibernate контейнер и все его изменения сохраняются в БД.

hibernate.Main - запуск проекта

src\main\resources\log4j2.properties - настройка детального вывода информации по разным пакетам.
