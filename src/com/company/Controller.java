package com.company;

import java.util.Locale;

public class Controller {

  public void run(){
    boolean running = true;
    while (running){

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
}
