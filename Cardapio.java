import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Cardapio {
    static ArrayList<ArrayList<String>> cardapio = new ArrayList<>();

    void Add() {
        String[] dias = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        int escolherDia = JOptionPane.showOptionDialog(null, "Escolha o Dia:", "Escolhendo Dia", 0, JOptionPane.INFORMATION_MESSAGE, null, dias, dias[0]);
        if (escolherDia == -1) return;

        String[] turnos = {"Mat", "Verp", "Not"};
        int escolherTurno = JOptionPane.showOptionDialog(null, "Escolha o Turno:", "Escolhendo Turno", 0, JOptionPane.INFORMATION_MESSAGE, null, turnos, turnos[0]);
        if (escolherTurno == -1) return;

        String diaNome = dias[escolherDia];
        String turnoNome = turnos[escolherTurno];
        
        ArrayList<String> refeicaoExistente = findOrCreateCardapioEntry(diaNome, turnoNome);
        
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
            if (addValor == null) return; // Se o usuário cancelar, encerra o método

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

    private ArrayList<String> findOrCreateCardapioEntry(String diaNome, String turnoNome) {
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

    StringBuilder ResultadoFinal() {
        StringBuilder resultadoFinal = new StringBuilder();
        resultadoFinal.append("=".repeat(35)).append("\n")
                      .append(" ".repeat(10)).append("CARDÁPIO SEMANAL").append("\n")
                      .append("=".repeat(35)).append("\n");

        // Ordenar cardápio por dia da semana
        cardapio.sort((a, b) -> {
            String[] diasDaSemana = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
            return Integer.compare(Arrays.asList(diasDaSemana).indexOf(a.get(0)), Arrays.asList(diasDaSemana).indexOf(b.get(0)));
        });

        // Construir o resultado final
        String diaAtual = "";
        String turnoAtual = "";

        for (var refeicao : cardapio) {
            if (!refeicao.get(0).equals(diaAtual)) {
                if (!diaAtual.isEmpty()) {
                    resultadoFinal.append("\n"); // Adiciona espaço entre dias
                }
                diaAtual = refeicao.get(0);
                resultadoFinal.append(" ".repeat(10)).append(diaAtual).append("\n").append("-".repeat(35)).append("\n");
                turnoAtual = ""; // Resetar turno ao mudar de dia
            }
            
            if (!refeicao.get(1).equals(turnoAtual)) {
                if (!turnoAtual.isEmpty()) {
                    resultadoFinal.append("\n"); // Adiciona espaço entre turnos
                }
                turnoAtual = refeicao.get(1);
                resultadoFinal.append("Turno: ").append(" ".repeat(14)).append(turnoAtual).append("\n");
            }
            
            resultadoFinal.append("Prato Principal: ").append(" ".repeat(4)).append(refeicao.get(2)).append("\n")
                          .append("Salada: ").append(" ".repeat(13)).append(refeicao.get(3)).append("\n")
                          .append("Acompanhamento: ").append(" ".repeat(5)).append(refeicao.get(4)).append("\n");
        }

        return resultadoFinal;
    }
}
