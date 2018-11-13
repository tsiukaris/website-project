package com.studying.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {




//		Customer andrew = new Customer("Andrew", "12", "12@mail.ru", "1200", "123456");
//		Customer clementine = new Customer("Clementine", "56", "56@mail.ru", "5600", "5656789");
//
//		Product phone = new Product("OnePlus 6 64Gb", "electronics", "smartphone", 30000, 10);
//		Product tesla = new Product("Tesla Model S", "vehicles", "Electric car", 2500000, 10);
//		Product apple = new Product("Apple", "fruits", "Red apple", 50, 100);
//		Product pen = new Product("Pen", "office", "WaterMan", 15000, 20);
//
//
////		//CLEMENTINE
////		Orders clementineOrder = new Orders();
////		List<Orders> clementineorders = new ArrayList<>();
////		List<OrderedProduct> clemordprod = new ArrayList<>();
////		OrderedProduct ordprod = new OrderedProduct();
////		Product prod = new Product();
////		ordprod.setProduct(prod);
////		clemordprod.add(ordprod);
////		clementineOrder.setOrderedProductList(clemordprod);
////		clementineorders.add(clementineOrder);
////		clementine.setOrders(clementineorders);
////		//CLEMENTINE
//
////		OrderedProduct orTesla = new OrderedProduct(1);
////		orTesla.setProduct(tesla);
//
////		OrderedProduct orPen = new OrderedProduct(2);
////		OrderedProduct orApple = new OrderedProduct(5);
//
////		orPen.setProduct(pen);
////		orPhone.setProduct(phone);
////		orApple.setProduct(apple);
//
//		OrderedProduct orPhone = new OrderedProduct(1);
//		orPhone.setProduct(phone);
//
//		//Andrew
//		Orders andrewOrder = new Orders();
//
//		orPhone.setOrders(andrewOrder);
//
//		List<OrderedProduct> andrewOrdProdList = new ArrayList<>();
//
//		List<OrderedProduct> teslalist = new ArrayList<>();
//		tesla.setOrderedProducts(teslalist);
////		List<OrderedProduct> phonelist = new ArrayList<>();
////		phone.setOrderedProducts(phonelist);
////		List<OrderedProduct> applelist = new ArrayList<>();
////		apple.setOrderedProducts(applelist);
////		List<OrderedProduct> penlist = new ArrayList<>();
////		pen.setOrderedProducts(penlist);
//
////		orTesla.setOrders(andrewOrder);
////		orPen.setOrders(andrewOrder);
////		orPhone.setOrders(andrewOrder);
//
//
//
////		andrewOrdProdList.add(orTesla);
////		andrewOrdProdList.add(orPen);
////		andrewOrdProdList.add(orPhone);
//
//
//
//
//		andrewOrder.setOrderedProductList(andrewOrdProdList);
//		andrewOrder.setCustomer(andrew);
//		List<Orders> andreworderlsit = new ArrayList<>();
//		andreworderlsit.add(andrewOrder);
//		andrew.setOrders(andreworderlsit);


//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("1");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		et.begin();
//		em.persist(phone);
//		em.persist(pen);
//		em.persist(apple);
//		em.persist(tesla);
//		em.persist(andrew);
//		em.persist(clementine);
//		et.commit();
//		em.close();
//		emf.close();
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer () {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

}
