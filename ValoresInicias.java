
import java.util.ArrayList;
import java.util.Arrays;

public class ValoresInicias {
    public ArrayList<ArrayList<String>> CardapioIncial(ArrayList<ArrayList<String>> CardapioSemanal ) {
        if (CardapioSemanal.isEmpty()) {
            for (var i = 0; i < 21; i++) {
                CardapioSemanal.add(new ArrayList<>());
               
            } 
              // Domingo
        CardapioSemanal.get(0).addAll(Arrays.asList("Omelete", "Salada de frutas", "Torradas"));
        CardapioSemanal.get(1).addAll(Arrays.asList("Arroz com feijão", "Salada Caesar", "Farofa"));
        CardapioSemanal.get(2).addAll(Arrays.asList("Lasanha", "Salada de legumes", "Pão de alho"));

        // Segunda-feira
        CardapioSemanal.get(3).addAll(Arrays.asList("Panquecas", "Salada de rúcula", "Mel"));
        CardapioSemanal.get(4).addAll(Arrays.asList("Frango grelhado", "Salada de tomate", "Purê de batata"));
        CardapioSemanal.get(5).addAll(Arrays.asList("Pizza de calabresa", "Salada grega", "Azeitonas"));

        // Terça-feira
        CardapioSemanal.get(6).addAll(Arrays.asList("Iogurte com granola", "Salada de abacate", "Frutas da estação"));
        CardapioSemanal.get(7).addAll(Arrays.asList("Estrogonofe de carne", "Salada de alface", "Arroz"));
        CardapioSemanal.get(8).addAll(Arrays.asList("Sopa de legumes", "Salada de beterraba", "Pão francês"));

        // Quarta-feira
        CardapioSemanal.get(9).addAll(Arrays.asList("Cereal com leite", "Salada de cenoura", "Bananinha"));
        CardapioSemanal.get(10).addAll(Arrays.asList("Quibe assado", "Salada de grão-de-bico", "Tabule"));
        CardapioSemanal.get(11).addAll(Arrays.asList("Peixe grelhado", "Salada de repolho", "Quinoa"));

        // Quinta-feira
        CardapioSemanal.get(12).addAll(Arrays.asList("Smoothie de frutas", "Salada de espinafre", "Castanhas"));
        CardapioSemanal.get(13).addAll(Arrays.asList("Hamburguer caseiro", "Salada coleslaw", "Batata frita"));
        CardapioSemanal.get(14).addAll(Arrays.asList("Macarrão à bolonhesa", "Salada de pepino", "Queijo ralado"));

        // Sexta-feira
        CardapioSemanal.get(15).addAll(Arrays.asList("Pão com queijo", "Salada de frutas", "Café"));
        CardapioSemanal.get(16).addAll(Arrays.asList("Tacos", "Salada de milho", "Guacamole"));
        CardapioSemanal.get(17).addAll(Arrays.asList("Sushi", "Salada de algas", "Molho shoyu"));

        // Sábado
        CardapioSemanal.get(18).addAll(Arrays.asList("Waffles", "Salada de morango", "Mel"));
        CardapioSemanal.get(19).addAll(Arrays.asList("Risoto de frango", "Salada de palmito", "Batata assada"));
        CardapioSemanal.get(20).addAll(Arrays.asList("Churrasco", "Salada mista", "Vinagrete"));

        } return CardapioSemanal;
    }
}
