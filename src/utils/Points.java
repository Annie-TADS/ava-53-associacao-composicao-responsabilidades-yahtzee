package utils;

import java.util.Comparator;

import model.Dado;

public class Points {
    private static int calculateFor(int value, List<Dado> dados) {
        int points = 0;
        for (Dado dado : dados) {
            if (dado.getValor() == 1) {
                points += dado.getValor();
            }
        }

        return points;
    }

    private static int calculateKinds(int kind, List<Dado> dados) {
        boolean sumPoints = false;
        List<Integer> values = new List<>();
        int points = 0;

        for (Dado dado : dados) {
            values.add(dado.getValor());
            points += dado.getValor();
        }


        values.sort(Comparator.naturalOrder());

        int repetition = 1;
        for (int i = 0; i< values.size(); i++) {
            if (i == 0) {
                continue;
            }
            
            if (values.get(i) == values.get(i-1)) {
                repetition++;
            } else {
                repetition = 1;
            }

            if (repetition == kind) {
                sumPoints = true;
            }
        }

        if (sumPoints) {
            return points;
        } else {
            return 0;
        }
    }

    private static int calculateStraights(int size, List<Dado> dados) {
        boolean sumPoints = false;
        List<Integer> values = new List<>();

        for (Dado dado : dados) {
            values.add(dado.getValor());
        }


        values.sort(Comparator.naturalOrder());

        int sequence = 1;
        for (int i = 0; i< values.size(); i++) {
            if (i == 0) {
                continue;
            }
            
            if (values.get(i) == (values.get(i-1) + 1)) {
                sequence++;
            } else {
                sequence = 1;
            }

            if (sequence == size) {
                sumPoints = true;
            }
        }

        if (sumPoints) {
            return size == 5 ? 40 : 30;
        } else {
            return 0;
        }
    }
    
    public static int calculateAces(List<Dado> dados) {
        return calculateFor(1, dados);
    }
    
    public static int calculateTwos(List<Dado> dados) {
        return calculateFor(2, dados);
    }
    
    public static int calculateThrees(List<Dado> dados) {
        return calculateFor(3, dados);
    }
    
    public static int calculateFours(List<Dado> dados) {
        return calculateFor(4, dados);
    }
    
    public static int calculateFives(List<Dado> dados) {
        return calculateFor(5, dados);
    }
    
    public static int calculateSixes(List<Dado> dados) {
        return calculateFor(6, dados);
    }

    public static int calculateChance(List<Dado> dados) {
        return calculateKinds(1, dados);
    }

    public static int calculateThreeOfAKind(List<Dado> dados) {
        return calculateKinds(3, dados);
    }

    public static int calculateFourOfAKind(List<Dado> dados) {
        return calculateKinds(4, dados);
    }

    public static int calculateFullHouse(List<Dado> dados) {
        boolean sumPoints = true;
        List<Integer> values = new List<>();

        for (Dado dado : dados) {
            values.add(dado.getValor());
        }
        values.sort(Comparator.naturalOrder());

        int[] fullHouseValue = {0, 0, 0, 0, 2, 3};
        int[] repetitions = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i< values.size(); i++) {
            if (i == 0) {
                continue;
            }
            
            repetitions[i]++;
        }

        //Sort the array in ascending order    
        for (int i = 0; i < repetitions.length; i++) {     
            for (int j = i+1; j < repetitions.length; j++) {     
               if(repetitions[i] > repetitions[j]) {    
                   int temp = repetitions[i];    
                   repetitions[i] = repetitions[j];    
                   repetitions[j] = temp;    
               }     
            }     
        }    

        for (int i = 0; i < repetitions.length; i++) {
            if (repetitions[i] != fullHouseValue[i]) {
                sumPoints = true;
            }
        }

        if (sumPoints) {
            return 25;
        } else {
            return 0;
        }
    }

    public static int calculateSmallStraight(List<Dado> dados) {
        return calculateStraights(4, dados);
    }

    public static int calculateLargeStraight(List<Dado> dados) {
        return calculateStraights(5, dados);
    }

    public static int calculateYahtzee(List<Dado> dados) {
        return (calculateKinds(5, dados) > 0 ? 50 : 0);
    }
}
