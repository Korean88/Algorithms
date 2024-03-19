package com.home.companies;

import java.util.*;

public class BankAccountOperations {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.performOperation(Operation.CREATE, 3000.0, "acc3");
        bank.performOperation(Operation.CREATE, 1000.0, "acc1");
        bank.performOperation(Operation.CREATE, 2000.0, "acc2");
        bank.performOperation(Operation.SHOW_ALL, null);

        System.out.println();

        bank.performOperation(Operation.TRANSFER, 1000.0, "acc3", "acc1");
        bank.performOperation(Operation.SHOW_BALANCE, null, "acc1");
        bank.performOperation(Operation.SHOW_BALANCE, null, "acc3");
        bank.performOperation(Operation.TRANSFER, 300.0, "acc3", "acc2");
        bank.performOperation(Operation.SHOW_BALANCE, null, "acc3");
        bank.performOperation(Operation.SHOW_BALANCE, null, "acc2");

        System.out.println();
        bank.performOperation(Operation.SHOW_ALL, null);
    }

    private enum Operation {
        CREATE,
        TRANSFER,
        SHOW_BALANCE,
        SHOW_ALL
    }

    private static class Bank {
        private Set<Account> accounts = new HashSet<>();

        void performOperation(Operation operation, Double amount, String... names) {
            switch (operation) {
                case CREATE:
                    accounts.add(new Account(names[0], amount));
                    break;
                case TRANSFER:
                    Account accountFrom = find(accounts, names[0]);
                    Account accountTo = find(accounts, names[1]);
                    if (accountFrom.getAmount() >= amount) {
                        accountFrom.amount -= amount;
                        accountTo.amount += amount;
                    } else {
                        System.out.println("Overdraft");
                    }
                    break;
                case SHOW_BALANCE:
                    Account account = find(accounts, names[0]);
                    if (account != null) {
                        System.out.println(names[0] + ": $" + account.getAmount());
                    }
                    break;
                case SHOW_ALL:
                    List<Account> accountsSorted = new ArrayList<>(accounts);
                    Collections.sort(accountsSorted, (a1, a2) -> {
                        double amount1 = a1.amount;
                        double amount2 = a2.amount;
                        return Double.compare(amount1, amount2);
                    });
                    System.out.println(accountsSorted);
                    break;
                default:
                    break;
            }
        }

        private Account find(Set<Account> accounts, String name) {
            return accounts.stream()
                    .filter(a -> name.equals(a.getName()))
                    .findAny()
                    .orElse(null);
        }

    }

    private static class Account {
        private String name;
        private double amount;

        Account(String name, Double amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public double getAmount() {
            return amount;
        }

        public String toString() {
            return name + ": $" + amount;
        }
    }
}
