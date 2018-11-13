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
