
import javax.swing.JOptionPane;

public class Menu {
    Alimentos Alimentos = new Alimentos();    
    Refeição Refeição = new Refeição();    
    Cardapio Cardapio = new Cardapio();    
    Semanal Menu = new Semanal();    
    void Iniciar() {
        while (true) {
           String Opcoes[] = {"Add", "Criar", "Menu", "Semanal", "Verificar"};
            Integer Valor = JOptionPane.showOptionDialog(null, "- Adicionar Alimento\n- Criar Refeição\n- Montar Menu\n- Fazer Cardapio Semanal\n - Vericar Estado Atual do cardapio", "Restaurante LeDelicious", 0, 3, null, Opcoes, Opcoes[0]);
            if(Valor.equals(0)) {
                Alimentos.Add();
            }else if(Valor.equals(1)) {
               Refeição.Criar();
            }else if(Valor.equals(2)) {
                Cardapio.Montar();
            }else if(Valor.equals(3)) {
                Menu.DaSemana();
            }else if(Valor.equals(4)) {
                Menu.ResultadoFinal();
            }else {
                break;
            } 
        } 
    }
}
