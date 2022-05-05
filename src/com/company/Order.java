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

  public void setAmount(int amount){
    this.amount = amount;
  }

  public void setPrice(double price){
    this.price = price;
  }

  public void setState(String state){
    this.state = state;
  }

  public String toString(){
    return amount + ", " + price + ", " + state;
  }
}
