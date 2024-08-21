package model;

import enums.Category;
import utils.List;
import utils.Points;

public class Choice {
    private final Category category;
    private final Player player;
    private final List<Dado> dados = new List<>();

    public Choice(Category category, Player player) {
        this.category = category;
        this.player = player;

        for (int i = 0; i<5; i++) {
            Dado dado = new Dado();
            
            dado.joga();

            dados.add(dado);
        }
    } 

    public Choice(Category category, Player player, int roundNumber) {
    
        this.category = category;
        this.player = player;

        for (int i = 0; i<5; i++) {
            Dado dado = new Dado();
            
            dado.rigForPedro(player, roundNumber);

            dados.add(dado);
        }
    }

    public Category getCategory() {
        return category;
    }

    public Player getPlayer() {
        return player;
    }

    public int getPoints() {
        switch (category) {
            case ACES:
                return Points.calculateAces(dados);
            case TWOS:
                return Points.calculateTwos(dados);
            case THREES:
                return Points.calculateThrees(dados);
            case FOURS:
                return Points.calculateFours(dados);
            case FIVES:
                return Points.calculateFives(dados);
            case SIXES:
                return Points.calculateSixes(dados);
            case CHANCE:
                return Points.calculateChance(dados);
            case THREE_OF_A_KIND:
                return Points.calculateThreeOfAKind(dados);
            case FOUR_OF_A_KIND:
                return Points.calculateFourOfAKind(dados);
            case FULL_HOUSE:
                return Points.calculateFullHouse(dados);
            case SMALL_STRAIGHT:
                return Points.calculateSmallStraight(dados);
            case LARGE_STRAIGHT:
                return Points.calculateLargeStraight(dados);
            case YAHTZEE:
                return Points.calculateYahtzee(dados);
            default:
                return 0;
        }
    }
}
