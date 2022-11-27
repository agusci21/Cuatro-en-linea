package cuatroenlinea.View;

public class SelectPlayersView extends javax.swing.JFrame {

  public SelectPlayersView() {
    initComponents();
  }

  public java.awt.List getPlayer1selectionList() {
    return player1selectionList;
  }

  public java.awt.List getPlayer2selectionList() {
    return player2selectionList;
  }

  public javax.swing.JLabel getFirstPlayerLabel(){
    return firstPlayerLabel;
  }
  public javax.swing.JLabel getSecondPlayerLabel(){
    return secondPlayerLabel;
  }

  

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    jPanel1 = new javax.swing.JPanel();
    titleLabel = new javax.swing.JLabel();
    player1selectionList = new java.awt.List();
    player2selectionList = new java.awt.List();
    player1constLabel = new javax.swing.JLabel();
    player2ConstLabel = new javax.swing.JLabel();
    vsLabel = new javax.swing.JLabel();
    firstPlayerLabel = new javax.swing.JLabel();
    secondPlayerLabel = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
    titleLabel.setText("Seleccione 2 jugadores");

    player1constLabel.setText("Jugador 1");

    player2ConstLabel.setText("Jugador 2");

    vsLabel.setText("VS");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
      jPanel1
    );
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addGap(36, 36, 36)
            .addComponent(
              player1selectionList,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              344,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(68, 68, 68)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addComponent(player1constLabel)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                      317,
                      Short.MAX_VALUE
                    )
                    .addComponent(player2ConstLabel)
                    .addGap(107, 107, 107)
                )
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addComponent(
                      firstPlayerLabel,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      208,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addGap(18, 18, 18)
                    .addComponent(vsLabel)
                    .addGap(18, 18, 18)
                    .addComponent(
                      secondPlayerLabel,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      228,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      Short.MAX_VALUE
                    )
                )
            )
            .addComponent(
              player2selectionList,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              344,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(96, 96, 96)
        )
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addGap(504, 504, 504)
            .addComponent(
              titleLabel,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              437,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addGap(183, 183, 183)
            .addComponent(
              player1selectionList,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              446,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap(59, Short.MAX_VALUE)
        )
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
          jPanel1Layout
            .createSequentialGroup()
            .addGap(49, 49, 49)
            .addComponent(
              titleLabel,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              78,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      Short.MAX_VALUE
                    )
                    .addComponent(
                      player2selectionList,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      446,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addGap(45, 45, 45)
                )
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addGap(92, 92, 92)
                    .addGroup(
                      jPanel1Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.BASELINE
                        )
                        .addComponent(player1constLabel)
                        .addComponent(player2ConstLabel)
                    )
                    .addGap(42, 42, 42)
                    .addGroup(
                      jPanel1Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.BASELINE
                        )
                        .addComponent(vsLabel)
                        .addComponent(firstPlayerLabel)
                        .addComponent(secondPlayerLabel)
                    )
                    .addContainerGap(
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      Short.MAX_VALUE
                    )
                )
            )
        )
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
      getContentPane()
    );
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addComponent(
              jPanel1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(0, 0, Short.MAX_VALUE)
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addComponent(
              jPanel1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(0, 0, Short.MAX_VALUE)
        )
    );

    pack();
  } // </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel firstPlayerLabel;
  private javax.swing.JLabel secondPlayerLabel;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JLabel player1constLabel;
  private java.awt.List player1selectionList;
  private javax.swing.JLabel player2ConstLabel;
  private java.awt.List player2selectionList;
  private javax.swing.JLabel titleLabel;
  private javax.swing.JLabel vsLabel;
  // End of variables declaration//GEN-END:variables
}
