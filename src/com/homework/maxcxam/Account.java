package com.homework.maxcxam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Account {
    private double balance = 10000;
    public Ops ops;
    private static int accountId = 1;
    private static int operationId = 1;
    private int user;
    public static Map<Integer, Map<Integer, Operation>> accountOperations = new HashMap<>();

    Account() {
        startPlayWithAccount();
        this.user = accountId;
        Account.accountId++;
    }

    private void startPlayWithAccount() {
        Map<Integer, Operation> operations = new HashMap<>();
        Scanner in = new Scanner(System.in);
        do {
            System.out.printf("Your balance is %5.2f, choose operation :%n", balance);
            System.out.println("1 - Withdraval");
            System.out.println("2 - Refill");
            System.out.println("3 - Payment");
            Ops operation = choosedOperation(in.nextInt());
            if(operation !=null){
                System.out.printf("Input sum please for %s:", operation.name());
                double sum = in.nextDouble();
                Operation userOperation = new Operation(operation,sum);
                operations.put(Account.operationId, userOperation);
                Account.operationId++;
                balance = operation.execute(sum, balance);
                System.out.println("Operation ok!! your balance = " + balance);
                System.out.println("anouther operation? (y/n)");
                if(in.next().equalsIgnoreCase("y"))
                    continue;
                break;
            } else {
                System.out.println("wrong operation!");
                System.out.println("maybe again?");
                if(in.next().equalsIgnoreCase("y"))
                    continue;
            }
            break;
        } while(true);
        Account.accountOperations.put(accountId, operations);

    }

    private static Map<Integer, Operation> allOperation(int userId) {
        return Account.accountOperations.get(userId);
    }

    private Ops choosedOperation(int i) {
        switch (i) {
            case 1:
                return Ops.WITHDRAWAL;
            case 2:
                return Ops.REFILL;
            case 3:
                return Ops.PAYMENT;
            default:
                return null;
        }
    }

    private class Operation {
        Ops typeOfOperation;
        double sum;

        Operation(Ops ops, double sum) {
            this.typeOfOperation = ops;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return String.format("Operation #%s - sum = %s", typeOfOperation.name(), sum);
        }
    }

    public static void main(String[] args) {
        Account acc =new Account();
        System.out.println("Your balance is " + acc.balance);
        System.out.println("Do you want to see all your operations?");
        if(new Scanner(System.in).next().equalsIgnoreCase("Y"))
            for(Map.Entry<Integer, Operation> item: Account.accountOperations.get(acc.user).entrySet())
                System.out.println(item.getValue());
    }
}


