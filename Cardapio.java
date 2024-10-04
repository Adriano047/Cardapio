
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Cardapio{
    static ArrayList<ArrayList<String>> Menus = new ArrayList<>();
    Refeição Refeição = new Refeição();
    Integer C = 0;
    void Montar() {
        Menus.add(new ArrayList<>());
        var Lista = Refeição.ListaRe();
        Integer Qtd = Lista.size();
        
        
        StringBuilder Format = new StringBuilder("Não foi adicionado nenhum item.\n");
        if (Qtd > 0) {
            Format = new StringBuilder("Refeições Disponiveis:\n");
            for (var I = 0; I < Qtd; I++) {
                    Format.append(I).append(" - ").append(Lista.get(I)).append("\n");
            }
        }
        var AddRefeição = 0;
            var Indice = 0;
            while(Indice < 3) {
                if (Indice == 0) {
                    var Conversivel = true;
                    var Valor = JOptionPane.showInputDialog(null, Format + "\nInforme o codigo da refeição para adicionar\n", "Adicionar Cardapio", 3);
                    if(Valor == null) {
                        break;
                    }
                    try {
                        var Verifar = Valor.trim();
                        AddRefeição = Integer.parseInt(Verifar); 
                    
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro digite um numero inteiro",null,  0);
                        Conversivel = false;
                    } 
                    if(AddRefeição >= Lista.size() || AddRefeição < 0) {
                            JOptionPane.showMessageDialog(null, "Erro Codigo Não encontrado",null,  0);
                            Conversivel = false;

                    }
                    if (Conversivel == true) {
                        Menus.get(C).addAll(Lista.get(AddRefeição));
                        Indice++;
                    }
                }else if(Indice == 1) {
                    String Turnos[] = {"Mat", "Verp", "Not"};
                    Integer EscolherTurno = JOptionPane.showOptionDialog(null, "Escolha o Turno:\n- Matutino\n- Vespertino\n- Noturno", "Escolhendo Turno", 0, 3, null, Turnos, Turnos[0]);
                    Turno Selecionado = Turno.MATUTINO;
                    switch (EscolherTurno) {
                        case 1:
                            Selecionado = Turno.VESPERTINO;
                            break;
                        case 2:
                            Selecionado = Turno.NOTURNO;
                            break;
                    }
                    if(EscolherTurno == -1) {
                        break;
                    }else {
                        Menus.get(C).add(Selecionado.name());
                        Indice++;
                    }
                }else {
                    String Dias[] = {"Dom", "Seg", "Ter","Qua","Qui","Sex", "Sab"};
                    Integer EscolherDia = JOptionPane.showOptionDialog(null, "Escolha o Turno:\n- Domingo\n- Segunda\n- Terça\n- Quarta\n- Quinta\n- Sexta\n- Sabado", "Escolhendo Dia", 0, 3, null, Dias, Dias[0]);
                    Semana Selecionado = Semana.DOMINGO;
                    switch (EscolherDia) {
                        case 1:
                            Selecionado = Semana.SEGUNDA;
                            break;
                        case 2:
                            Selecionado = Semana.TERÇA;
                            break;
                        case 3:
                            Selecionado = Semana.QUARTA;
                            break;
                        case 4:
                            Selecionado = Semana.QUINTA;
                            break;
                        case 5:
                            Selecionado = Semana.SEXTA;
                            break;
                        case 6:
                            Selecionado = Semana.SABADO;
                            break;
                    }
                    if(EscolherDia == -1) {
                        break;
                    }else {
                        Menus.get(C).add(Selecionado.name());
                        Indice++;
                        C++;
                    }
                } 
            }
            
    }
}
