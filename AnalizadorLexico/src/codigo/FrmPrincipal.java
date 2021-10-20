/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

/**
 *
 * @author Charly Ponce
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public String Sintematico = "";
    public String Sintematico2 = "";
    public String Verbo = "";

    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void analizarLexico() throws IOException {
        int cont = 1;
        Sintematico = "";
        Sintematico2 = "";
        Verbo = "";
        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "Token " + cont + "\t\tSIMBOLO\n";
        int a = 0;
        while (true) {
            a = a + 1;
            Tokens token = lexer.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                jTextField1.setText("Oracion Corresta " + (a - 1) + " Palabras Anilizadas");

                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n";
                    break;
                case Cadena:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case T_dato:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case If:
                    resultado += "  <Reservada if>\t" + lexer.lexeme + "\n";
                    break;
                case Else:
                    resultado += "  <Reservada else>\t" + lexer.lexeme + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexer.lexeme + "\n";
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case For:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t" + lexer.lexeme + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexer.lexeme + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
                    break;
                case Op_logico:
                    resultado += "  <Operador logico>\t" + lexer.lexeme + "\n";
                    break;
                case Op_incremento:
                    resultado += "  <Operador incremento>\t" + lexer.lexeme + "\n";
                    break;
                case Op_relacional:
                    resultado += "  <Operador relacional>\t" + lexer.lexeme + "\n";
                    break;
                case Op_atribucion:
                    resultado += "  <Operador atribucion>\t" + lexer.lexeme + "\n";
                    break;
                case Op_booleano:
                    resultado += "  <Operador booleano>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_a:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_c:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Corchete_a:
                    resultado += "  <Corchete de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Pregunta:
                    resultado += "  <Pregunta>\t\t" + lexer.lexeme + "\n";
                    break;

                case Corchete_c:
                    resultado += "  <Corchete de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Main:
                    resultado += "  <Reservada main>\t" + lexer.lexeme + "\n";
                    break;
                case P_coma:
                    resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n";
                    break;
                case ID:
                    if ("se".equals(lexer.lexeme) || "les".equals(lexer.lexeme) || "le".equals(lexer.lexeme) || "los".equals(lexer.lexeme) || "las".equals(lexer.lexeme) || "le".equals(lexer.lexeme) || "lo".equals(lexer.lexeme) || "quien".equals(lexer.lexeme) || "donde".equals(lexer.lexeme) || "cuales".equals(lexer.lexeme) || "cual".equals(lexer.lexeme) || "cuanta".equals(lexer.lexeme) || "cuanto".equals(lexer.lexeme) || "tales".equals(lexer.lexeme) || "tantos".equals(lexer.lexeme) || "otros".equals(lexer.lexeme) || "varios".equals(lexer.lexeme) || "bastantes".equals(lexer.lexeme) || "escasos".equals(lexer.lexeme) || "muchos".equals(lexer.lexeme) || "pocos".equals(lexer.lexeme) || "ninguno".equals(lexer.lexeme) || "nadie".equals(lexer.lexeme) || "cualquierea".equals(lexer.lexeme) || "Alguien".equals(lexer.lexeme) || "alguien".equals(lexer.lexeme) || "alguno".equals(lexer.lexeme) || "Alguna".equals(lexer.lexeme) || "Alguno".equals(lexer.lexeme) || "alguno".equals(lexer.lexeme) || "una".equals(lexer.lexeme) || "Una".equals(lexer.lexeme) || "Un".equals(lexer.lexeme) || "un".equals(lexer.lexeme) || "vuestras".equals(lexer.lexeme) || "vuestra".equals(lexer.lexeme) || "vuestros".equals(lexer.lexeme) || "vuestro".equals(lexer.lexeme) || "nuestras".equals(lexer.lexeme) || "nuestra".equals(lexer.lexeme) || "nuestro".equals(lexer.lexeme) || "nuestros".equals(lexer.lexeme) || "suyas".equals(lexer.lexeme) || "suyos".equals(lexer.lexeme) || "suya".equals(lexer.lexeme) || "suyo".equals(lexer.lexeme) || "tuyos".equals(lexer.lexeme) || "tuyas".equals(lexer.lexeme) || "tuya".equals(lexer.lexeme) || "tuyo".equals(lexer.lexeme) || "mias".equals(lexer.lexeme) || "mios".equals(lexer.lexeme) || "mia".equals(lexer.lexeme) || "mio".equals(lexer.lexeme) || "aquellas".equals(lexer.lexeme) || "aquellos".equals(lexer.lexeme) || "aquello".equals(lexer.lexeme) || "aquella".equals(lexer.lexeme) || "aquel".equals(lexer.lexeme) || "estas".equals(lexer.lexeme) || "estos".equals(lexer.lexeme) || "esto".equals(lexer.lexeme) || "esta".equals(lexer.lexeme) || "este".equals(lexer.lexeme) || "Yo".equals(lexer.lexeme) || "Tú".equals(lexer.lexeme) || "Él".equals(lexer.lexeme) || "Ella".equals(lexer.lexeme) || "Nosotros".equals(lexer.lexeme) || "Nosotras".equals(lexer.lexeme) || "Vosotros".equals(lexer.lexeme) || "Vosotras".equals(lexer.lexeme) || "Ellas".equals(lexer.lexeme) || "Ellos".equals(lexer.lexeme) || "yo".equals(lexer.lexeme) || "tu".equals(lexer.lexeme) || "el".equals(lexer.lexeme) || "ella".equals(lexer.lexeme) || "nosotros".equals(lexer.lexeme) || "nosotras".equals(lexer.lexeme) || "nosotros".equals(lexer.lexeme) || "nosotras".equals(lexer.lexeme) || "ellas".equals(lexer.lexeme) || "ellos".equals(lexer.lexeme)) {
                        Sintematico += "Pronombre ";

                    } else {
                        if ("via".equals(lexer.lexeme) || "versus".equals(lexer.lexeme) || "tras".equals(lexer.lexeme) || "sobre".equals(lexer.lexeme) || "so".equals(lexer.lexeme) || "sin".equals(lexer.lexeme) || "segun".equals(lexer.lexeme) || "por".equals(lexer.lexeme) || "para".equals(lexer.lexeme) || "mediante".equals(lexer.lexeme) || "hasta".equals(lexer.lexeme) || "hacia".equals(lexer.lexeme) || "entre".equals(lexer.lexeme) || "en".equals(lexer.lexeme) || "durante".equals(lexer.lexeme) || "desde".equals(lexer.lexeme) || "de".equals(lexer.lexeme) || "contra".equals(lexer.lexeme) || "con".equals(lexer.lexeme) || "bajo".equals(lexer.lexeme) || "a".equals(lexer.lexeme) || "ante".equals(lexer.lexeme)) {
                            Sintematico += "Preposiciones ";
                        } else {
                            if ("jugaron".equals(lexer.lexeme) || "jugamos".equals(lexer.lexeme) || "jugo".equals(lexer.lexeme) || "jugue".equals(lexer.lexeme) || "jugaran".equals(lexer.lexeme) || "jugaremos".equals(lexer.lexeme) || "jugara".equals(lexer.lexeme) || "jugare".equals(lexer.lexeme) || "compraran".equals(lexer.lexeme) || "compraremos".equals(lexer.lexeme) || "comprara".equals(lexer.lexeme) || "comprare".equals(lexer.lexeme) || "compraron".equals(lexer.lexeme) || "compre".equals(lexer.lexeme) || "compran".equals(lexer.lexeme) || "compramos".equals(lexer.lexeme) || "compro".equals(lexer.lexeme) || "compra".equals(lexer.lexeme) || "juegan".equals(lexer.lexeme) || "jugamos".equals(lexer.lexeme) || "juega".equals(lexer.lexeme) || "juego".equals(lexer.lexeme)) {
                                Sintematico += "Verbo ";
                                Verbo = lexer.lexeme;
                                Sintematico2 += "Verbo ";
                            } else {
                                Sintematico += "Sustantivo ";
                                Sintematico2 += "Sustantivo ";
                            }
                        }

                    }
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    Sintematico += "Determinante ";
                    Sintematico2 += "Determinante ";
                    break;
                case ERROR:

                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAnalizarLex = new javax.swing.JButton();
        btnAnalizarSin = new javax.swing.JButton();
        btnLimpiarLex = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAnalizarSin = new javax.swing.JTextField();
        respuesta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAnalizarLex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnalizarLex.setText("Análisis Léxico");
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });

        btnAnalizarSin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnalizarSin.setText("Análisis Sintántico");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });

        btnLimpiarLex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarLex.setText("Limpiar");
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });

        txtAnalizarLex.setEditable(false);
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tokenizacion 1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Análisis Léxico");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tokenizacion 2");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Analisis Sintactico");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tokenizacion 3");

        txtAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnalizarSinActionPerformed(evt);
            }
        });

        respuesta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        respuesta.setText("Respuesta");
        respuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuestaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Respuesta");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Proyecto 3 Introducción a la teoría de la computación");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Ingrese las oraciones a analizar:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Abrir archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(252, 252, 252))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAnalizarSin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAnalizarLex)
                                        .addGap(18, 18, 18)
                                        .addComponent(respuesta))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField4)
                                        .addComponent(jTextField3)
                                        .addComponent(jTextField1)
                                        .addComponent(txtAnalizarSin)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                                        .addComponent(jLabel6)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(btnLimpiarLex, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnalizarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(71, 71, 71)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizarSin)
                    .addComponent(btnAnalizarLex)
                    .addComponent(respuesta)
                    .addComponent(btnLimpiarLex))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed
        // TODO add your handling code here:
        txtAnalizarLex.setText(null);
        jTextField2.setText(null);
        txtAnalizarSin.setText(null);
        jTextField1.setText(null);
        jTextField3.setText(null);
                jTextField4.setText(null);


    }//GEN-LAST:event_btnLimpiarLexActionPerformed

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        // TODO add your handling code here:
        String ST = txtResultado.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));

        try {
            s.parse();
            txtAnalizarSin.setText("Analisis realizado correctamente");

            jTextField2.setText(Sintematico);
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

    private void respuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuestaActionPerformed

        jTextField3.setText(Sintematico2);

        if ("jugaron".equals(Verbo)) {
            jTextField4.setText("Si, Ellos jugaron por muchas horas");
        }
        if ("jugamos".equals(Verbo)) {
             jTextField4.setText("Si, Nosotros jugaron poco tiempo");
        }

        if ("jugo".equals(Verbo)) {
             jTextField4.setText("No, jugo con andres");
        }
        if ("jugue".equals(Verbo)) {
             jTextField4.setText("Si, Tu jugaste hasta quedar dormido");

        }
        if ("jugaran".equals(Verbo)) {
             jTextField4.setText("Si, Ellos jugaran con andres");

        }
        if ("jugaremos".equals(Verbo)) {
             jTextField4.setText("Si, nosotros jugaremos hasta el cansancio");
        }
        if ("jugara".equals(Verbo)) {
             jTextField4.setText("Si, jugara tambien con diana");
        }
        if ("jugare".equals(Verbo)) {
             jTextField4.setText("No, tendras que estudiar");
        }
        if ("compraran".equals(Verbo)) {
             jTextField4.setText("No, tendran primero que ahorrar");
        }
        if ("compraremos".equals(Verbo)) {
             jTextField4.setText("Si, si todo sale bien");
        }
        if ("comprara".equals(Verbo)) {
             jTextField4.setText("Si, para tener algo mas en la vida");
        }
        if ("comprare".equals(Verbo)) {
             jTextField4.setText("Solo solo depende de ti");
        }
        if ("compraron".equals(Verbo)) {
            
             jTextField4.setText("Si, y van por mas");
        }
        if ("compre".equals(Verbo)) {
             jTextField4.setText("Si, pero lo tendras que vender");
        }
        if ("compran".equals(Verbo)) {
             jTextField4.setText("Si, y quieren otro");
        }
        if ("compramos".equals(Verbo)) {
             jTextField4.setText("No, todo fue un sueño");
        }
        if ("compro".equals(Verbo)) {
             jTextField4.setText("Yo no tengo ni idea");
        }
        if ("compra".equals(Verbo)) {
             jTextField4.setText("Si, aunque deberia de pensarlo mejor");
        }
        if ("juegan".equals(Verbo)) {
             jTextField4.setText("Si, y sera hasta que les de sueño");
        }
        if ("jugamos".equals(Verbo)) {
             jTextField4.setText("Si, y tambien miramemos television");
        }
        if ("juega".equals(Verbo)) {
             jTextField4.setText("Si, y esta con el equipo de Lila");
        }
        if ("juego".equals(Verbo)) {
             jTextField4.setText("No, estas estudiando");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_respuestaActionPerformed

    private void txtAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnalizarSinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnalizarSinActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton respuesta;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextField txtAnalizarSin;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
