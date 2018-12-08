/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author PONKCHO
 */
import com.itver.project.resources.*;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class InicioM extends javax.swing.JFrame {

    
    public InicioM() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(667,540);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
        panelPrincipal = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnIniciarSesion = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jlFondo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtUsuarioRegistro = new javax.swing.JTextField();
        txtPasswordRegistro = new javax.swing.JPasswordField();
        btnGuardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(650, 500));
        setSize(new java.awt.Dimension(650, 500));

        panelPrincipal.setPreferredSize(new java.awt.Dimension(650, 500));
        panelPrincipal.setVerifyInputWhenFocusTarget(false);

        jPanel1.setLayout(null);

        btnIniciarSesion.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarSesion);
        btnIniciarSesion.setBounds(70, 220, 180, 48);

        btnRegistrar.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        btnRegistrar.setText("Registrarse");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar);
        btnRegistrar.setBounds(70, 280, 180, 48);

        btnSalir.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);
        btnSalir.setBounds(500, 410, 120, 40);

        jlFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inicio1.png"))); // NOI18N
        jPanel1.add(jlFondo);
        jlFondo.setBounds(0, 0, 650, 480);

        panelPrincipal.addTab("Menú", jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(650, 500));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Usuario");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(410, 60, 114, 39);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Contraseña");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(390, 160, 170, 39);
        jPanel2.add(txtUsuario);
        txtUsuario.setBounds(390, 100, 160, 39);
        jPanel2.add(txtPassword);
        txtPassword.setBounds(390, 200, 160, 39);

        btnEntrar.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEntrar);
        btnEntrar.setBounds(400, 270, 140, 50);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inicio1.png"))); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 0, 650, 480);

        panelPrincipal.addTab("Iniciar Sesión", jPanel2);

        jPanel3.setPreferredSize(new java.awt.Dimension(650, 500));
        jPanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Nombre:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(320, 60, 134, 28);

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Apellidos:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(320, 100, 134, 30);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Correo:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(320, 140, 134, 28);

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Usuario:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(320, 180, 134, 28);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Password:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(320, 220, 134, 28);
        jPanel3.add(txtNombre);
        txtNombre.setBounds(440, 60, 171, 28);
        jPanel3.add(txtApellidos);
        txtApellidos.setBounds(440, 100, 171, 28);
        jPanel3.add(txtCorreo);
        txtCorreo.setBounds(440, 140, 171, 28);
        jPanel3.add(txtUsuarioRegistro);
        txtUsuarioRegistro.setBounds(440, 180, 171, 28);
        jPanel3.add(txtPasswordRegistro);
        txtPasswordRegistro.setBounds(440, 220, 171, 28);

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar);
        btnGuardar.setBounds(380, 330, 179, 52);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inicio1.png"))); // NOI18N
        jPanel3.add(jLabel9);
        jLabel9.setBounds(0, 0, 650, 480);

        panelPrincipal.addTab("Registrar", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelPrincipal.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>                        

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {                                       
        try {
            String user = txtUsuario.getText().trim();  //Recuperacion del usuario
            String password = txtPassword.getText().trim(); //Recuperacion de la contraseña
            User current_user = new User();//Creacion de un objeto usuario
            //System.out.println("Usuario" + user + " Password " + password);
            current_user.setUsuario(user); //asignacion del nombre de usuario
            current_user.setPassword(password); // asignacion del password
            System.out.println(current_user);
            //Preparado de paquete para enviar por la red
            String server = "10.25.1.167";//RECCION IP DEL SERVIDOR
            int port = 9090; //Puerto del servidor
            NetConnection connection = new NetConnection(new Socket(server, port));
            PacketNet requestPacket = new PacketNet(current_user, Protocol.LOGGIN );
            connection.sendPacket(requestPacket); //Envio de paquete
            PacketNet receivedPacket = connection.readPacket(); //Paquete recibido
            if(receivedPacket.getTipo_mensaje().equals(Protocol.REQUEST_ACEPTED)){
                new Juego(connection);
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Error al iniciar sesion\n"
                        + "Verifique su correo o contraseña porfavor",
                        "Error de inicio de sesion", JOptionPane.ERROR_MESSAGE);      
            }
        } catch (IOException ex) {
            Logger.getLogger(InicioM.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error en la conexion con el servidor");
        }
    }                                      

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }                                        

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        panelPrincipal.setSelectedIndex(2);
    }                                            

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        panelPrincipal.setSelectedIndex(1);
    }                                                

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                           
      try {
          //Recuperacion de los datos introducidos para hacer el registro en  el servidor
            String nombre = txtNombre.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            String correo = txtCorreo.getText().trim();
            String user = txtUsuarioRegistro.getText().trim();
            String password = txtPasswordRegistro.getText().trim();
          //Creacion de un objeto usuario
            User current_user = new User(nombre, apellidos, user, correo, password);
          //Preparado de paquete para enviar por la red
            String server = "10.25.1.167"; //DIRECCION IP DEL SERVIDOR
            int port = 9090; //Puerto del servidor
            NetConnection connection = new NetConnection(new Socket(server, port));
            //Se le manda el usuario a registrar y el tipo de operacion en el protcolo
            PacketNet requestPacket = new PacketNet(current_user, Protocol.REGISTER );
            connection.sendPacket(requestPacket); //Envio de paquete
            PacketNet receivedPacket = connection.readPacket(); //Paquete recibido
            if(receivedPacket.getTipo_mensaje().equals(Protocol.REQUEST_ACEPTED)){
                JOptionPane.showMessageDialog(this, "Se ha creado la cuenta exitosamente\n"
                        + "De click en aceptar para continuar",
                        "Cuenta Creada",
                       JOptionPane.INFORMATION_MESSAGE);
                new Juego(connection);
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Error al crear la cuenta\n"
                        + "Verifique su correo o contraseña porfavor",
                        "Error de registro", JOptionPane.ERROR_MESSAGE);      
            }
        } catch (IOException ex) {
            Logger.getLogger(InicioM.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error en la conexion con el servidor");
        }
    }                                          

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlFondo;
    private javax.swing.JTabbedPane panelPrincipal;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordRegistro;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuarioRegistro;
    // End of variables declaration                   
}
