package com.stegemoen.timetable.db;
import com.stegemoen.timetable.model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UsersTest {
    static List<Integer> userId = new ArrayList<>();
    static User homer = new User(
            "Homer",
            "Simpson",
            "homer.simpson@moes.com",
            "TopSecretNoHumbug"
    );
    static User marge = new User(
            "Marge",
            "Simpson",
            "marge.simpson@springfield.com",
            "HomerJay_01"
    );
    static User peter = new User(
            "Peter",
            "Griffin",
            "peter.griffin@thebird.com",
            "BirdsTheWord"
    );
    static User donald = new User(
            "Donald",
            "Duck",
            "donald.duck@theangryduck.com",
            "Daisy<3"
    );
    static User daisy = new User(
            "Daisy",
            "Duck",
            "daisy@duckies.com",
            "Donald313"
    );
    @BeforeAll
    public static void addTestUsers(){
        Users u = new Users();
        userId.add(u.saveToDB(homer));
        userId.add(u.saveToDB(marge));
        userId.add(u.saveToDB(peter));
        userId.add(u.saveToDB(donald));
        userId.add(u.saveToDB(daisy));

    }

    @Test
    public void testAddUsers(){
        assertTrue( userId.get(0) >= 0
                && userId.get(1) >= 0
                && userId.get(2) >= 0
                && userId.get(3) >= 0
                && userId.get(4) >= 0);
    }

    @Test
    public void testGetUsers() throws SQLException, IOException {
        List<User> users = new Users().getUsers();
        User marge = new User(
                "Marge",
                "Simpson",
                "marge.simpson@springfield.com",
                "HomerJay_01"
        );
        assertTrue(users.contains(marge));
    }

    @Test
    public void findUserByEmail(){
        List<User> users = new Users().findValue("Email", "springfield");
        users.stream().forEach(System.out::println);
        assertTrue(users.size() > 0);
    }

    @Test
    public void findUsersByFirstname(){
        List<User> users = new Users().findValue("FirstName", "Daisy");
        users.stream().forEach(System.out::println);
        assertTrue(users.size() > 0);

    }

    @Test
    public void findUsersByLastName(){
        List<User> users = new Users().findValue("LastName", "simp");
        users.stream().forEach(System.out::println);
        assertTrue(users.size() > 0);
    }

    @Test
    public void deleteTestUser() throws IOException, SQLException{
        Users u = new Users();
        int rmId = userId.get(0);
        u.deleteUser(rmId);
        assertFalse(new Users().findUserId(rmId));
    }

    @AfterAll
    public static void deleteTestUsers() throws IOException, SQLException{
        Users u = new Users();
        u.deleteUser(userId.get(1));
        u.deleteUser(userId.get(2));
        u.deleteUser(userId.get(3));
        u.deleteUser(userId.get(4));
    }
}