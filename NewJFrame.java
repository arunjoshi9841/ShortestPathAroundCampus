package dijkstra.implementation;


import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arunj
 */
public class NewJFrame extends javax.swing.JFrame {
public int vertices;
        public int source;
        public int destination;
        public String a=" ";
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }
public NewJFrame(int vertices, int source, int destination){
        this.vertices = vertices;
                this.source = source;
                this.destination = destination;
    }
public String printPath(int[] parent, int j)
	{
           
		// Base Case : If j is source
		if (parent[j] != -1)
		{
			
		
                        a=j+" "+a;
		printPath(parent, parent[j]);
                }
                 
               
                     
		return a;
	}

	// function to print the distance array
	public void printSolution(int[] dist, int n, int[] parent, int src) {
          
		
                 String distance;
		
		for (int i = 0; i < vertices; i++)
		
               
                {
                    if(destination==i){
                      
                        
			distance=dist[i]+ " ft ";
                        JOptionPane frame= new JOptionPane();
                        JOptionPane.showMessageDialog(frame,"the shortest distance to "+destination+ " is: "+distance);
                               
                        printPath(parent,i);
                        
                       JOptionPane.showMessageDialog(frame,"Follow the path from "+src+ " to: "+a);
			
                        
                    }
		}
	}
        public int minDistance(int[] dist, boolean[] ShortPathSet) {

	
		int min = Integer.MAX_VALUE;
		int min_index = -1;

		for (int v = 0; v < vertices; v++)
		{
			if (ShortPathSet[v] == false && dist[v] <= min)
			{
				min = dist[v];
                                min_index = v;
			}
		}

		return min_index;
	}
        public void dijkstra(int[][] graph, int src) {

	
		{
		int[] dist = new int[vertices];
		
		boolean[] ShortestPathSet = new boolean[vertices];

		// Parent array to store shortest path tree
		int[] parent = new int[vertices];

		// Initialize all distances as INFINITE and ShortestPathSet[] as false
		for (int i = 0; i < vertices; i++)
		{
			parent[src] = -1;
			dist[i] = Integer.MAX_VALUE;
			ShortestPathSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < vertices - 1; count++)
		{
			// Pick the minimum distance vertex from the set of
			// vertices not yet processed. u is always equal to src
			// in first iteration.
			int u = minDistance(dist, ShortestPathSet);

			// Mark the picked vertex as processed
			ShortestPathSet[u] = true;

			// Update dist value of the adjacent vertices of the
			// picked vertex.
			for (int v = 0; v <vertices; v++)
			{

				// Update dist[v] only if is not in sptSet, there is
				// an edge from u to v, and total weight of path from
				// src to v through u is smaller than current value of
				// dist[v]
				if (!ShortestPathSet[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v])
				{
					parent[v] = u;
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}

		// print the constructed distance array
		printSolution(dist, vertices, parent,src);
	}
	
        }
        public void Finish(){
            int graph[][] = new int[][]
                                            //0
                                            {{0,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,150,100,0,55,
                                             0,0,0,0,0,0},
                                             //1
                                            {0,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,70,50,
                                             0,0,0,0,0,0},
                                            //2
                                            {0,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,53,0,30,
                                             0,0,0,0,0,0},
                                            //3
                                            {0,0,0,0,30,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             24,0,0,0,0,0},
                                            //4
                                           {0,0,0,30,0,0,0,0,0,51,
                                             0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0},
                                           //5
                                           {0,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             20,0,0,0,0,30},
                                           //6
                                           {0,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             0,10,0,0,0,0},
                                           //7
                                           {0,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             0,0,10,0,0,0},
                                           //8
                                           {0,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             0,23,20,0,0,0},
                                           //9
                                           {0,0,0,0,51,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             0,0,40,0,0,0},
                                           //10
                                           {0,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             0,10,0,0,0,0},
                                           //11
                                           {0,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             0,0,0,30,24,0},
                                           //12
                                           
                                           {0,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,20,0},
                                           //13
                                           {0,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,30},
                                           //14
                                           {0,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             0,0,0,30,0,0},
                                          
                                           //15
                                           {150,0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,52,0,
                                             0,0,0,0,0,0},
                                           //16
                                           {100,0,53,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0},
                                           //17
                                           {0,70,0,0,0,0,0,0,0,0,
                                            0,0,0,0,0,52,0,0,0,
                                             0,0,0,83,0,0},
                                           //18
                                           {55,50,30,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0,0,0,0,
                                             10,0,0,0,0,0},
                                           //19
                                           {0,0,0,24,0,20,0,0,0,0,
                                             0,0,0,0,0,0,0,0,10,0,
                                             0,0,0,0,0,0},
                                           //20
                                           {0,0,0,0,0,0,10,0,23,0,
                                             10,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,22},
                                           //21
                                           {0,0,0,0,0,0,0,10,20,40,
                                             0,0,0,0,0,0,0,0,0,
                                             0,0,0,0,0,0},
                                           //22
                                           { 0,0,0,0,0,0,0,0,0,0,
                                             0,30,0,0,30,0,0,83,0,
                                             0,0,0,0,0,0},
                                           //23
                                           {0,0,0,0,0,0,0,0,0,0,
                                             0,24,20,0,0,0,0,0,0,
                                             0,0,0,0,0,21},
                                           //24
                                           {0,0,0,0,0,30,0,0,0,0,
                                             0,0,0,30,0,0,0,0,0,
                                             0,22,0,0,21,0} };
     
                                     String source1=(String) jComboBox1.getSelectedItem();
                                     source = Integer.parseInt(source1);
                                     String source2=(String)jComboBox2.getSelectedItem();
                                    destination = Integer.parseInt(source2);
                                     NewJFrame da = new NewJFrame(25, source,destination);
		da.dijkstra(graph, source); 
        }
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(255, 0, 0));
        label1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Caldwell Maps");

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel1.setText("Select Where You are");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel3.setText("Select Where You are going");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setText("Find the shortest Path");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("map.jpg")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 79, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1))
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // TODO add your handling code here:
       Finish();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
        
                
                 
                 
                 
             
               
                
                               
                          
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
