package Expense_Tracker;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Expense> expenses = ExpenseStorage.loadExpenses();

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expenses:");
            System.out.println("2. Update Expenses:");
            System.out.println("3. Delete Expenses:");
            System.out.println("4. View All Expenses");
            System.out.println("5. View Summary of All Expenses:");
            System.out.println("6. View Summary of a specific month:");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    addExpense(scanner, expenses);
                    break;
                case 2:
                    updateExpense(scanner, expenses);
                    break;
                case 3:
                    deleteExpense(scanner, expenses);
                    break;
                case 4:
                    viewAllExpenses( expenses);
                    break;
                case 5:
                    viewSummary(expenses);
                    break;
                case 6:
                    viewMonthlySummary(scanner, expenses);
                    break;
                case 7:
                    ExpenseStorage.saveExpenses(expenses);
                    System.out.println("Expenses saved. Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. please try again");

            }
        }
    }

    private static void addExpense(Scanner scanner, ArrayList<Expense> expenses) {
        System.out.print("Enter date (YYYY-MM-DD)");
        String Date = scanner.nextLine();
        System.out.print("Enter Description ");
        String Description = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble()
        scanner.nextLine();
        System.out.println("enter category");

        String category = scanner.nextLine();
        expenses.add(new Expense(Date, Description, amount, category));
        System.out.println("expense added. ");

    }

    private static void updateExpense(Scanner scanner, ArrayList<Expense> expenses) {
        System.out.print("Enter the index of the expense to update: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < expenses.size()) {
            System.out.print("enter new date (yyyy-mm-dd):");
            String date = scanner.nextLine();
            System.out.print("Enter new description:");
            String description = scanner.nextLine();
            System.out.print("Enter new amount:");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("enter new category:");
            String category = scanner.nextLine();
            expenses.set(index, new Expense(date, description, amount, category));
        } else {
            System.out.println("Invalid index.");
        }
    }



    private static void deleteExpense(Scanner scanner, ArrayList < Expense > expenses){
        System.out.print("enter index of the expense to delete");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index > 0 && index < expenses.size()) {
            expenses.remove(index);
            System.out.println("expense deleted");
        } else {
            System.out.println("invalid index");

        }


    }

    private static void viewAllExpenses (ArrayList < Expense > expenses) {
        for (int i = 0; i < expenses.size(); i++) {
            System.out.print(i + ":" + expenses.get(i));

        }


    }
    private static void viewSummary (ArrayList < Expense > expenses) {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        System.out.println("total expenses:" + total);
    }
    private static void viewMonthlySummary(Scanner scanner, ArrayList<Expense> expenses){
        System.out.print("Enter Month (MM): ");
        String month = scanner.nextLine();
        double total =0;
        for (Expense e: expenses){
            if (e.getDate().substring(5,7).equals(month)){
                total += e.getAmount();
            }
        }
        System.out.println("total expenses for month : " + month +":" +total);
    }

}



