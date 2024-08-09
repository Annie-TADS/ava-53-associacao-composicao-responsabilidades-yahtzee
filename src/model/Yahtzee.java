package model;

import java.util.List;

public class Yahtzee {
  private Player[] players = new Player[2];
  private boolean gameFinished = false;
  private int winner = -1;
  private List<Round> rounds;

  public Yahtzee(Player player1, Player player2) {
    this.players[0] = player1;
    this.players[1] = player2;
    rounds = new List();
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
}
