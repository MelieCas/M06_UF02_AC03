package com.iticbcn.melie;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.util.PropertySource.Util;
import org.hibernate.SessionFactory;

import com.iticbcn.melie.dao.EmpleatDAO;
import com.iticbcn.melie.model.*;

public class Main {
    private static Connection conn;

    private static SessionFactory session = HibernateUtil.getSessionFactory();
    public static void main(String[] args) {


        
        System.out.println("Welcome to GoldenFord.");
        while (true) {
            System.out.println("""
                What would you like to  do? 
                1. Create
                2. Update
                3. Delete
                4. Show information
                5. List all
                """);
            String option = Utility.input().toLowerCase();
            switch (option) {
                case "1":
                    insertWorker();
                    break;
                case "2":
                    updateWorker();
                    break;
                case "3":
                    deleteRowById();
                    break;
                case "4":
                    searchRowById();
                    break;
                case "5":
                    listAll();
                    break;
                default:;
                    System.out.println("Error: Option " + option + " not recognized");
            }
        }
    }

    public static void listAll() {
        EmpleatDAO empleatDAO = new EmpleatDAO(session);

        List<Empleat> empleats = null;    

        try {
            empleats = empleatDAO.getAll();
        } catch (Exception e) {
             
            e.printStackTrace();
        }
        

        for (Empleat empleat : empleats) {
            System.out.println(empleat);
        }
    }

    public static void loadData() {
        try {
            String scriptDatabase = "databaseScripts/LoadDBScript.sql";

            InputStream streamScript = Main.class.getClassLoader().getResourceAsStream(scriptDatabase);
            

            System.out.println("Database loaded");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertWorker() {

        EmpleatDAO empleatDAO = new EmpleatDAO(session);

        while (true) {

            System.out.println("Insert worker name: ");
            String workerName = Utility.input();

            System.out.println("Insert worker first surname: ");
            String workerSurname = Utility.input();

            System.out.println("Insert worker second surname: ");
            String workerSurname2 = Utility.input();

            System.out.println("Insert worker Identity number (DNI): ");
            String workerDNI = Utility.input();
            while (true) {
                if (!workerDNI.matches("^\\d{8}[A-Z]$")) {
                    System.out.println("Format not supported.");
                    workerDNI = Utility.input();
                } else {
                    break;
                }
            }

            System.out.println("Insert worker phone number: ");
            String workerPhone = Utility.input();
            while (true) {
                if (!workerPhone.matches("^\\d{9}")) {
                    System.out.println("Format not supported.");
                    workerPhone = Utility.input();
                } else {
                    break;
                }
            }
            
            System.out.println("Insert worker salary: ");
            double workerSalaryDouble = 0;
            while (true) {
                String workerSalaryString = Utility.input();
                try {
                    

                    workerSalaryDouble = Integer.parseInt(workerSalaryString);
    
                    if (workerSalaryDouble <= 0) {
                        System.out.println("Salary can't be negative");
                        continue;
                    }
                    break;
                    
                } catch (Exception e) {
                    System.out.println("Salary has to be a number");
                    continue;
                }
            }

            
            Empleat empleat = new Empleat(workerName, workerSurname, workerSurname2, workerDNI, workerPhone, workerSalaryDouble);

            try {
                empleatDAO.save(empleat);
            } catch (Exception e) {
                
                e.printStackTrace();
            }

            System.out.println("Add another worker? (y/N): ");
            String continueInsert = Utility.input();
            if (!Utility.confirmAnswer(continueInsert)) break;
            
        }
    }

    public static void listTableRows() {
        int offset = 0;

        

    }

    public static void searchRowById() {
        EmpleatDAO empleatDAO = new EmpleatDAO(session);
        
        while (true) {
            System.out.println("Write the ID of the worker you want to find: ");
            String workerIdString = Utility.input();
            int workerId = 0;
            try {

                workerId = Integer.parseInt(workerIdString);

                if (workerId <= 0) {
                    System.out.println("Id can't be negative");
                    continue;
                }
                
            } catch (Exception e) {
                System.out.println("Id has to be a number");
                continue;
            }

            Empleat empleat = null;
            try {
                empleat = empleatDAO.get(workerId);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(empleat);

            System.out.println("Read another row? (y/N): ");
            String readRow = Utility.input();

            if (!Utility.confirmAnswer(readRow)) break;

        }
    }

    public static void searchWorkersByName() {
        while (true) {
            System.out.println("Write the Name of the worker you want to find: ");
            String workerName = Utility.input();


            System.out.println("Search another name? (y/N): ");
            String searchName = Utility.input();

            if (!Utility.confirmAnswer(searchName)) break;
        }

    }

    public static void deleteRowById() {
        EmpleatDAO empleatDAO = new EmpleatDAO(session);
    
        while (true) {
            System.out.println("Write the ID of the worker you want to delete: ");
            String workerIdString = Utility.input();
            int workerId = 0;
            try {

                workerId = Integer.parseInt(workerIdString);

                if (workerId <= 0) {
                    System.out.println("Id can't be negative");
                    continue;
                }
                
            } catch (Exception e) {
                System.out.println("Id has to be a number");
                continue;
            }

            Empleat empleat = null;

            try {
                empleat = empleatDAO.get(workerId);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                empleatDAO.delete(empleat);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("delete another row? (y/N): ");
            String readRow = Utility.input();

            if (!Utility.confirmAnswer(readRow)) break;

        }

    }

    public static void updateWorker() {
        EmpleatDAO empleatDAO = new EmpleatDAO(session);

        System.out.println("Write the ID of the worker you want to update: ");
        String workerIdString = Utility.input();
        int workerId = 0;
            

        while (true) {

            try {

                workerId = Integer.parseInt(workerIdString);

                if (workerId <= 0) {
                    System.out.println("Id can't be negative");
                    continue;
                }
                
            } catch (Exception e) {
                System.out.println("Id has to be a number");
                continue;
            }

            Empleat empleat = null;
            try {
                empleat = empleatDAO.get(workerId);
            } catch (Exception e) {
                
                e.printStackTrace();
            }

            System.out.println("Insert worker name (empty to not update it): ");
            String workerName = Utility.input();

            if (!workerName.isBlank()) empleat.setNom(workerName);

            System.out.println("Insert worker first surname (empty to not update it): ");
            String workerSurname = Utility.input();

            if (!workerSurname.isBlank()) empleat.setCognom1(workerSurname);

            System.out.println("Insert worker second surname (empty to not update it): ");
            String workerSurname2 = Utility.input();

            if (!workerSurname2.isBlank()) empleat.setCognom2(workerSurname2);

            System.out.println("Insert worker Identity number (DNI, empty to not update it): ");
            String workerDNI = Utility.input();
            while (true) {
                if (!workerDNI.matches("^\\d{8}[A-Z]$") && !workerDNI.isBlank()) {
                    System.out.println("Format not supported.");
                    workerDNI = Utility.input();
                } else {
                    break;
                }
            }

            if (!workerDNI.isBlank()) empleat.setDni(workerDNI);

            System.out.println("Insert worker phone number (empty to not update it): ");
            String workerPhone = Utility.input();
            while (true) {
                if (!workerPhone.matches("^\\d{9}") && !workerPhone.isBlank()) {
                    System.out.println("Format not supported.");
                    workerPhone = Utility.input();
                } else {
                    break;
                }
            }

            if (!workerPhone.isBlank()) empleat.setTelefon(workerPhone);
            
            System.out.println("Insert worker salary (0 to not update it): ");
            double workerSalaryDouble = 0;
            while (true) {
                String workerSalaryString = Utility.input();
                try {
                    

                    workerSalaryDouble = Integer.parseInt(workerSalaryString);
    
                    if (workerSalaryDouble < 0) {
                        System.out.println("Salary can't be negative");
                        continue;
                    }
                    break;
                    
                } catch (Exception e) {
                    System.out.println("Salary has to be a number");
                    continue;
                }
            }

            if (workerSalaryDouble != 0) empleat.setSou(workerSalaryDouble);

        
            try {
                empleatDAO.update(empleat);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Update another worker? (y/N): ");
            String continueInsert = Utility.input();
            if (!Utility.confirmAnswer(continueInsert)) break;
            
        }
    }
}