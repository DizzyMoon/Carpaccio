package com.company;

public class Order {
  private int amount;
  private double price;
  private String state;

  public Order(int amount, double price, String state){
    this.amount = amount;
    this.price = price;
    this.state = state;
  }

  public int getAmount(){
    return amount;
  }

  public double getPrice(){
    return price;
  }

  public String getState(){
    return state;
  }

  public String toString(){
    return amount + ", " + price + ", " + state;
  }
}
