import java.util.Objects;


/**
 * A class to represent a toy with a name, ID number, and weight.
 */
public class Toy {
   
  /**
   * Name of the toy.
   */
  private String name;


  /**
   * id number of the toy.
   */
  private int id;


  /**
   * weight of the toy in grams.
   */
  private int weight;


  /**
   * Constructs a new toy object with the specified name, ID number, and weight.
   * @param name   the name of the toy
   * @param id     the id of the toy
   * @param weight the weight of the toy in grams
   */
  public Toy(String name, int id, int weight) {
    this.name = name;
    this.id = id;
    this.weight = weight;
  }


  /**
   * Returns the name of the toy.
   * @return the name of the toy
   */
  public String getName() {
    return name;
  }


  /**
   * Returns the id of the toy.
   * @return the ID number of the toy
   */
  public int getID() {
    return id;
  }


  /**
   * Returns the weight of the toy in grams.
   * @return the weight of the toy in grams
   */
  public int getWeight() {
    return weight;
  }


  /**
   * Returns a string representation of the toy, including its name, id, and weight.
   * @return a string representation of the toy
   */
  @Override
  public String toString() {
    return "(" + name + " | id: " + id + " | weight: " + weight + "g)";
  }


  /**
   * Compares this toy to the specified object for equality. Two toys are considered equal if they
   * have the same name, id, and weight, ignoring case differences in the name.
   * @param anObject the object to compare with
   * @return if the given object represents a toy with exactly the same properties
   */
  @Override
  public boolean equals(Object anObject) {
    if (anObject instanceof Toy) {
      Toy t = (Toy) anObject;
      return this.name.equalsIgnoreCase(t.name) && this.id == t.id && this.weight == t.weight;
    }
    return false;
  }
}

