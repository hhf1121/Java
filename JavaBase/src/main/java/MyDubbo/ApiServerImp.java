package MyDubbo;

import Pojo.User;

public class ApiServerImp implements ApiServer {
    @Override
    public User getUser(Long id) {
        User user=new User();
        user.setId(id);
        user.setName("hhf");
        user.setSex("man");
        return user;
    }
}
