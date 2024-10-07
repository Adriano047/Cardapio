
import javax.swing.JOptionPane;

public class Menu {
    Cardapio Cardapio = new Cardapio();
     void Iniciar() {
        while (true) {
           String Opcoes[] = {"Add", "Verificar"};
            Integer Valor = JOptionPane.showOptionDialog(null, "Opções Disponiveis:\n- Adicionar ao cardapio\n - Vericar Estado Atual do cardapio", "Restaurante LeDelicious", 0, 3, null, Opcoes, Opcoes[0]);
            if(Valor.equals(0)) {
                Cardapio.Add();
            }else if(Valor.equals(1)) {
                JOptionPane.showMessageDialog(null, Cardapio.Vericar());
            }else {
                System.out.println(Cardapio.ResultadoFinal());
                break;
            } 
        } 
    }
}
