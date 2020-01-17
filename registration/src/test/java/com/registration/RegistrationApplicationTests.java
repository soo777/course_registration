package com.registration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.registration.model.User;
import com.registration.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class RegistrationApplicationTests {

	@Autowired
    UserRepository userRepository;
	
	
	@Test
    public void testCustomerRepository(){
//        User user = User.builder().id("qqqqq").password("qqqqq").build();
//        userRepository.save(user);

        List<User> customerList = userRepository.findAll();

//        User chris = customerList.get(0);
//        assertThat(chris.getId(), is("크리스"));
//        assertThat(chris.getPassword(), is("123123"));
    }

}
