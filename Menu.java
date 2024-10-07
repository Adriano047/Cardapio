
import javax.swing.JOptionPane;

public class Menu {
    Cardapio Cardapio = new Cardapio();
     void Iniciar() {
        while (true) {
           String Opcoes[] = {"Add"};
            Integer Valor = JOptionPane.showOptionDialog(null, "Adicionar ao cardapio", "Restaurante LeDelicious", 0, 3, null, Opcoes, Opcoes[0]);
            if(Valor.equals(0)) {
                Cardapio.Add();
            }else {
                System.out.println(Cardapio.ResultadoFinal());
                break;
            } 
        } 
    }
}
