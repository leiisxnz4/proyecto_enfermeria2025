package screens;

import dao.MedicamentoDAO;
import models.Medicamento;

import javax.swing.*;
import java.awt.*;

public class JInternalFrameInsertarMedicamento extends JInternalFrame {

    public JInternalFrameInsertarMedicamento() {
        initComponents();
    }

    private void initComponents() {
        setClosable(true);
        setTitle("Insertar Medicamento");

        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblDosis = new JLabel("Dosis:");
        JLabel lblContra = new JLabel("Contraindicaciones:");

        JTextField txtNombre = new JTextField(15);
        JTextField txtDosis = new JTextField(15);
        JTextArea txtContra = new JTextArea(3, 15);
        JScrollPane scrollContra = new JScrollPane(txtContra);

        JButton btnGuardar = new JButton("Guardar");

        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String dosis = txtDosis.getText().trim();
            String contra = txtContra.getText().trim();

            if (!nombre.isEmpty()) {
                Medicamento med = new Medicamento(nombre, dosis, contra);
                MedicamentoDAO dao = new MedicamentoDAO();
                if (dao.insertar(med)) {
                    JOptionPane.showMessageDialog(this, "Medicamento guardado correctamente.");
                    txtNombre.setText("");
                    txtDosis.setText("");
                    txtContra.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar el medicamento.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El nombre es obligatorio.");
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(lblNombre, gbc);
        gbc.gridx = 1;
        panel.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(lblDosis, gbc);
        gbc.gridx = 1;
        panel.add(txtDosis, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(lblContra, gbc);
        gbc.gridx = 1;
        panel.add(scrollContra, gbc);

        gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnGuardar, gbc);

        getContentPane().add(panel);
        pack();
        setLocation(100, 100); // Opcional: para no abrirlo en (0,0)
    }
}
