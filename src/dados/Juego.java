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
import com.itver.project.resources.NetConnection;
import com.itver.project.resources.PacketNet;
import com.itver.project.resources.Protocol;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Juego extends javax.swing.JFrame {

    private final NetConnection connection;

    Craps c = new Craps();
    Dado Dado11 = new Dado();
    Dado Dado22 = new Dado();
    DadoImagen d = new DadoImagen();
    DadoImagen e = new DadoImagen();
    DadoImagen f = new DadoImagen();
    DadoImagen g = new DadoImagen();

    int craps;
    int gano;
    int tirada;
    int suma;
    int con = 0, con1 = 0;

    public Juego(final NetConnection connection) {
        this.connection = connection;

        initComponents();
        setVisible(true);
        BloquearTextos();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                connection.closeComunication();
                System.exit(0);
            }
        });


    }


    void Limpiar() {// Método para reiniciar la partida
        int opcion = 3;
        int opcion2 = 4;
        jLDado1.setIcon(e.dadogif(opcion));
        jLDado2.setIcon(d.dadogif(opcion2));
        txtPerdidas.setText("");
        txtGanadas.setText("");
        txtResultadoTirada.setText("");
    }

    void BloquearTextos() {// Impide que el usuario mnodifique los JTexField
        btnTirar.setVisible(false);
        txtPerdidas.setEditable(false);
        txtGanadas.setEditable(false);
        txtResultadoTirada.setEditable(false);

    }

    void Tirar() {//<--- PARA método la tirar
        int dado1 = Dado11.GenerarDado(this.connection);
        int dado2 = Dado22.GenerarDado(this.connection);
        suma = dado1 + dado2;
        c.Gana(suma);
        c.Tirada(suma);
        jLDado1.setIcon(f.Cara(dado1));
        jLDado2.setIcon(g.Cara(dado2));
        String d1 = Integer.toString(dado1);
        String d2 = Integer.toString(dado2);
        String resultado = Integer.toString(suma);
        txtResultadoTirada.setText(resultado);
    }

    void Tirada(int numT) {// Si no gana numT pierde se repite este metodo hasta llegar Dado11 la tirada anterior

        if (tirada == 1) {
            JOptionPane.showMessageDialog(null, " Vuelve a sacar: " + numT
                    + ",Para ganar. Pero si sale 7 antes pierdes ");
            //txtDado2.setText("");
            txtResultadoTirada.setText("");
            //txtDado1.setText("");

            int selection = JOptionPane.showOptionDialog(
                    this,
                    "¿Tirar otra vez?", //Mensaje
                    "SELECCIONE UNA OPCION",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // null para icono por defecto.
                    new Object[]{"Si", "No"}, // Decision para seguir Jugando
                    "Si");
            if (selection == 0) {
                Tirar();
                int suma2 = suma;
                if (numT == suma2) {

                    con1++;
                    tirada = 0;
                    JOptionPane.showMessageDialog(null, "GANASTE");
                    txtGanadas.setText("" + con1);

                }
                if (suma2 == 7) {
                    con++;
                    tirada = 0;
                    JOptionPane.showMessageDialog(null, "CRAPS PERDISTE");
                    txtPerdidas.setText("" + con);

                } else {
                    Tirada(numT);

                }
            } else {
                con++;
                JOptionPane.showMessageDialog(null, "Más suerte para la próxima");
                txtPerdidas.setText("" + con);
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        btnJugar = new javax.swing.JButton();
        jLDado2 = new javax.swing.JLabel();
        jLDado1 = new javax.swing.JLabel();
        txtResultadoTirada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGanadas = new javax.swing.JTextField();
        btnTirar = new javax.swing.JButton();
        txtPerdidas = new javax.swing.JTextField();
        btnReiniciar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondojuego.png"))); // NOI18N
        jcMousePanel1.setMinimumSize(new java.awt.Dimension(700, 400));
        jcMousePanel1.setLayout(null);

        btnJugar.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btnJugar.setText("JUGAR");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        jcMousePanel1.add(btnJugar);
        btnJugar.setBounds(260, 530, 137, 40);

        jLDado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLDado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/daIN2.png"))); // NOI18N
        jLDado2.setPreferredSize(new java.awt.Dimension(300, 300));
        jcMousePanel1.add(jLDado2);
        jLDado2.setBounds(510, 130, 300, 300);

        jLDado1.setBackground(new java.awt.Color(255, 255, 255));
        jLDado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLDado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/daIN1.png"))); // NOI18N
        jLDado1.setPreferredSize(new java.awt.Dimension(300, 300));
        jcMousePanel1.add(jLDado1);
        jLDado1.setBounds(350, 140, 300, 300);

        txtResultadoTirada.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtResultadoTirada.setForeground(new java.awt.Color(255, 0, 0));
        txtResultadoTirada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jcMousePanel1.add(txtResultadoTirada);
        txtResultadoTirada.setBounds(220, 230, 80, 30);

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 3, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Tu juego fue de");
        jcMousePanel1.add(jLabel4);
        jLabel4.setBounds(40, 230, 190, 20);

        txtGanadas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtGanadas.setForeground(new java.awt.Color(0, 0, 255));
        txtGanadas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGanadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGanadasActionPerformed(evt);
            }
        });
        jcMousePanel1.add(txtGanadas);
        txtGanadas.setBounds(220, 290, 130, 30);

        btnTirar.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btnTirar.setText("TIRAR");
        btnTirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTirarActionPerformed(evt);
            }
        });
        jcMousePanel1.add(btnTirar);
        btnTirar.setBounds(130, 350, 137, 40);

        txtPerdidas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPerdidas.setForeground(new java.awt.Color(0, 0, 255));
        txtPerdidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jcMousePanel1.add(txtPerdidas);
        txtPerdidas.setBounds(50, 290, 130, 30);

        btnReiniciar.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btnReiniciar.setText("REINICIAR");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        jcMousePanel1.add(btnReiniciar);
        btnReiniciar.setBounds(90, 530, 137, 40);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Juegos Perdidos");
        jcMousePanel1.add(jLabel5);
        jLabel5.setBounds(50, 260, 140, 30);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Juegos Ganados");
        jcMousePanel1.add(jLabel7);
        jLabel7.setBounds(220, 260, 140, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        BloquearTextos();
        btnJugar.setVisible(true);
        con = 0;
        con1 = 0;
        Limpiar();
    }                                            

    private void btnTirarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        BloquearTextos();
        btnJugar.setVisible(false);
        btnTirar.setVisible(true);
        Tirar();
        craps = c.Crapso(suma);
        gano = c.Gana(suma);
        tirada = c.Tirada(suma);
        Tirada(suma);
        if (craps == 1) {
            con++;
            txtPerdidas.setText("" + con);
            JOptionPane.showMessageDialog(null, "CRAPS");
        }
        if (gano == 1) {
            con1++;
            txtGanadas.setText("" + con1);
            JOptionPane.showMessageDialog(null, "GANASTE");
        }

    }                                        

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {                                         

        PacketNet request_packet = new PacketNet();
        request_packet.setMensaje("LISTO PARA JUGAR");
        request_packet.setTipo_mensaje(Protocol.PLAY);
        connection.sendPacket(request_packet);

        PacketNet received_packet = connection.readPacket();
        if(received_packet.getTipo_mensaje().equals(Protocol.REQUEST_ACEPTED)){
            System.out.println(received_packet.getMensaje());
        }

        BloquearTextos();
        int opcion3 = 1;
        int opcion4 = 2;
        btnTirar.setVisible(true);
        jLDado1.setIcon(e.dadogif(opcion3));
        jLDado2.setIcon(d.dadogif(opcion4));
    }                                        

    private void txtGanadasActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnTirar;
    private javax.swing.JLabel jLDado1;
    private javax.swing.JLabel jLDado2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JTextField txtGanadas;
    private javax.swing.JTextField txtPerdidas;
    private javax.swing.JTextField txtResultadoTirada;
    // End of variables declaration                   
}
