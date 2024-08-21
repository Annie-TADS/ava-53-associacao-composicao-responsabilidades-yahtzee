package model;

/**
 * Representa um Dado regular de 6 faces com 6 numeros de 1 a 6.
 *
 * @author Marcio Torres
 */
public class Dado {

  private int valor = 1;

  /**
   * joga o dado eventualmente mudando seu valor
   */
  public void joga() {
    valor = (int) (Math.random() * 6 + 1);
  }

  public void rigForPedro(Player player, int roundNumber) {
    if (player.getName().equals("Pedro")) {
      if (roundNumber < 5) {
        this.valor = roundNumber;
      } else {
       this.valor = 6;
      }
    } else {
      this.valor = 1;
    }
  }
  /**
   * obtem o valor da face superior do dado
   *
   * @return o valor de 1 a 6 presente na face superior
   */
  public int getValor() {
    return valor;
  }

  @Override
  public String toString() {
    return String.valueOf(valor);
  }
}
