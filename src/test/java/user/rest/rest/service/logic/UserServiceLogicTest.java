package user.rest.rest.service.logic;


import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
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


    private User kim;

    private User lee;


    @BeforeEach
    public void startUp(){
        log.info(" startUp 시작");
        this.kim =new User("kim", "kim@gmail.com");
        this.lee=new User("Lee", "lee@gmail.com");
        userService.register(this.kim);
        userService.register(this.lee);
    }


    @Test
    public void registerTest(){
        User sample=User.sample();
        log.info(" sample  {} ", sample.toString());
        assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(3);

        //then
        this.userService.remove(sample.getId());
    }


    @Test
    public void find(){
        assertThat(this.userService.find(lee.getId())).isNotNull();
        assertThat(this.userService.find(lee.getId()).getEmail()).isEqualTo(lee.getEmail());
    }

    @AfterEach
    public void cleanUp(){
        this.userService.remove(kim.getId());
        this.userService.remove(lee.getId());
    }



}