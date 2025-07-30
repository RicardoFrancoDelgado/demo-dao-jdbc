package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("Testando métodos do sellerDao");

        System.out.println("=== TEST1: testando o findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST2: testando o findByDeparment ===");
        Department department = new Department(3, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST3: testando o findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST4: testando o insert ===");
        Seller newSeller = new Seller(null, "Patsy Parisi", "parisi@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted ! Seller id = " + newSeller.getId());

        System.out.println("\n=== TEST5: testando o update ===");
        seller = sellerDao.findById(1);
        seller.setName("Tony Soprano");
        seller.setEmail("tony@gmail.com");
        sellerDao.update(seller);
        System.out.println("Update Completed!");

        System.out.println("\n=== TEST6: testando o delete ===");
        System.out.print("Informe um id para que um usuário seja deletado: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");
    }
}
