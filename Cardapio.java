
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Cardapio {
    static ArrayList<ArrayList<String>> Cardapio = new ArrayList<>();
    void Add() {
        ArrayList<String> novaLista = new ArrayList<>();
        String Dias[] = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        Integer EscolherDia = JOptionPane.showOptionDialog(null, "Escolha o Dia:", "Escolhendo Dia", 0, 3, null, Dias, Dias[0]);
        if (EscolherDia == -1) return;

        String Turnos[] = {"Mat", "Verp", "Not"};
        Integer EscolherTurno = JOptionPane.showOptionDialog(null, "Escolha o Turno:", "Escolhendo Turno", 0, 3, null, Turnos, Turnos[0]);
        if (EscolherTurno == -1) return;

        Semana SelecionarDia = Semana.values()[EscolherDia];
        Turno SelecionarTurno = Turno.values()[EscolherTurno];

        String diaNome = SelecionarDia.name();
        String turnoNome = SelecionarTurno.name();
        
        for (int i = 0; i < Cardapio.size(); i++) {
            var item = Cardapio.get(i);
            if (item.get(0).equals(diaNome) && item.get(1).equals(turnoNome)) {
                String Op[] = {"Sim", "Não"};
                StringBuilder ValorAssociado = new StringBuilder("Valor Atual:\n");
                var Cont = 0;
                for (var Valor: Cardapio.get(i)) {
                    if (Cont == 2) {
                        ValorAssociado.append("Prato Principal:" + " ".repeat(17)).append(Valor).append("\n");
                    }else if (Cont == 3) {
                        ValorAssociado.append("Salada:"  + " ".repeat(32)).append(Valor).append("\n");
                    } if (Cont == 4) {
                        ValorAssociado.append("Acompanhamento:"  + " ".repeat(11)).append(Valor).append("\n");
                    }
                    Cont++;
                }
                Integer continuar = JOptionPane.showOptionDialog(null, ValorAssociado + "\nJa possui um valor Associado dejesa Trocar?", "Trocar:", 0, 3, null, Op, Op[0]);
                if (continuar != 0) {
                    Cardapio.remove(Cardapio.size() - 1);
                    return;
                }
                novaLista = item; 
                break;
            }
        }
        Cardapio.add(novaLista);
        novaLista.add(diaNome);
        novaLista.add(turnoNome);

        for (int index = 2; index < 5; index++) {
            String complemento = index == 2 ? "ao Prato Principal" : index == 3 ? "à Salada" : "o Acompanhamento";
            String addValor = JOptionPane.showInputDialog("Adicionando " + complemento);
            if (addValor == null) {
                Cardapio.remove(Cardapio.size() - 1);
                return;
            }

            String format = addValor.trim();
            if (format.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite Algo");
                index--;
            } else {
                if (index < novaLista.size()) {
                    novaLista.set(index, format);
                } else {
                    novaLista.add(format);
                }
            }
        }
    }
    StringBuilder Vericar() {
        String Dias[] = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        Integer EscolherDia = JOptionPane.showOptionDialog(null, "Escolha o Dia:", "Escolhendo Dia", 0, 3, null, Dias, Dias[0]);
        Semana SelecionarDia = Semana.values()[EscolherDia];
        String diaNome = SelecionarDia.name();
        
        

        StringBuilder StatusAtual = new StringBuilder();
        StatusAtual.append(" ".repeat(10)).append(SelecionarDia).append("\n").append("-".repeat(30)).append("\n");
        ArrayList<String> OrganizarLista = new ArrayList<>(Arrays.asList("", "", ""));
        if (Cardapio.size() > 0) {
            for (var Item : Cardapio) {
                
                if(Item.get(0).equals(diaNome)) {
                    if (Item.get(1).equals("MATUTINO")) {
                        OrganizarLista.set(0, Item.toString());
                        
                    }else if (Item.get(1).equals("VESPETINO")) {
                        OrganizarLista.set(1, Item.toString());
                        
                    }else if (Item.get(1).equals("NOTURNO")) {
                        OrganizarLista.set(2, Item.toString());
                    }
                    
                }
            }
        }
                
        for (var P : OrganizarLista) {
            if (!P.isEmpty()) {
                StatusAtual.append(P).append("\n");
            }
        }
        return StatusAtual;

    }
    StringBuilder ResultadoFinal() {
        StringBuilder Vazio = new StringBuilder();
        return Vazio;
    }
}
