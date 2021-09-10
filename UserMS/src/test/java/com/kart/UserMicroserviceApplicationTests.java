package com.kart;

import static org.hamcrest.CoreMatchers.any;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kart.user.UserApplication;
import com.kart.user.dto.BuyerDTO;
import com.kart.user.dto.LoginDTO;
import com.kart.user.repository.BuyerRepository;
import com.kart.user.repository.SellerRepository;
import com.kart.user.service.BuyerService;
import com.kart.user.service.SellerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = UserApplication.class)
public class UserMicroserviceApplicationTests {


	@Mock
	BuyerRepository buyerRepo;
	@Mock
	SellerRepository sellerRepo;

	@InjectMocks
	BuyerService buyerService =  new BuyerService();
	
	@InjectMocks
	SellerService sellerService =  new SellerService();

	@Test
	public void authenticateBuyerTestValidCredentials() throws Exception {
		LoginDTO buyer = new LoginDTO();
		buyer.setEmail("Cristiano_cr7@gmail.com");
		buyer.setPassword("Cristiano@cr7");
		//Mockito.when(buyerRepo.findByEmail("Cristiano_cr7@gmail.com")).thenReturn(buyer);
		boolean actual = buyerService.login(buyer);
		Assertions.assertThat(actual);
	} 
	
	@Test
	public void authenticateBuyerTestInValidCredentials() throws Exception {
		LoginDTO customer = new LoginDTO();
		customer.setEmail("Cristiano_cr7@gmail.com");
		customer.setPassword("Cristiano@LM10");
		//Mockito.when(buyerRepo.findByEmail("Cristiano_cr7@gmail.com")).thenReturn(buyer);
		boolean actual = buyerService.login(customer);
		Assertions.assertThat(!actual);
	} 

	@Test
	public void authenticateSellerTestValidCredentials() throws Exception {
		LoginDTO seller = new LoginDTO();
		seller.setEmail("MarcusRashford@gmail.com");
		seller.setPassword("Rashford@MR10");
		//Mockito.when(buyerRepo.findByEmail("MarcusRashford@gmail.com")).thenReturn(seller);
		boolean actual = sellerService.login(seller);
		Assertions.assertThat(actual);
	} 
	
	@Test
	public void authenticateSellerTestInValidCredentials() throws Exception {
		LoginDTO customer = new LoginDTO();
		customer.setEmail("MarcusRashford@gmail.com");
		customer.setPassword("Rashford@EC21");
		//Mockito.when(buyerRepo.findByEmail("MarcusRashford@gmail.com")).thenReturn(buyer);
		boolean actual = buyerService.login(customer);
		Assertions.assertThat(!actual);
	} 
}

