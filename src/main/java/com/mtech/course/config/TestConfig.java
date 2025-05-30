package com.mtech.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mtech.course.entities.Category;
import com.mtech.course.entities.Order;
import com.mtech.course.entities.OrderItem;
import com.mtech.course.entities.Payment;
import com.mtech.course.entities.Product;
import com.mtech.course.entities.User;
import com.mtech.course.entities.enums.OrderStatus;
import com.mtech.course.repositories.CategoryRepository;
import com.mtech.course.repositories.OrderItemRepository;
import com.mtech.course.repositories.OrderRepository;
import com.mtech.course.repositories.ProductRepository;
import com.mtech.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		User maria = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User alex = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(maria, alex));
		
		Category electronics = new Category(null, "Electronics");
		Category books = new Category(null, "Books");
		Category computers = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(electronics, books, computers));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(books);
		p2.getCategories().add(computers);
		p2.getCategories().add(electronics);
		p3.getCategories().add(computers);
		p4.getCategories().add(computers);
		p5.getCategories().add(books);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, maria);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITINING_PAYMENT, alex);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITINING_PAYMENT, alex);
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		orderRepository.save(o1);
	}
}
