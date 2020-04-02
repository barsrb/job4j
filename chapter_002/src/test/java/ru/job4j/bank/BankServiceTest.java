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
        assertThat(service.findByPassport("34345").get(), is(user));
    }

    @Test
    public void addAccount() {
        service.addAccount("3434", new Account("usr1_2", 10D));
        assertThat(service.findByRequisite("3434", "usr1_2").get().getBalance(), is(10D));
    }

    @Test
    public void transferMoney() {
        service.addAccount("3434", new Account("usr1_2", 10D));
        service.transferMoney("3434", "usr1", "3434", "usr1_2", 150D);
        assertThat(service.findByRequisite("3434", "usr1_2").get().getBalance(), is(160D));
    }

    @Test
    public void transferBetweenUsersCheckUser1() {
        service.transferMoney("3434", "usr1", "2211", "usr2", 60D);
        assertThat(service.findByRequisite("3434", "usr1").get().getBalance(), is(90D));
    }

    @Test
    public void transferBetweenUsersCheckUser2() {
        service.transferMoney("3434", "usr1", "2211", "usr2", 60D);
        assertThat(service.findByRequisite("2211", "usr2").get().getBalance(), is(110D));
    }

    @Test
    public void transferBetweenUsersFailedNoMoney() {
        boolean resultOfTransfer = service.transferMoney("3434", "usr1", "2211", "usr2", 600D);
        assertFalse(resultOfTransfer);
    }

    @Test
    public void transferBetweenUsersFailedNoFirstUser() {
        boolean resultOfTransfer = service.transferMoney("None", "usr1", "2211", "usr2", 60D);
        assertFalse(resultOfTransfer);
    }

    @Test
    public void transferBetweenUsersFailedNoSecondUser() {
        boolean resultOfTransfer = service.transferMoney("3434", "usr1", "None", "usr2", 60D);
        assertFalse(resultOfTransfer);
    }

    @Test
    public void transferBetweenUsersFailedNoFirstUserAccount() {
        boolean resultOfTransfer = service.transferMoney("3434", "none", "2211", "usr2", 60D);
        assertFalse(resultOfTransfer);
    }

    @Test
    public void transferBetweenUsersFailedNoSecondUserAccount() {
        boolean resultOfTransfer = service.transferMoney("3434", "usr1", "2211", "none", 60D);
        assertFalse(resultOfTransfer);
    }
}