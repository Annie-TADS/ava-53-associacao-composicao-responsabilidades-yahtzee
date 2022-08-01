# 5.3 // Associação, Composição e Responsabilidade // Yahtzee

Use este link do GitHub Classroom para ter sua cópia alterável deste repositório: <https://classroom.github.com/a/-92rs0aE>

Implementar respeitando os fundamentos de Orientação a Objetos.

**Tópicos desta atividade:** associações, composição, atribuição de responsabilidades, coesão.

---

Implementar o jogo Yahtzee conforme especificação em <http://en.wikipedia.org/wiki/Yahtzee#Rules>. Não implementar as opções extras, apenas as 13 categorias básicas.

A classe `Yahtzee` deve ter cinco instâncias de [Dado](src/model/Dado.java) internamente, para proceder a aleatoriedade das jogadas.

Os Casos de Teste podem ser alterados para coincidir com sua lógica e fluxo de execução na interação com o jogo.

Importante: está uma atividade sobre divisão de responsabilidades, portanto esteja seguro(a) de criar classes auxiliares e métodos auxiliares para abrigar lógicas reusáveis ou específicas.



```java
// instanciando jogadores
Player pedro = new Player("Pedro");
Player ana = new Player("Ana");

System.out.println(pedro.getName().equals("Pedro"));
System.out.println(ana.getName().equals("Ana"));

// instanciando um jogo  (estado pré-jogo)
Yahtzee game = new Yahtzee(pedro, ana);
System.out.println(game.isFinished() == false);
System.out.println(game.getWinner() == null);
System.out.println(game.getPlayer(1).equals(pedro));
System.out.println(game.getPlayer(2).equals(ana));


// sem rounds ainda
System.out.println(game.getRounds().empty() == true);
// sem escolhas ainda
System.out.println(game.getPlayerChoices(1).empty() == true);
System.out.println(game.getPlayerChoices(2).empty() == true);


/*
Escrever os métodos para a interação com o Jogo,
que envolve rolar os dados e submeter categorias (ver #rules).

Escrever os testes que validam o fluxo do algoritmo.

Os testes a seguir podem ser modificados, mas não eliminados,
eles servem para atestar o estado pós-jogo.
*/


System.out.println(game.isFinished() == true);

// pelo número do player
System.out.println(game.getPlayerPoints(1) > 0);
System.out.println(game.getPlayerPoints(2) > 0);

// pelo player
System.out.println(game.getPlayerPoints(pedro) > 0);
System.out.println(game.getPlayerPoints(ana) > 0);

// para consistência
System.out.println(game.getPlayerPoints(pedro) == game.getPlayerPoints(1)));

System.out.println(game.getPlayerPoints(1) >  game.getPlayerPoints(2));

// considere que Pedro ganhou
System.out.println(pedro.equals(game.getWinner()));
// e que ana perdeu
System.out.println(ana.equals(game.getLoser()));



int round = 1;

// pontos por player number e round
System.out.println(game.getPlayerPoints(1, round) > 0);
// pontos por player number pode ser pela constante
System.out.println(Player.ONE == 1);
System.out.println(game.getPlayerPoints(Player.ONE, round) > 0);
// pontos por player e round
System.out.println(game.getPlayerPoints(pedro, round) > 0);
System.out.println(game.getPlayerPoints(2, round) > 0);
// pontos por player e round com constantes
System.out.println(Round.FIFTH == 5);
System.out.println(game.getPlayerPoints(Player.TWO, Round.TENTH) > 0);



// Category is an Enum
System.out.println(Category.ACES instanceof Enum);

// pontos por player number e category
System.out.println(game.getPlayerPoints(1, Category.FULL_HOUSE) > 0);
// pontos por player e category
System.out.println(game.getPlayerPoints(pedro, Category.FULL_HOUSE) > 0);
System.out.println(game.getPlayerPoints(2, Category.TWOS) > 0);

// Pedro's choices // java.util.List
List<Choice> choices = game.getPlayerChoices(1);

// sempre 13 rounds se jogo terminado
System.out.println(choices.count() == 13);

Choice pedrosChoiceOne = choices.first();
// considere que Pedro escolheu ACES no primeiro round
System.out.println(pedrosChoiceOne.getCategory().equals(Category.ACES));
// e ganhou pelo menos um ponto
System.out.println(pedrosChoiceOne.getPoints() > 0);

List<Round> rounds = System.out.println(game.getRounds());
// sempre 13 rounds para terminar o jogo
System.out.println(rounds.count() == 13);

// décimo terceiro round
Round lastRound = rounds.last();
// última escolha de Pedro (pelo player number)
Choice lastAnasChoice = lastRound.getChoice(2);
// última escolha de Pedro (pelo player)
Choice lastPedrosChoice = lastRound.getChoice(pedro);

// não pode ser ACES porque foi a primeira escolha
System.out.println( ! lastPedrosChoice.getCategory().equals(Category.ACES));
// para consistência
System.out.println(pedrosChoiceOne.equals(rounds.first().getChoice(pedro));
```


### Referências:

* General <http://pt.wikipedia.org/wiki/General_%28jogo%29>
* Regras do Jogo General (megajogos) <http://www.megajogos.com.br/jogosonline/general/regras>
* General On-line (megajogos) <http://www.megajogos.com.br/jogosonline/general>
