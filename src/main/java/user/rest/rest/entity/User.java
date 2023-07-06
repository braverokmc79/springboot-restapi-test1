package user.rest.rest.entity;

import com.google.gson.Gson;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class User {

    private String id;
    private String name;
    private String email;

    public User(){
        this.id= UUID.randomUUID().toString();
    }

    public User(String name, String email){
        this();
        this.name=name;
        this.email=email;
    }

     public static User sample(){
        return  new User("Park", "test@gmail.com");
     }


    public static void main(String[] args) {
        User user = sample();
        user.getId();
        System.out.println(new Gson().toJson(user));
    }



}
