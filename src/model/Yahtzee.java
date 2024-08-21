package model;

import enums.Category;
import utils.List;

public class Yahtzee {
  private Player[] players = new Player[2];
  private boolean gameFinished = false;
  private int winner = -1;
  private List<Round> rounds;

  public Yahtzee(Player player1, Player player2) {
    this.players[0] = player1;
    this.players[1] = player2;
    rounds = new List<Round>();
  }

  public boolean isFinished() {
    return gameFinished;
  }

  public Player getWinner() {
    if (winner == -1) {
      return null;
    } else {
      return players[winner];
    }
  }

  public Player getLoser() {
    switch (winner) {
      case 0:
        return players[1];
      case 1:
        return players[0];
      default:
        return null;
    }
  }

  public Player getPlayer(int i) {
    if (i <= players.length) {
      return players[i-1];
    } else {
      return null;
    }
  }

  public List<Round> getRounds() {
    return rounds;
  }

  public List<Choice> getPlayerChoices(int playerNumber) {
    List<Choice> choices = new List<>();
    for (Round round : rounds) {
      choices.add(round.getChoice(playerNumber));
    }

    return choices;
  }

  public int getPlayerPoints(int playerNumber) {
    int points = 0;
    for (Round round : rounds) {
      points += round.getChoice(playerNumber).getPoints();
    }

    return points;
  }

  public int getPlayerPoints(Player player) {
    return getPlayerPoints(getPlayerNumber(player));
  }

  public int getPlayerPoints(int player, int round) {
    return rounds.get(round-1).getChoice(player).getPoints();
  }

  public int getPlayerPoints(Player player, int round) {
    return getPlayerPoints(getPlayerNumber(player), round);
  }

  public int getPlayerPoints(int player, Category category) {
    for (Round round : rounds) {
      Choice choice = round.getChoice(player);

      if (choice.getCategory().equals(category)) {
        return choice.getPoints();
      }
    }

    return 0;
  } 

  public int getPlayerPoints(Player player, Category category) {
    return getPlayerPoints(getPlayerNumber(player), category);
  }

  public void autoGame() {
    for (int i = 0; i<13; i++) {
      nextRound();
    }
  }

  public void nextRound() {
    Category category;
    int roundNumber = rounds.size()+1;

    switch (roundNumber) {
      case 1:
        category = Category.ACES;
        break;
      case 2:
        category = Category.TWOS;
        break;
      case 3:
        category = Category.THREES;
        break;
      case 4:
        category = Category.FOURS;
        break;
      case 5:
        category = Category.FIVES;
        break;
      case 6:
        category = Category.SIXES;
        break;
      case 7:
        category = Category.CHANCE;
        break;
      case 8:
        category = Category.THREE_OF_A_KIND;
        break;
      case 9:
        category = Category.FOUR_OF_A_KIND;
        break;
      case 10:
        category = Category.FULL_HOUSE;
        break;
      case 11:
        category = Category.SMALL_STRAIGHT;
        break;
      case 12:
        category = Category.LARGE_STRAIGHT;
        break;
      case 13:
        category = Category.YAHTZEE;
        break;
      default:
        return;
      }

      Choice playerOneChoice = new Choice(category, players[0], roundNumber);
      Choice playerTwoChoice = new Choice(category, players[1], roundNumber);

      rounds.add(new Round(playerOneChoice, playerTwoChoice));

      if (rounds.size() == 13) {
        finishGame();
      }
  }

  private int getPlayerNumber(Player player) {
    if (players[0].equals(player)) {
      return 1;
    } else if (players[1].equals(player)) {
      return 2;
    } else {
      return -1;
    }
  }

  private void finishGame() {
    gameFinished = true;
    
    if (getPlayerPoints(1) > getPlayerPoints(2)) {
      winner = 0;
    } else if (getPlayerPoints(2) > getPlayerPoints(1)) {
      winner = 1;
    }
  }
}
