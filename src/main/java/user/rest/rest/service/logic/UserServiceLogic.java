package user.rest.rest.service.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user.rest.rest.entity.User;
import user.rest.rest.service.UserService;
import user.rest.rest.store.UserStore;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceLogic  implements UserService {

    private final UserStore userStore;

//    public UserServiceLogic(UserStore userStore){
//        this.userStore=userStore;
//    }


    @Override
    public String register(User newUser) {
        return userStore.create(newUser);
    }



    @Override
    public void modify(User newUser) {
         userStore.update(newUser);
    }

    @Override
    public void remove(String id) {
        this.userStore.delete(id);
    }

    @Override
    public User find(String id) {
        return this.userStore.retrieve(id);
    }

    @Override
    public List<User> findAll() {
        return this.userStore.retrieveAll();
    }
}
