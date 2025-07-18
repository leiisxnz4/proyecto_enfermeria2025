package screens;

import java.awt.Font; //Necesaria para cambiar tipo de letra
import javax.swing.GroupLayout; // Necesaria para crear el layout
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JInternalFrameInsertarBachillerato extends JInternalFrame{
    private JLabel lblId;
    private JLabel lblNombreBachillerato;
    private JTextField txtId;
    private JTextField txtNombreBachillerato;
    private JButton btnAceptar;
    private JButton btnCancelar;

    public JInternalFrameInsertarBachillerato(){
        super("Insertar Bachillerato", 
              true,  // resizable
              true,  // closable
              true,  // maximizable
              true); // iconifiable (minimizable)
        this.setTitle("Insertar nuevo bachillerato");
        this.setSize(400,400);
        initComponents();
    }

    private void initComponents(){
        // Creación de objetos
        lblId = new JLabel("Id:");
        lblNombreBachillerato = new JLabel("Nombre de Bachillerato:");
        txtId = new JTextField();
        txtNombreBachillerato = new JTextField();
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");

        // Etiquetas
        lblId.setFont(new Font("Tahoma", 0, 14));
        lblNombreBachillerato.setFont(new Font("Tahoma", Font.BOLD, 16));
        //Botones 
        btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));

        btnCancelar.addActionListener(e -> this.dispose());

        GroupLayout layout = new GroupLayout(getContentPane());
        this.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblId)
                .addComponent(txtId)
                .addComponent(lblNombreBachillerato)
                .addComponent(txtNombreBachillerato)
                .addGroup(
                    layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addComponent(btnCancelar)
                )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(lblId)
                .addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNombreBachillerato)
                .addComponent(txtNombreBachillerato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAceptar)
                        .addComponent(btnCancelar)
                )
        );
    }
}
