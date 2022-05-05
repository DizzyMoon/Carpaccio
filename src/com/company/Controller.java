package com.company;

import java.util.Locale;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
  private ArrayList<Order> orderList = new ArrayList<Order>();
  private Scanner sc = new Scanner(System.in);
  private boolean running;

  public void run() {
    running = true;

    while (this.running) {
      displayMenu();
      int input = sc.nextInt();
      sc.nextLine();

      switch (input) {
        case 1 -> addOrder();
        case 2 -> displayOrderList();
        case 4 -> exit();
      }
    }
  }

  public double orderDiscount(String state) {
    state = state.toUpperCase(Locale.ROOT);
    double discount = 0;

    switch (state) {
      case "UT" -> discount = 6.85;
      case "NV" -> discount = 8.00;
      case "TX" -> discount = 6.25;
      case "AL" -> discount = 4.00;
      case "CA" -> discount = 8.25;
    }
    System.out.println(discount);
    return discount;

  }

  private void addOrder() {

    System.out.print("Type amount: ");
    int amount = sc.nextInt();
    sc.nextLine();
    System.out.print("Type price: ");
    double price = sc.nextDouble();
    sc.nextLine();
    System.out.print("Type state: ");
    String state = sc.nextLine();

    addToOrderList(amount, price, state);
  }

  public void addToOrderList(int amount, double price, String state) {
    orderList.add(new Order(amount, price, state));
  }

  public void displayMenu() {
    System.out.print("""
        ----------MENU--------------
        1 - Add new Order
        2 - Display Orders
        3 - Exit
                
        input: """);

  }

  public void displayOrderList() {
    double priceSum = 0;
    int counter = 0;
    for (Order order : orderList) {
      priceSum = priceSum + order.getPrice() * order.getAmount();
      System.out.println("Order nr. " + counter + " - " + order);
      counter++;
    }
    System.out.println("TOTAL PRICE - " + priceSum);
  }

  private void exit() {
    this.running = false;
  }
}
