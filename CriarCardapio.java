package V2;

import java.util.ArrayList;

public class CriarCardapio extends Cardapio {
    ArrayList<String> encontrarOuCriarCardapio(String diaNome, String turnoNome) {
        for (ArrayList<String> item : cardapio) {
            if (item.get(0).equals(diaNome) && item.get(1).equals(turnoNome)) {
                return item; // Retorna a lista existente
            }
        }
        // Cria uma nova entrada se não houver
        ArrayList<String> novaLista = new ArrayList<>();
        novaLista.add(diaNome);
        novaLista.add(turnoNome);
        cardapio.add(novaLista); // Adiciona uma nova lista ao cardápio
        return novaLista; // Retorna a nova lista
    }
}
