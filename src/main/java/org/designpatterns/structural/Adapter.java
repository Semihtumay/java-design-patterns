package org.designpatterns.structural;


/*
    The Adapter pattern is used for connecting two incompatible interfaces
    that otherwise cannot be connected directly. An Adapter wraps an existing
    class with a new interface so that it becomes compatible with the interface needed.
 */

public class Adapter {
    static class LegacyUser{
        Integer id;
        String name;
        String surname;
    }

    interface LegacyUserService{
        LegacyUser getLegacyUser(Integer id);
    }

    static class User{
        Integer id;
        String name;
        String surname;
        String email;
        String location;
        Boolean isActive;
    }

    interface UserService{
        User getUser(String email);
    }

    static class UserServiceAdapter implements UserService{
        UserService userService;
        LegacyUserService legacyUserService;
        @Override
        public User getUser(String email) {
            User user = userService.getUser(email);
            LegacyUser legacyUser = legacyUserService.getLegacyUser(user.id);
            user.name = legacyUser.name;
            user.surname = legacyUser.surname;

            return user;
        }
    }
    public void adapterDemo(){
        UserService userService = new UserServiceAdapter();
        User user = userService.getUser("email@email.com");
        System.out.println(user);
    }

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.adapterDemo();
    }
}
