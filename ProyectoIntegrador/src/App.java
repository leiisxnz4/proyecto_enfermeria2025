import javax.swing.SwingUtilities;
import screens.VentanaPrincipal;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
