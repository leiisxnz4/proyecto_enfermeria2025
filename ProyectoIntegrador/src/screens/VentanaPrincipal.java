package screens;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    private JDesktopPane escritorio;

    public VentanaPrincipal() {
        setTitle("Sistema de Enfermería Escolar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        escritorio = new JDesktopPane();
        setContentPane(escritorio);

        crearMenu();
    }

    private void crearMenu() {
        JMenuBar barraMenu = new JMenuBar();

        JMenu menuInsertar = new JMenu("Insertar");

        JMenuItem itemTipoSangre = new JMenuItem("Tipo de Sangre");
        itemTipoSangre.addActionListener(e -> {
            JInternalFrameInsertarTipoSangre frame = new JInternalFrameInsertarTipoSangre();
            escritorio.add(frame);
            frame.setVisible(true);
        });

        JMenuItem itemMedicamento = new JMenuItem("Medicamentos");
        itemMedicamento.addActionListener(e -> {
            JInternalFrameInsertarMedicamento frame = new JInternalFrameInsertarMedicamento();
            escritorio.add(frame);
            frame.setVisible(true);
        });

        menuInsertar.add(itemTipoSangre);
        menuInsertar.add(itemMedicamento);
        barraMenu.add(menuInsertar);

        setJMenuBar(barraMenu);
    }
}
