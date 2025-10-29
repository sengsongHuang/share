import java.util.ArrayList;


/**
 * A class to represent a sack containing a list of toys. It supports adding toys, calculating
 * the total weight, and generating a formatted summary of the toys.
 */
public class Sack {
  /**
    * List of toys in the sack.
    */
  private ArrayList<Toy> toys;


  /**
    * Total weight of all toys in the sack, in grams.
    */
  private int totalWeight;


  /**
    * Constructs an empty {@code Sack}.
    */
  public Sack() {
    this.toys = new ArrayList<>();
    this.totalWeight = 0;
  }


  /**
    * Constructs a new {@code Sack} with the specified toys and total weight. This constructor
    * is private and used internally for creating non-empty sacks.
    *
    * @param toys         the list of toys in the sack. We assume toys is not null.
    * @param totalWeight  the total weight of the sack in grams. We assume totalWeight > 0
    */
  private Sack(ArrayList<Toy> toys, int totalWeight) {
    this.toys = new ArrayList<>(toys);
    this.totalWeight = totalWeight;
  }


  /**
    * Returns a copy of the list of toys in the sack.
    * @return a list of toys in the sack
    */
  public ArrayList<Toy> getToys() {
    return new ArrayList<>(toys);
  }


  /**
    * Returns the number of toys in the sack.
    * @return the number of toys in the sack
    */
  public int size() {
    return this.getToys().size();
  }


  /**
    * Returns the total weight of all toys in the sack, in grams.
    * @return the total weight of the sack in grams
    */
  public int getTotalWeight() {
    return totalWeight;
  }


  /**
    * Determines if a toy can be added to the sack without exceeding the specified maximum
    * weight.
    * @param toy        the toy to check. We assume toy is not null.
    * @param maxWeight  the maximum allowed weight for the sack. We assume maxWeight > 0
    * @return if the toy can be added without exceeding the maximum weight
    */
  public boolean canAddToy(Toy toy, int maxWeight) {
    return (totalWeight + toy.getWeight()) <= maxWeight;
  }


  /**
    * Creates a new {@code Sack} by adding the specified toy. This method returns a new sack
    * instance, leaving the original sack unchanged.
    * @param toy the toy to add to the sack. We assume toy is not null.
    * @return a new {@code Sack} containing the original toys plus the added toy
    */
  public Sack addToy(Toy toy) {
    ArrayList<Toy> newtoys = new ArrayList<>(toys);
    newtoys.add(toy);
    return new Sack(newtoys, totalWeight + toy.getWeight());
  }


  /**
    * Returns a string representation of the sack, including a summary of the toys and the total
    * weight.
    * @return a formatted string representing the sack
    */
  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("List of Toys in Santa's Sack");
    sb.append("-------------------------\n");
    for (int i = 0; i < toys.size(); i++) {
      Toy toy = toys.get(i);
      sb.append((i + 1) + ". " + toys.get(i).toString() + "\n");
    }
    sb.append("-------------------------\n");
    sb.append("Total weight: " + totalWeight + " grams\n");
    sb.append("Merry Christmas!\n");
    return sb.toString();
  }


  /**
    * Compares the specified object with this sack for equality. Returns true if and only if the
    * specified object is also a sack, both sacks have the same weight and have equal list
    * of toys.
    * @param o the object to be compared for equality with this sack
    * @return true if the specified object is equal to this sack
    */
  @Override public boolean equals(Object o) {
    // ensure o is instance of sack
    if (o instanceof Sack) {
      Sack otherSack = (Sack)o;
      // ensure both sacks have the same weight and have equal list of toys (both list
      // of toys have the same size and elements in the two list of toys are equal).
      if (this.totalWeight == otherSack.totalWeight && this.toys.size() == otherSack.size()) {
        for (Toy toy : this.toys) {
          if (!otherSack.toys.contains(toy)) {
            return false; // different sacks
          }
        }
        return true; // equal sacks
      }
    }
    return false; // o is not a sack or sacks do not have equal weights and equal list of toys
  }
}

