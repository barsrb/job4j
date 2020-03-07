package ru.job4j.bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    private BankService service;

    @Before
    public void createService() {
        service = new BankService();
        User userSrc = new User("3434", "Petr Arsentev");
        User userDst = new User("2211", "Ivan Ivanov");
        service.addUser(userSrc);
        service.addUser(userDst);
        service.addAccount(userSrc.getPassport(), new Account("usr1", 150D));
        service.addAccount(userDst.getPassport(), new Account("usr2", 50D));

    }


    @Test
    public void addUser() {
        User user = new User("34345", "Petr Arsentev");
        service.addUser(user);
        assertThat(service.findByPassport("34345"), is(user));
    }

    @Test
    public void addAccount() {
        service.addAccount("3434", new Account("usr1_2", 10D));
        assertThat(service.findByRequisite("3434", "usr1_2").getBalance(), is(10D));
    }

    @Test
    public void transferMoney() {
        service.addAccount("3434", new Account("usr1_2", 10D));
        service.transferMoney("3434", "usr1", "3434", "usr1_2", 150D);
        assertThat(service.findByRequisite("3434", "usr1_2").getBalance(), is(160D));
    }

    @Test
    public void transferBetweenUsersCheckUser1() {
        service.transferMoney("3434", "usr1", "2211", "usr2", 60D);
        assertThat(service.findByRequisite("3434", "usr1").getBalance(), is(90D));
    }

    @Test
    public void transferBetweenUsersCheckUser2() {
        service.transferMoney("3434", "usr1", "2211", "usr2", 60D);
        assertThat(service.findByRequisite("2211", "usr2").getBalance(), is(110D));
    }
}