package atto;


import atto.controller.*;
import atto.database.Database;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        Database.initAdmins();
//        Database.createProfileTable();
//        Database.createCardTable();
//        Database.createTerminalTable();
//        Database.createTransactionTable();
//
//
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//
//        MenuController menuController = (MenuController) context.getBean("menuController");
//        menuController.startAttoSection();


//
//        AdminController adminController = (AdminController) context.getBean("adminController");
//        adminController.adminSectionMenu();
//
//        ProfileController profileController = (ProfileController) context.getBean("profileController");
//        profileController.adminProfileMenu();
//
//        CardController cardController = (CardController) context.getBean("cardController");
//        cardController.adminCardMenu();
//
//        TerminalController terminalController = (TerminalController) context.getBean("terminalController");
//        terminalController.adminTerminalMenu();
//
//        UserController userController = (UserController) context.getBean("userController");
//        userController.userCardMenu();



        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();


//        EmployeeEntity e1 = new EmployeeEntity();
//        e1.setFirstName("Guarov");
//        e1.setLastName("Chawla");


        AdminController adminController = new AdminController();
        session.save(adminController);
        transaction.commit();


        factory.close();
        session.close();

    }


}
