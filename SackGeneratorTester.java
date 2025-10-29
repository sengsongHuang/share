import java.util.ArrayList;
import java.util.Arrays;


/**
 * A class to test the functionality of the {@code Sack} and {@code SackGenerator} classes.
 * It includes tests for simple, permutation-based, and optimal sack generation methods.
 */
public class SackGeneratorTester {






  /**
   * Tests the base cases for the simple sack generator. Ensures that an empty toy list and a
   * sack already at max weight are handled correctly.
   * @return true if all base cases pass, false otherwise
   */
  public static boolean simpleSackBaseCaseTest() {
    // Base Case 1: Empty Toy List
    ArrayList<Toy> toys = new ArrayList<Toy>();
    int maxWeight = 100;
    Sack sack = new Sack();
   
    Sack ex1 = SackGenerator.simpleSack(toys, sack, maxWeight);
    if (ex1.size() != 0) {
      return false;
    }
    // Base Case 2: Existing Toy Sack already meets max weight
    Toy toy1 = new Toy("bear", 2, 35);
    Toy toy2 = new Toy("haribo candy", 3, 55);
    Toy toy3 = new Toy("china doll", 1, 10);


    sack = sack.addToy(toy1);
    sack = sack.addToy(toy2);
    sack = sack.addToy(toy3);


    Sack ex2 = SackGenerator.simpleSack(toys, sack, maxWeight);
    if (ex2.size() != 3) {
      return false;
    }


    // Base case: add infinitly
    ArrayList<Toy> toys1 = new ArrayList<Toy>();
    Sack sack2 = new Sack();


    Toy toy8 = new Toy("iPhone 17", 8, 35);
    Toy toy9 = new Toy("ps6", 9, 55);
    Toy toy7 = new Toy("a house", 7, 80);
    Toy toy6 = new Toy("swimming pool", 6, 30);


    toys1.add(toy8);
    toys1.add(toy9);
    toys1.add(toy7);
    toys1.add(toy6);


    Sack ex3 = SackGenerator.simpleSack(toys1, sack2, maxWeight);
    if (ex3.size() != 2) {
      return false;
    }
    if (ex3.getTotalWeight() != 90) {
      return false;
    }


    return true;
  }


  /**
   * Tests the simple sack generator with one toy adding to a non-empty sack. Ensures that a
   * toy fitting within the weight limit is added, and one exceeding the limit is not added.
   * @return true if all tests pass, false otherwise
   */
  public static boolean simpleSackOneStepTest() {
    // Case 1: One toy that fits
    ArrayList<Toy> toys1 = new ArrayList<Toy>();
    Sack sack1 = new Sack();
    int maxWeight = 100;


    Toy toy1 = new Toy("bear", 2, 35);
    Toy toy2 = new Toy("haribo candy", 3, 55);
    Toy toy3 = new Toy("china doll", 1, 9);


   
    toys1.add(toy3);


    sack1 = sack1.addToy(toy1);
    sack1 = sack1.addToy(toy2);
   
    Sack ex1 = SackGenerator.simpleSack(toys1, sack1, maxWeight);
    if (ex1.size() != 3) {
      System.out.println(ex1.getToys());
      return false;
    }
    // Case 2: One toy that does not fit
    ArrayList<Toy> toys2 = new ArrayList<Toy>();
    Sack sack2 = new Sack();


    Toy toy4 = new Toy("bear", 2, 35);
    Toy toy5 = new Toy("haribo candy", 3, 55);
    Toy toy6 = new Toy("china doll", 1, 30);
    Toy toy8 = new Toy("iPhone 17", 8, 35);
   


   
    toys2.add(toy6);
    toys2.add(toy8);


    sack2 = sack2.addToy(toy4);
    sack2 = sack2.addToy(toy5);


    Sack ex2 = SackGenerator.simpleSack(toys2, sack2, maxWeight);
    if (ex2.size() != 2) {
      return false;
    }
    if (ex2.getTotalWeight() > maxWeight) {
      return false;
    }


    return true;
  }


  /**
   * Tests the recursive functionality of the simple sack generator. Ensures that multiple toys
   * are added without exceeding the weight limit.
   * @return true if the recursive addition works correctly, false otherwise
   */
  public static boolean simpleSackRecursiveTest() {
    // Test Case: Multiple toys, ensuring correct recursive addition
    ArrayList<Toy> toys = new ArrayList<Toy>();
    int maxWeight = 100;
    Sack sack = new Sack();


    Toy toy1 = new Toy("bear", 2, 35);
    Toy toy2 = new Toy("haribo candy", 3, 55);
    Toy toy3 = new Toy("china doll", 1, 20);
    Toy toy8 = new Toy("iPhone 17", 8, 35);
   


    toys.add(toy2);
    toys.add(toy3);
    toys.add(toy8);


    sack = sack.addToy(toy1);
 
    Sack ex1 = SackGenerator.simpleSack(toys, sack, maxWeight);
    if (ex1.size() != 2) {
      return false;
    }
   
    return true;
  }


  /**
   * Tests the permutation generation method for toy lists. Verifies that all permutations are
   * generated correctly. You may consider checking the size of results and the size of each
   * permutation in results.
   * @return true if this tester verifies a correct functionality, false otherwise
   */
  public static boolean generatePermutationsTest() {
    // Case 1: empty toy list
    ArrayList<Toy> toys = new ArrayList<Toy>();
    ArrayList<ArrayList<Toy>> result = new ArrayList<>();


    // Case 2: normal case
    Toy toy1 = new Toy("bear", 2, 35);
    Toy toy2 = new Toy("haribo candy", 3, 55);
    Toy toy3 = new Toy("china doll", 1, 10);
    toys.add(toy1);
    toys.add(toy2);
    toys.add(toy3);


    SackGenerator.generatePermutations(toys, 0, result);
    for (int i = 0; i < result.size() - 1; i++) {
      for (int j = i + 1; j < result.size(); j++) {
        if (result.get(i).equals(result.get(j))) {
          return false;
        }
      }
    }
   
    if (result.size() != 6) {
      return false;
    }
    return true;
  }


  /**
   * Tests the permutation-based sack generation method. Ensures that multiple toys (at least
   * three) are permuted and the best sack is selected without exceeding the maximum weight.
   * @return true if the permutation-based sack is generated correctly, false otherwise
   */
  public static boolean bestPermutationSackTest() {
    // Case: Multiple toys, ensuring permutations are checked
    ArrayList<Toy> toys = new ArrayList<Toy>();


    ArrayList<ArrayList<Toy>> result = new ArrayList<>();
    // Case 2: normal case
    Toy toy1 = new Toy("bear", 2, 35);
    Toy toy2 = new Toy("haribo candy", 3, 55);
    Toy toy3 = new Toy("china doll", 1, 30);
    Toy toy4 = new Toy("wood chair", 4, 45);


    toys.add(toy1);
    toys.add(toy2);
    toys.add(toy3);
    toys.add(toy4);
   
    Sack maxSack = SackGenerator.bestPermutationSack(toys, 100);
    if (maxSack.getTotalWeight() != 100) {
      return false;
    }
    return true;
  }


  /**
   * Tests the optimal sack generation with base cases. Ensures correct handling of empty toy
   * lists and sacks already at max weight.
   * @return true if base cases are handled correctly, false otherwise
   */
  public static boolean optimalSackBaseCaseTest() {
    // Base Case 1: Empty toy list
    ArrayList<Toy> toys = new ArrayList<Toy>();
    Sack sack = new Sack();
    int maxWeight = 100;




    Sack emptyList = SackGenerator.optimalSack(toys, sack, maxWeight);
    if (emptyList.size() != 0) {
      return false;
    }




    // Base Case 2: Existing sack already meets max weight
    Toy toy1 = new Toy("bear", 2, 35);
    Toy toy2 = new Toy("haribo candy", 3, 55);
    Toy toy3 = new Toy("china doll", 1, 10);
   
    sack = sack.addToy(toy1);
    sack = sack.addToy(toy2);
    sack = sack.addToy(toy3);


    Sack fullSack = SackGenerator.optimalSack(toys, sack, maxWeight);
    if (fullSack.size() != 3) {
      return false;
    }


    // Base Case 3: add more than expected
    ArrayList<Toy> toys1 = new ArrayList<Toy>();
    Toy toy8 = new Toy("iPhone 17", 8, 35);
    Toy toy9 = new Toy("ps6", 9, 55);
    Toy toy7 = new Toy("a house", 7, 80);
    Toy toy6 = new Toy("swimming pool", 6, 30);


    toys1.add(toy8);
    toys1.add(toy9);
    toys1.add(toy6);
    toys1.add(toy7);


    Sack sack2 = new Sack();
    sack2 = sack2.addToy(toy8);
    sack2 = sack2.addToy(toy9);
    sack2 = sack2.addToy(toy7);
    sack2 = sack2.addToy(toy6);


    Sack keepAdd = SackGenerator.optimalSack(toys1, sack2, maxWeight);
    if (keepAdd.size() != 4) {
      return false;
    }


    return true;
  }


  /**
   * Tests the optimal sack generation method with one-step cases adding to a non-empty sack.
   * Ensures that a toy fitting within the maximum weight is added, and a toy exceeding the
   * limit is not added.
   * @return true if the optimal sack handles one-step cases correctly, false otherwise
   */
  public static boolean optimalSackOneStepTest() {
    // Case 1: One toy that fits
    ArrayList<Toy> toys = new ArrayList<Toy>();
    Sack sack = new Sack();
    int maxWeight = 100;


    Toy toy1 = new Toy("bear", 2, 35);
    Toy toy2 = new Toy("haribo bear", 3, 55);
    Toy toy3 = new Toy("china doll", 1, 9);
    Toy toy4 = new Toy("peppa pig", 4, 80);


    toys.add(toy3);
    toys.add(toy4);


    sack = sack.addToy(toy1);
    sack = sack.addToy(toy2);


    Sack fitToy = SackGenerator.optimalSack(toys, sack, maxWeight);
    if (fitToy.size() != 3) {
      return false;
    }
    // Case 2: One toy that does not fit




    ArrayList<Toy> toys1 = new ArrayList<Toy>();
    Sack sack1 = new Sack();


    Toy toy8 = new Toy("iPhone 17", 8, 35);
    Toy toy9 = new Toy("ps6", 9, 55);
    Toy toy7 = new Toy("a house", 7, 80);


    toys1.add(toy7);


    sack1 = sack1.addToy(toy8);
    sack1 = sack1.addToy(toy9);


    Sack notFitToy = SackGenerator.optimalSack(toys1, sack1, maxWeight);
    if (notFitToy.size() != 2) {
      return false;
    }
   
    return true;
  }


  /**
   * Tests the optimal sack generation method with multiple toys. Ensures that recursive
   * backtracking selects the best sack without exceeding the maximum weight.
   * @return true if the optimal sack is generated correctly, false otherwise
   */
  public static boolean optimalSackRecursiveTest() {
    // Case: Multiple toys, ensuring permutations are checked
    ArrayList<Toy> toys = new ArrayList<Toy>();
    Sack sack = new Sack();
    int maxWeight = 100;


    Toy toy1 = new Toy("bear", 2, 35);
    Toy toy2 = new Toy("haribo bear", 3, 55);
    Toy toy3 = new Toy("china doll", 1, 9);
    Toy toy4 = new Toy("peppa pig", 4, 80);


    toys.add(toy3);
    toys.add(toy4);
    toys.add(toy1);
    toys.add(toy2);


    Sack ex1 = SackGenerator.optimalSack(toys, sack, maxWeight);
    if (ex1.getTotalWeight() != 89) {
      return false;
    }
    if (ex1.size() != 2) {
      return false;
    }


    return true;
  }


  /**
   * The main method runs all test cases for the sack generator.
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    System.out.println("-----------------------------------------------------------");
    System.out.println(
        "simpleSackBaseCaseTest: " + (simpleSackBaseCaseTest() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println(
        "simpleSackOneStepTest: " + (simpleSackOneStepTest() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println(
        "simpleSackRecursiveTest: " + (simpleSackRecursiveTest() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println(
        "generatePermutationsTest: " + (generatePermutationsTest() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println("bestPermutationSackTest: "
        + (bestPermutationSackTest() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println(
        "optimalSackBaseCaseTest: " + (optimalSackBaseCaseTest() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out
        .println("optimalSackOneStepTest: " + (optimalSackOneStepTest() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println(
        "optimalSackRecursiveTest: " + (optimalSackRecursiveTest() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
  }
}

