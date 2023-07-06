package user.rest.rest.service.logic;


import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import user.rest.rest.entity.User;
import user.rest.rest.service.UserService;



@SpringBootTest
@Slf4j
public class UserServiceLogicTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    public void startUp(){

    }

    @Test
    public void registerTest(){
        User sample=User.sample();

        log.info(" sample  {} ", sample.toString());
        assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(1);
    }



}