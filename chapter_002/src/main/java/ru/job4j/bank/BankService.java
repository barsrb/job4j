package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccounts = users.get(user.get());
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isEmpty()) {
            return Optional.empty();
        } else {
            return users.get(user.get()).stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srsAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dstAccount = findByRequisite(destPassport, destRequisite);
        if (srsAccount.isPresent() && dstAccount.isPresent()) {
            if (srsAccount.get().getBalance() >= amount) {
                srsAccount.get().setBalance(srsAccount.get().getBalance() - amount);
                dstAccount.get().setBalance(dstAccount.get().getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}