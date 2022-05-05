package com.company;

import java.util.Locale;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
  private ArrayList<Order> orderList = new ArrayList<Order>();
  private boolean running = true;
  private Scanner sc = new Scanner(System.in);
  

  public void run() {

    while (running) {
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


  private void addOrder(){
    int amount = sc.nextInt();
    sc.nextLine();
    double price = sc.nextDouble();
    sc.nextLine();
    String state = sc.nextLine();

    addToOrderList(amount, price, state);
  }

  public void addToOrderList(int amount, double price, String state) {
    orderList.add(new Order(amount, price, state));
  }

  public void displayOrderList(){
    for (Order order : orderList){
      System.out.println(order);
    }
  }

  private void exit() {
    running = false;
  }
}
