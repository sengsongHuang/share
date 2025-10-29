/*
 * Author: Chiao Han Huang
 * Email: chuang456@wisc.edu
 * Course: COMP SCI 300 FA2025
 * Assignment: 08Program
 * Citations: No help given or recieved.
 */


import java.util.ArrayList;
// No additional imports are allowed


public class SackGenerator {


  public static Sack simpleSack(ArrayList<Toy> toys, Sack sack, int maxWeight) {
   
    if (toys.size() == 0) {
      return sack;
    }


    if (sack.getTotalWeight() >= maxWeight) {
      return sack;
    }


    if (sack.canAddToy(toys.get(0), maxWeight)) {
      sack = sack.addToy(toys.get(0));
      toys.remove(0);
      return simpleSack(toys, sack, maxWeight);
    } else {
      toys.remove(0);
      return simpleSack(toys, sack, maxWeight);
    }
  }


 


  public static void generatePermutations(ArrayList<Toy> toys, int index,
      ArrayList<ArrayList<Toy>> result) {


    if (toys.size() == 0) {
      return;
    }
    if (index < 0) {
      return;
    }


    if (index == toys.size()) {
      result.add(new ArrayList<Toy>(toys));
      return;
    }
   
    for (int i = index; i < toys.size(); i++) {
      Toy temp = toys.get(index);
      toys.set(index, toys.get(i));
      toys.set(i, temp);


      generatePermutations(toys, index + 1, result);


      toys.set(i, toys.get(index));
      toys.set(index, temp);
    }


  }


  public static Sack bestPermutationSack(ArrayList<Toy> toys, int maxWeight) {
    ArrayList<ArrayList<Toy>> result = new ArrayList<ArrayList<Toy>>();
    generatePermutations(toys, 0, result);


    int maxVal = 0;
    Sack maxSack = null;


    if (toys.size() == 0) {
      Sack sack1 = new Sack();
      maxSack = simpleSack(toys, sack1, maxWeight);
    }


    for (ArrayList<Toy> t: result) {
      Sack sack = new Sack();
      Sack possible = simpleSack(t, sack, maxWeight);
      if (possible.getTotalWeight() >= maxVal) {
        maxVal = possible.getTotalWeight();
        maxSack = possible;
      }
    }
    return maxSack;
  }


  public static Sack optimalSack(ArrayList<Toy> toys, Sack sack, int maxWeight) {
   
    if (toys.size() == 0) {
      return sack;
    }
    if (sack.getTotalWeight() == maxWeight) {
      return sack;
    }


    Sack result1 = sack;
    Sack result2 = sack;
    if (!sack.canAddToy(toys.get(0), maxWeight)) {
      toys.remove(0);
      result1 = optimalSack(toys, sack, maxWeight);
     
    } else {
      sack = sack.addToy(toys.get(0));
      toys.remove(0);
      result2 = optimalSack(toys, sack, maxWeight);
    }


    if (result1.getTotalWeight() > result2.getTotalWeight()) {
      return result1;
    } else {
      return result2;
    }
  }


}

