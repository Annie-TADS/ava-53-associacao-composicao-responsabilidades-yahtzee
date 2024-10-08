package model;

public class Round {
  public static final int FIRST = 1;
  public static final int SECOND = 2;
  public static final int THIRD = 3;
  public static final int FOURTH = 4;
  public static final int FIFTH = 5;
  public static final int SIXTH = 6;
  public static final int SEVENTH = 7;
  public static final int EIGTH = 8;
  public static final int NINTH = 9;
  public static final int TENTH = 10;
  public static final int ELEVENTH = 11;
  public static final int TWELFTH = 12;
  public static final int THIRTEENTH = 13;

  private Choice[] choices = new Choice[2];
  
  public Round(Choice choicePlayer1, Choice choicePlayer2) {
    this.choices[0] = choicePlayer1;
    this.choices[1] = choicePlayer2;
  }

  public Choice[] getChoices() {
    return choices;
  }

  public Choice getChoice(int playerNumber) {
    return choices[playerNumber-1];
  }

  public Choice getChoice(Player player) {
    if (choices[0].getPlayer().equals(player)) {
      return getChoice(1);
    } else if (choices[1].getPlayer().equals(player)) {
      return getChoice(2);
    } else {
      return null;
    }
  }
}
