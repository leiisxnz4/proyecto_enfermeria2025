package screens;

import dao.TipoSangreDAO;
import models.TipoSangre;
import javax.swing.*;

public class JInternalFrameInsertarTipoSangre extends javax.swing.JInternalFrame {
    public JInternalFrameInsertarTipoSangre() {
        initComponents();
    }

    private void initComponents() {
        setClosable(true);
        setTitle("Insertar Tipo de Sangre");

        JLabel lblNombre = new JLabel("Tipo de sangre:");
        JTextField txtNombre = new JTextField(10);
        JButton btnGuardar = new JButton("Guardar");

        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            if (!nombre.isEmpty()) {
                TipoSangre tipo = new TipoSangre(nombre);
                TipoSangreDAO dao = new TipoSangreDAO();
                boolean exito = dao.insertar(tipo);

                if (exito) {
                    JOptionPane.showMessageDialog(this, "Tipo de sangre guardado correctamente.");
                    txtNombre.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Escribe un tipo de sangre válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(btnGuardar);

        getContentPane().add(panel);
        pack();
    }
}
