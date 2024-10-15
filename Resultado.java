

import java.util.Arrays;

public class Resultado extends Cardapio {
     StringBuilder ResultadoFinal() {
        StringBuilder resultadoFinal = new StringBuilder();
        if (!cardapio.isEmpty()) {
            resultadoFinal.append("=".repeat(35)).append("\n")
                      .append(" ".repeat(10)).append("CARDÁPIO SEMANAL").append("\n")
                      .append("=".repeat(35)).append("\n");

            // Ordenar cardápio por dia da semana
            cardapio.sort((a, b) -> {
                String[] diasDaSemana = {"DOMINGO", "SEGUNDA", "TERÇA", "QUARTA", "QUINTA", "SEXTA", "SABADO"};
                String[] Turnos = {"MATUTINO", "VESPERTINO", "NOTURNO"};
                int diaA = Arrays.asList(diasDaSemana).indexOf(a.get(0));
                int diaB = Arrays.asList(diasDaSemana).indexOf(b.get(0));
                if (diaA != diaB) {
                    return Integer.compare(diaA, diaB);
                }
            
                int turnoA = Arrays.asList(Turnos).indexOf(a.get(1));
                int turnoB = Arrays.asList(Turnos).indexOf(b.get(1));
            
                return Integer.compare(turnoA, turnoB);
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
                    resultadoFinal.append(" ".repeat(10)).append(turnoAtual).append("\n");
                }
            
                resultadoFinal.append("Prato Principal: ").append(" ".repeat(4)).append(refeicao.get(2)).append("\n")
                            .append("Salada: ").append(" ".repeat(13)).append(refeicao.get(3)).append("\n")
                            .append("Acompanhamento: ").append(" ".repeat(5)).append(refeicao.get(4)).append("\n");
        }
        }
        

        return resultadoFinal;
    }
}
