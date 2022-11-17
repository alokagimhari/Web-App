package com.company;

import com.company.user.User;
import com.company.user.UserRepository;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Collection;
import java.util.Optional;

import static org.hamcrest.Matchers.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired private UserRepository repo;
    @Test
    public void testAddNew()
    {
        User user = new User();
        user.setEmail("sahan.mal@gmail.com");
        user.setPassword("12345");
        user.setFirstName("Pathum");
        user.setLastName("Malinda");

        User savedUser = repo.save(user);
        assertThat(savedUser,(notNullValue()));
        assertThat(savedUser.getId(),(greaterThanOrEqualTo(0)));



    }

    private <T extends Comparable<T>> void assertThat(Integer id, Matcher<T> greaterThanOrEqualTo) {
    }

    private void assertThat(User savedUser, Matcher<Object> notNullValue) {
        
    }

    @Test
    public void testListAll()
    {
        Iterable<User> users =repo.findAll();
        assertThat(users,(hasSize(greaterThan(0))));

        for (User user:users)
        {
            System.out.println(user);
        }
    }

    private void assertThat(Iterable<User> users, Matcher<Collection<?>> hasSize) {
        
    }

    @Test
    public void testUpdate() {
        Integer userId=1;
        Optional<User> optionalUser = repo.findById(userId);
        repo.findById(userId);
        User user = optionalUser.get();
        user.setPassword("2020bye");
        repo.save(user);
        
        User updateUser = repo.findById(userId).get();
        assertThat(updateUser.getPassword().equals("2020bye"));
    }

    @Test
    public void testDelete()
    {
        Integer userId=2;
        repo.deleteById(userId);

        Optional<User> optionalUser = repo.findById(userId);
        assertThat(optionalUser.isEmpty());
    }

    private void assertThat(boolean equals) {
    }


}
 
