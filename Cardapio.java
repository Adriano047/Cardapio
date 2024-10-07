import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Cardapio {
    static ArrayList<ArrayList<String>> cardapio = new ArrayList<>();

    void Add() {
        String[] dias = {"DOMINGO", "SEGUNDA", "TERÇA", "QUARTA", "QUINTA", "SEXTA", "SABADO"};
        String[] dia = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        int escolherDia = JOptionPane.showOptionDialog(null, "Escolha o Dia:\n-Segunda\n-Terça\n-Quarta\n-Quinta\n-Sexta\n-Sabado", "Escolhendo Dia", 0, 3, null, dia, dia[0]);
        if (escolherDia == -1) return;

        String[] turnos = {"MATUTINO", "VESPERTINO", "NOTURNO"};
        String[] turno = {"Mat", "Vesp", "Not"};
        int escolherTurno = JOptionPane.showOptionDialog(null, "Escolha o Turno:\n-Matutino\nVespertino-\n-Noturno", "Escolhendo Turno", 0, 3, null, turno, turno[0]);
        if (escolherTurno == -1) return;

        String diaNome = dias[escolherDia];
        String turnoNome = turnos[escolherTurno];
        ArrayList<String> novaLista = findOrCreateCardapioEntry(diaNome, turnoNome);

        for (int i = 2; i < 5; i++) {
            String complemento = i == 2 ? "ao Prato Principal" : (i == 3 ? "à Salada" : "o Acompanhamento");
            String addValor = JOptionPane.showInputDialog("Adicionando " + complemento);
            if (addValor == null) {
                return;
            }
            String format = addValor.trim();
            if (format.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite Algo");
                i--; // Decrementa para tentar novamente
            } else {
                if (i < novaLista.size()) {
                    novaLista.set(i, format);
                } else {
                    novaLista.add(format);
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
        ArrayList<String> novaLista = new ArrayList<>();
        novaLista.add(diaNome);
        novaLista.add(turnoNome);
        cardapio.add(novaLista); // Adiciona uma nova lista ao cardápio
        return novaLista; // Retorna a nova lista
    }

    StringBuilder ResultadoFinal() {
        StringBuilder ResultadoFinal = new StringBuilder();
        ResultadoFinal.append("=".repeat(35) + "\n" + " ".repeat(10) + "CARDAPIO SEMANA\n" + "=".repeat(35)).append("\n");
        
        ArrayList<String[]> Organizar = new ArrayList<>();
        
        // Preencher Organizar com as refeições
        for (var Refeicao : cardapio) {
            String dia = Refeicao.get(0);
            String turno = Refeicao.get(1);
            String pratoPrincipal = Refeicao.get(2);
            String salada = Refeicao.get(3);
            String acompanhamento = Refeicao.get(4);
            
            Organizar.add(new String[]{dia, turno, pratoPrincipal, salada, acompanhamento});
        }
        
        // Ordenar por dia da semana
        String[] diasDaSemana = {"DOMINGO", "SEGUNDA", "TERÇA", "QUARTA", "QUINTA", "SEXTA", "SABADO"};
        Organizar.sort((a, b) -> {
            int indexA = Arrays.asList(diasDaSemana).indexOf(a[0]);
            int indexB = Arrays.asList(diasDaSemana).indexOf(b[0]);
            return Integer.compare(indexA, indexB);
        });
    
        // Construir o resultado final
        String diaAtual = "";
        String turnoAtual = "";
        
        for (var Refeicao : Organizar) {
            if (!Refeicao[0].equals(diaAtual)) {
                if (!diaAtual.isEmpty()) {
                    ResultadoFinal.append("\n"); // Adiciona espaço entre dias
                }
                diaAtual = Refeicao[0];
                ResultadoFinal.append(" ".repeat(10) + diaAtual + "\n" + "-".repeat(35) + "\n");
                turnoAtual = ""; // Resetar turno ao mudar de dia
            }
            
            if (!Refeicao[1].equals(turnoAtual)) {
                if (!turnoAtual.isEmpty()) {
                    ResultadoFinal.append("\n"); // Adiciona espaço entre turnos
                }
                turnoAtual = " ".repeat(14) + Refeicao[1];
                ResultadoFinal.append("Turno: " + turnoAtual + "\n");
            }
            
            ResultadoFinal.append("Prato Principal: " + " ".repeat(4) + Refeicao[2] + "\n");
            ResultadoFinal.append("Salada: " + " ".repeat(13) + Refeicao[3]  + "\n");
            ResultadoFinal.append("Acompanhamento: " + " ".repeat(5)+ Refeicao[4]   + "\n");
        }
        
        return ResultadoFinal;
    }
    
}
