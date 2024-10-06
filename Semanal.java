
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Semanal {
    Cardapio cardapio = new Cardapio();
    static ArrayList<ArrayList<String>> CardapioSemanal = new ArrayList<>();
    ValoresInicias VInicial = new ValoresInicias();
    void DaSemana() {
        VInicial.CardapioIncial(CardapioSemanal);
        var Organizar = cardapio.GetMenu();
        String Dias[] = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        Integer EscolherDia = JOptionPane.showOptionDialog(null, "Escolha o Dia:", "Escolhendo Dia", 0, 3, null, Dias, Dias[0]);
        
        if (EscolherDia == -1) {
            return;
        }
        
        String Turnos[] = {"Mat", "Verp", "Not"};
        Integer EscolherTurno = JOptionPane.showOptionDialog(null, "Escolha o Turno:", "Escolhendo Turno", 0, 3, null, Turnos, Turnos[0]);
    
        if (EscolherTurno == -1) {
            return;
        } 
    
        Semana SelecionarDia = Semana.values()[EscolherDia];
        Turno SelecionarTurno = Turno.values()[EscolherTurno];
        StringBuilder mensagem = new StringBuilder("Cardápio para " + SelecionarDia + " - " + SelecionarTurno + ":\n");
        var Tem = false;
    
        // Preencher a mensagem com os itens disponíveis
        for (var Itens : Organizar) {
            if (Itens.get(4).equals(SelecionarTurno.name()) && Itens.get(3).equals(SelecionarDia.name())) {
                Tem = true;
                Integer Index = Organizar.indexOf(Itens);
                mensagem.append(Index).append(" - ")
                        .append("Prato Principal: ").append(Itens.get(0))
                        .append(" | Salada: ").append(Itens.get(1))
                        .append(" | Acompanhamento: ").append(Itens.get(2)).append("\n");
            }
        }
    
        if (!Tem) {
            mensagem.append("Nenhum prato encontrado para o dia e turno selecionados.\n");
        }
    
        var Atribuir = JOptionPane.showInputDialog(null, mensagem + "\nInforme o Código para Adicionar:", "Adicionar Ao Cardapio Semanal", 3);
        if (Atribuir == null) {
            return; 
        }
        
        var Índice = (EscolherDia * 3) + EscolherTurno;
    
        try {
            Integer PegarIndice = Integer.parseInt(Atribuir.trim());
            if (PegarIndice < 0 || PegarIndice >= Organizar.size()) {
                throw new NumberFormatException();
            }
    
            // Pegar o valor a ser adicionado
            var PegarValor = Organizar.get(PegarIndice);
            StringBuilder AddCardapio = new StringBuilder();
            AddCardapio.append("Prato Principal: ").append(PegarValor.get(0)).append("\n")
                        .append("Salada: ").append(PegarValor.get(1)).append("\n")
                        .append("Acompanhamento: ").append(PegarValor.get(2)).append("\n");
            
            // Verifica se a lista no índice está inicializada corretamente
            if (CardapioSemanal.size() > Índice && CardapioSemanal.get(Índice).size() >= 3) {
                var Padrao = CardapioSemanal.get(Índice);
                StringBuilder ValorPadrao = new StringBuilder();
                ValorPadrao.append("Prato Principal: ").append(Padrao.get(0)).append("\n")
                        .append("Salada: ").append(Padrao.get(1)).append("\n")
                        .append("Acompanhamento: ").append(Padrao.get(2)).append("\n");
                String Trocar[] = {"Sim", "Não"};
                var Texto = "Tem certeza que deseja trocar a refeição?\n" + "Atual:\n" + ValorPadrao + "\nNovo:\n" + AddCardapio.toString();
                Integer Continuar = JOptionPane.showOptionDialog(null, Texto, "Trocando Refeição", 0, 2, null, Trocar, Trocar[0]);
                
                if (Continuar == 0) {
                    for (int Contador = 0; Contador < 3; Contador++) {
                        // Verifica se a posição existe
                        if (Contador < CardapioSemanal.get(Índice).size()) {
                            CardapioSemanal.get(Índice).set(Contador, PegarValor.get(Contador));
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Refeição trocada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Erro: O índice do cardápio semanal é inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
    
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    StringBuilder ResultadoFinal() {
        VInicial.CardapioIncial(CardapioSemanal);
        StringBuilder MontandoCardapio = new StringBuilder();
        var Espaço = " ".repeat(10);
        var Refeicao = 0;
        MontandoCardapio.append("=".repeat(38) + "\n" + Espaço + "CARDAPIO DA SEMANA\n" + "=".repeat(38)).append("\n");
        for (Integer EssaSemana = 0; EssaSemana < 7;EssaSemana++) {
            Semana SelecionarDia = Semana.values()[EssaSemana];
            MontandoCardapio.append(Espaço).append(SelecionarDia).append("\n").append("-".repeat(30)).append("\n");
            for (Integer EsteTurno = 0; EsteTurno < 3;EsteTurno++) {
                Turno SelecionarTurno = Turno.values()[EsteTurno];
                MontandoCardapio.append("\n" + Espaço +  SelecionarTurno + "\n");
                var Mensagem = "Prato Principal: " + " ".repeat(10);
                var C = 0;
                
                for (var Msn : CardapioSemanal.get(Refeicao)){
                    if(C == 1) {
                        Mensagem = "Salada: " + " ".repeat(19);
                    }else if (C == 2) {
                        Mensagem = "Acompanhamento: "  + " ".repeat(11);
                    } 
                    MontandoCardapio.append(Mensagem).append(Msn).append("\n");
                    C++;
                }
                   
                   Refeicao++; 
            }
        }
        return MontandoCardapio;
    }
    StringBuilder VerificarProgressao() {
        VInicial.CardapioIncial(CardapioSemanal);
        StringBuilder StatusAtual = new StringBuilder();
        var Espaço = " ".repeat(10);
        var Refeicao = 0;
        String Dias[] = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        Integer EscolherDia = JOptionPane.showOptionDialog(null, "Escolha o Dia:", "Escolhendo Dia", 0, 3, null, Dias, Dias[0]);
        if (EscolherDia == -1) {
            StringBuilder Encerrar = new StringBuilder("Encerrado");
            return Encerrar;
        }

        Semana SelecionarDia = Semana.values()[EscolherDia];
        StatusAtual.append(Espaço).append(SelecionarDia).append("\n").append("-".repeat(30));
            for (Integer EsteTurno = 0; EsteTurno < 3;EsteTurno++) {
                Turno SelecionarTurno = Turno.values()[EsteTurno];
                StatusAtual.append("\n" + Espaço +  SelecionarTurno + "\n");
                    
                    var Mensagem = "Prato Principal: " + " ".repeat(18);
                    var C = 0;
                
                    for (var Msn : CardapioSemanal.get(Refeicao)){
                        if(C == 1) {
                            Mensagem = "Salada: " + " ".repeat(32);
                        }else if (C == 2) {
                            Mensagem = "Acompanhamento: "  + " ".repeat(11);
                        } 
                        StatusAtual.append(Mensagem).append(Msn).append("\n");
                        C++;
                    }
                   Refeicao++; 
            }
            
        return StatusAtual;
    }

}
