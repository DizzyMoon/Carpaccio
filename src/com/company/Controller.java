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
  public double orderDiscount(String state){
    state = state.toUpperCase(Locale.ROOT);
    double discount = 0;

    switch (state){
      case "UT" ->	discount = 6.85;
      case "NV" ->  discount = 8.00;
      case "TX" ->  discount = 6.25;
      case "AL" ->  discount = 4.00;
      case "CA"	->  discount = 8.25;
    }
    System.out.println(discount);
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
