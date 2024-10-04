
import javax.swing.JOptionPane;

public class Semanal {
    Cardapio cardapio = new Cardapio();
    void DaSemana() {
        var Organizar = cardapio.GetMenu();
        var Tamanho = Organizar;
        String Dias[] = {"Dom", "Seg", "Ter","Qua","Qui","Sex", "Sab"};
        Integer EscolherDia = JOptionPane.showOptionDialog(null, "Escolha o Turno:\n- Domingo\n- Segunda\n- Terça\n- Quarta\n- Quinta\n- Sexta\n- Sabado", "Escolhendo Dia", 0, 3, null, Dias, Dias[0]);
        String Turnos[] = {"Mat", "Verp", "Not"};
        Integer EscolherTurno = JOptionPane.showOptionDialog(null, "Escolha o Turno:\n- Matutino\n- Vespertino\n- Noturno", "Escolhendo Turno", 0, 3, null, Turnos, Turnos[0]);
        if (EscolherDia == -1 || EscolherTurno == -1) {
            return;
        } 
        Semana SelecionarDia = Semana.values()[EscolherDia];
        Turno SelecionarTurno = Turno.values()[EscolherTurno];
        StringBuilder mensagem = new StringBuilder("Cardápio para " + SelecionarDia + " - " + SelecionarTurno + ":\n");
        var Tem = false;
        for (var Itens : Tamanho) {
            
            for (var I = 0; I < Itens.size(); I++ ) {
                if (Itens.get(4).equals(SelecionarTurno.name()) && Itens.get(3).equals(SelecionarDia.name())) {
                        Tem = true;
                        mensagem.append("Prato Principal: ").append(Itens.get(0))
                        .append("| Salada: ").append(Itens.get(1))
                        .append("| Acompanhamento: ").append(Itens.get(2)).append("\n");
                        break;
                } 
            }
        }
        
        if (!Tem) {
            mensagem.append("Nenhum prato encontrado para o dia e turno selecionados.").append("\n");
        }
        var Atribuir = JOptionPane.showInputDialog(null, mensagem + "\nInforme o Codigo para Adicionar:\n", "Adicionar Ao Cardapio semanal", 3);

    }
    String ResultadoFinal() {
        return "RTE";
    }
}
