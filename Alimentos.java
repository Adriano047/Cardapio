package DesafioIn.Cardapio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Alimentos {
    static List<String> Alimentos = new ArrayList<>();
    void Add() {
        while(true) {
            var alimento = JOptionPane.showInputDialog(null, "Adicionar Alimento:", "Novo Alimento", 3);
            if (alimento == null) {
                break;
            }
            var Limpar = alimento.trim();
            if(Limpar.equals("")) {
                JOptionPane.showMessageDialog(null, "Por Favor Digite Algo");
            }else {
                Alimentos.add(Limpar);
                JOptionPane.showMessageDialog(null, "ALimento adicionado com sucesso");

                break;
            }
           
        }
    }
    public Integer size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }
}
