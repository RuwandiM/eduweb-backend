package eduweb.eduweb_backend.service;

import eduweb.eduweb_backend.model.User;

public interface UserService {

    // concrete methods
    public String createUser(User User);
    public User getUser(String Id);

}
