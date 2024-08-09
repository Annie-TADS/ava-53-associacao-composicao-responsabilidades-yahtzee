package model;

public class Player {
  public static final int ONE = 1;
  public static final int TWO = 2;

  private final String name;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

}
