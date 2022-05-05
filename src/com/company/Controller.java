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
  public double calculateTax(Order order){
    String state = order.getState();

    state = state.toUpperCase(Locale.ROOT);
    double tax = 0;

    switch (state){
      case "UT" ->	tax = 6.85;
      case "NV" ->  tax = 8.00;
      case "TX" ->  tax = 6.25;
      case "AL" ->  tax = 4.00;
      case "CA"	->  tax = 8.25;
    }
    return tax;

  }
public void displayTax(Order order){
  System.out.println(calculateTax(order));
}
public double calculateDiscount(Order order){
    double discount = 0;
    double orderValue = order.getAmount() + order.getPrice();

    if (1000 <= orderValue && orderValue < 5000){
      discount = 3;
    } else if (5000 <= orderValue && orderValue < 7000){
      discount = 5;
    } else if (7000 <= orderValue && orderValue < 10000){
      discount = 7;
    }

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
    double discountedPrice;
    double taxedPrice;
    for (Order order : orderList) {
      discountedPrice = calculateDiscount(order);
      order.setPrice(discountedPrice);
      taxedPrice = calculateTax(order);
      order.setPrice(taxedPrice);
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
