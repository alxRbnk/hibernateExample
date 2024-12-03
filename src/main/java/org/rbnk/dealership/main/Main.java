package org.rbnk.dealership.main;

import org.rbnk.dealership.service.CarService;
import org.rbnk.dealership.service.CarShowroomService;
import org.rbnk.dealership.service.CategoryService;
import org.rbnk.dealership.service.ClientService;
import org.rbnk.dealership.service.ReviewService;
import org.rbnk.dealership.service.impl.CarServiceImpl;
import org.rbnk.dealership.service.impl.CarShowroomServiceImpl;
import org.rbnk.dealership.service.impl.CategoryServiceImpl;
import org.rbnk.dealership.service.impl.ClientServiceImpl;
import org.rbnk.dealership.service.impl.ReviewServiceImpl;
import org.rbnk.dealership.util.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("Car");
        EntityManagerUtil entityManagerUtil = new EntityManagerUtil(entityManagerFactory);
        EntityManager entityManager = entityManagerUtil.createEntityManager();

        CarService carService = new CarServiceImpl(entityManager);
        CarShowroomService carShowroomService = new CarShowroomServiceImpl(entityManager);
        CategoryService categoryService = new CategoryServiceImpl(entityManager);
        ClientService clientService = new ClientServiceImpl(entityManager);
        ReviewService reviewService = new ReviewServiceImpl(entityManager);

//        Car car = new Car();
//        carService.saveCar(car);
//        Car car = new Car();
//        car.setModel("new model");
//        car.setId(1);
//        carService.updateCar(car);
//        carService.deleteCar(4L);
//        carService.getCarById(6L);
//        carService.getAllCars().forEach(System.out::println);
//        carShowroomService.getAllCarShowrooms();
//        carShowroomService.addCarToShowroom(6L,1L);
//        Category category = new Category();
//        category.setName("cabriolet");
//        categoryService.saveCategory(category);
//        Client client = new Client();
//        clientService.saveClient(client);
//        Review review = new Review();
//        review.setText("The worst car");
//        reviewService.saveReview(review);
//        clientService.assignCarToClient(6L,1L);

        entityManager.close();
        entityManagerUtil.close();

    }
}