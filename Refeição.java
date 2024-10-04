
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Refeição extends Alimentos {
    static ArrayList<ArrayList<String>> listaDeAlimentos = new ArrayList<>();
    Integer C = 0;
    void Criar() {
        listaDeAlimentos.add(new ArrayList<>());
        Integer Qtd = Alimentos.size();
        StringBuilder Format = new StringBuilder("Não foi adicionado nenhum item.\n");
        if (Qtd > 0) {
            Format = new StringBuilder("Alimentos Disponiveis:\n");
            for (var I = 0; I < Qtd; I++) {
                    Format.append(I).append(" - ").append(Alimentos.get(I)).append("\n");
            }
        }
        main: for (var i = 0; i < 3; i++) {
            var Complemento = " ";
            if (i == 0) {
                Complemento = "ao Prato Principal";
            }else if(i == 1) {
                Complemento = "a salada";
            }else {
                Complemento = "o acompanhamento";
            }
            while (true) {
                var Refeição = JOptionPane.showInputDialog(null, Format + "\nInforme o codigo do alimento para adicionar\n" + Complemento, "Adicionar", 3);                
                if (Refeição == null) {
                        listaDeAlimentos.get(C).clear();
                        break main;
                } 
                var Arrumar = Refeição.trim();
                if (Arrumar.equals("")) {
                    JOptionPane.showMessageDialog(null, "Por Favor Digite Algo");
                }else {
                    var NaoConverte = false;
                    var Valor = 0;
                    try {
                        Valor = Integer.parseInt(Arrumar); 
                        
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro digite um numero interio",null,  0);
                        NaoConverte = true;
                    }
                    if (Valor >= Alimentos.size() || Valor < 0) {
                        NaoConverte = true;
                        JOptionPane.showMessageDialog(null, "Erro Codigo Não encontrado",null,  0);
                        
                    }
                    if (NaoConverte == false) {
                        listaDeAlimentos.get(C).add(Alimentos.get(Valor));
                        if(i == 2) {
                        C++;
                        }
                        break;
                    }
                }
            }
        }
    }
    ArrayList<ArrayList<String>> ListaRe() {
        return listaDeAlimentos;
    }
}
