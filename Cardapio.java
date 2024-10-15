
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Cardapio {
    static ArrayList<ArrayList<String>> cardapio = new ArrayList<>();
    void Add() {
        String[] dias = {"DOMINGO", "SEGUNDA", "TERÇA", "QUARTA", "QUINTA", "SEXTA", "SABADO"};
        String[] diasParaMenu = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        int escolherDia = JOptionPane.showOptionDialog(null, "Escolha o Dia:\n- Domingo\n- Segunda\n- Terça\n- Quarta\n- Quinta\n- Sexta\n- Sabado", "Escolhendo Dia", 0, 3, null, diasParaMenu, diasParaMenu[0]);
        if (escolherDia == -1) return;

        String[] turnos = {"MATUTINO", "VESPERTINO", "NOTURNO"};
        String[] turnosParaMenu = {"Mat", "Verp", "Not"};
        int escolherTurno = JOptionPane.showOptionDialog(null, "Escolha o Turno:\n- Matutino\n- Vespertino\n- Noturno", "Escolhendo Turno", 0, 3, null, turnosParaMenu, turnosParaMenu[0]);
        if (escolherTurno == -1) return;

        String diaNome = dias[escolherDia];
        String turnoNome = turnos[escolherTurno];
        
        ArrayList<String> refeicaoExistente = encontrarOuCriarCardapio(diaNome, turnoNome);
        
        // Se já houver uma refeição associada, pergunta ao usuário se deseja substituir
        if (refeicaoExistente.size() > 2) {
            String op[] = {"Sim", "Não"};
            StringBuilder valorAtual = new StringBuilder("Valor Atual:\n");
            valorAtual.append("Prato Principal: " + " ".repeat(18)).append(refeicaoExistente.get(2)).append("\n");
            valorAtual.append("Salada: " +  " ".repeat(32)).append(refeicaoExistente.get(3)).append("\n");
            valorAtual.append("Acompanhamento: " +  " ".repeat(11)).append(refeicaoExistente.get(4)).append("\n");

            int continuar = JOptionPane.showOptionDialog(null, valorAtual + "\nJá possui uma refeição associada. Deseja trocar?", "Trocar:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
            if (continuar != JOptionPane.YES_OPTION) return; // Se não quiser trocar, sai do método
        }

        // Adiciona ou substitui as refeições (Prato Principal, Salada e Acompanhamento)
        for (int index = 2; index < 5; index++) {
            String complemento = index == 2 ? "ao Prato Principal" : index == 3 ? "à Salada" : "o Acompanhamento";
            String addValor = JOptionPane.showInputDialog("Adicionando " + complemento);
            if (addValor == null) {
                for (var Index = 0; Index < cardapio.size();Index++) {
                    if(cardapio.get(Index).get(0).equals(diaNome) && cardapio.get(Index).get(1).equals(turnoNome)) {
                        cardapio.remove(Index);
                        break;
                    }
                }
                return;
            }
                String valorFormatado = addValor.trim();
                if (valorFormatado.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digite algo válido.");
                    index--; // Repete a entrada para a refeição atual
                } else {
                    if (index < refeicaoExistente.size()) {
                    refeicaoExistente.set(index, valorFormatado); // Substitui a refeição existente
                } else {
                    refeicaoExistente.add(valorFormatado); // Adiciona nova refeição se não houver
                }
            }
            
        }
    }
    private ArrayList<String> encontrarOuCriarCardapio(String diaNome, String turnoNome) {
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
