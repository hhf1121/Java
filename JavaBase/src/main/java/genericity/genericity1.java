package genericity;

import Pojo.User;

public class genericity1 implements MyGenericity<User>{
    @Override
    public User getT(User user) {
        return user;
    }
}
