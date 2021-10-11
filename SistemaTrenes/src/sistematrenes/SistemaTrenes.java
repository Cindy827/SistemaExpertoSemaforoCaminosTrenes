
package sistematrenes;

import java.awt.Color;
import static java.awt.Color.blue;
import static java.awt.Color.green;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Cindy
 */
public class SistemaTrenes extends JFrame {
    
    
    //Declaracion de variables dentro del sistema de trenes
    
    //Upper path || camino de arriba                                                                 true = verde && false = rojo
    boolean U1 = true, U2 = true, U3 = true, U4 = true, U5 = true, U6 = true, U7 = true, U8 = true;  
    //Lower path || camino de abajo                                                                  true = verde && false = rojo
    boolean L1 = true, L2 = true, L3 = true, L4 = true, L5 = true, L6 = true;
    //sotano de trenes || almacen de trenes                                                          true = libre && false = ocupado
    boolean S1 = false, S2 = true, S3 = false, S4 = false, S5 = true;
    
    JLabel labelImagen, S1O, S2O, S3O, S4O, S5O, S1L, S2L, S3L, S4L, S5L;
    JLabel U1R, U2R, U3R, U4R, U5R, U6R, U7R, U8R;
    JLabel U1G, U2G, U3G, U4G, U5G, U6G, U7G, U8G;
    JLabel L1R, L2R, L3R, L4R, L5R, L6R;
    JLabel L1G, L2G, L3G, L4G, L5G, L6G;
    
    private BufferedImage buffer;
    private Graphics graPixel;
    
    public void putSistemaTrenes(int x, int y, Color c){
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
  
    public SistemaTrenes(){
        setTitle("Sistema de trenes de Cindy");
        setSize(1000,457);
        setLayout(null);
        
        //S1O();
        
        setVisible(true);
        
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
 
        //ESTADO INICIAL DE LOS SOTANOS
        estadoInicial();
        System.out.println(" ");
        reglas();
        resultado();
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new SistemaTrenes();
    }
     
    public void reglas(){
        //reglas con premisas y conclusiones
        if(U1==true){//regla 1
            L1=false;
        }if(U6==true){//regla 2
            L6=false;
        }
        
        if(S1==false){//regla 3
            U2=false;
        }if(S2==true){//regla 4
            L2=false;
        }if(S3==false){//regla 5
            U3=false;
        }if(S3==false){//regla 6
            U4=false;
        }if(S4==false){//regla 7
            U5=false;
        }if(S5==false){//regla 8
            L5=false;
        }
        
        if((U3==false && L3==false)||(U5==false && L5==false)){//regla 9
            U1=false;
        }if((U3==false && L3==false)||(U5==false && L5==false)){//regla 10
            L1=false;           
        }if((U2==false && L2==false)||(U4==false && L4==false)){//regla 11
            U6=false;
        }if((U2==false && L2==false)||(U4==false && L4==false)){//regla 12
            L6=false;
        }if(U2==false && L2==false){//regla 13
            U7=false;
        }if(U5==false && L5==false){//regla 14
            U8=false;
        }
        
        if(U3==true){//regla 15
            U4=false;
        }if(L3==true){//regla 16
            L4=false;
        }if(U2==true){//regla 17
            L2=false;
        }if(U3==true){//regla 18
            L3=false;
        }if(U4==true){//regla 19
            L4=false;
        }if(U5==true){//regla 20
            L5=false;
        }if((U1==true)||(L1==true)){//regla 21
            U7=false;
        }if((U6==true)||(L6==true)){//regla 22
            U8=false;
        }
        
    }
    
    public void estadoInicial(){
        
                //SENTENCIAS PARA DEMOSTRAR SI LOS SOTANOS ESTAN OCUPADOS O NO     FALTA CAMBIAR POSICIONES EN PARTE GRAFICA
        if(S1==true){//Si el vagon S1 está libre
            System.out.println("S1 esta libre");
        }else if(S1==false){
            System.out.println("S1 esta ocupado");
        }
        if(S2==true){//Si el vagon S1 está libre
            System.out.println("S2 esta libre");
        }else if(S2==false){
            System.out.println("S2 esta ocupado");
        }
        if(S3==true){//Si el vagon S1 está libre
            System.out.println("S3 esta libre");
        }else if(S3==false){
            System.out.println("S3 esta ocupado");
        }
        if(S4==true){//Si el vagon S1 está libre
            System.out.println("S4 esta libre");
        }else if(S4==false){
            System.out.println("S4 esta ocupado");
        }   
        if(S5==true){//Si el vagon S1 está libre
            System.out.println("S5 esta libre");
        }else if(S5==false){
            System.out.println("S5 esta ocupado");
        }
    
        //SENTENCIAS PARA DEMOSTRAR SI LOS CAMINOS SUPERIORES ESTAN EN VERDE O EN ROJO
        if(U1==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("U1 verde");
        }else if(U1==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("U1 rojo");
        }
        if(U2==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("U2 verde");
        }else if(U2==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("U2 rojo");
        }
        if(U3==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("U3 verde");
        }else if(U3==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("U3 rojo");
        }
        if(U4==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("U4 verde");
        }else if(U4==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("U4 rojo");
        }
        if(U5==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("U5 verde");
        }else if(U5==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("U5 rojo");
        }
        if(U6==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("U6 verde");
        }else if(U6==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("U6 rojo");
        }
        if(U7==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("U7 verde");
        }else if(U7==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("U7 rojo");
        }
        if(U8==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("U8 verde");
        }else if(U8==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("U8 rojo");
        }
        //SENTENCIAS PARA DEMOSTRAR SI LOS CAMINOS INFERIORES ESTAN EN VERDE O EN ROJO
        if(L1==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("L1 verde");
        }else if(L1==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("L1 rojo");
        }
        if(L2==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("L2 verde");
        }else if(L2==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("L2 rojo");
        }
        if(L3==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("L3 verde");
        }else if(L3==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("L3 rojo");
        }
        if(L4==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("L4 verde");
        }else if(L4==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("L4 rojo");
        }
        if(L5==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("L5 verde");
        }else if(L5==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("L5 rojo");
        }
        if(L6==true){//SI EL SEMAFORO ESTA EN VERDE
            System.out.println("L6 verde");
        }else if(L1==false){//SI EL SEMAFORO ESTA EN ROJO
            System.out.println("L6 rojo");
        }
        
        
    }
    
    public void resultado(){//pasarla como argumento al graphos g
        //SENTENCIAS PARA DEMOSTRAR SI LOS SOTANOS ESTAN OCUPADOS O NO     FALTA CAMBIAR POSICIONES EN PARTE GRAFICA
        if(S1==true){//Si el vagon S1 está libre
            S1L();
            System.out.println("S1 esta libre");
        }else if(S1==false){
            S1O();
            System.out.println("S1 esta ocupado");
        }
        if(S2==true){//Si el vagon S1 está libre
            S2L();
            System.out.println("S2 esta libre");
        }else if(S2==false){
            S2O();
            System.out.println("S2 esta ocupado");
        }
   
        if(S3==true){//Si el vagon S1 está libre
            S3L();
            System.out.println("S3 esta libre");
        }else if(S3==false){
            S3O();
            System.out.println("S3 esta ocupado");
        }
        
        if(S4==true){//Si el vagon S1 está libre
            S4L();
            System.out.println("S4 esta libre");
        }else if(S4==false){
            S4O();
            System.out.println("S4 esta ocupado");
        }
        
        if(S5==true){//Si el vagon S1 está libre
            S5L();
            System.out.println("S5 esta libre");
        }else if(S5==false){
            S5O();
            System.out.println("S5 esta ocupado");
        }
        
        //SENTENCIAS PARA DEMOSTRAR SI LOS CAMINOS SUPERIORES ESTAN EN VERDE O EN ROJO
        if(U1==true){//SI EL SEMAFORO ESTA EN VERDE
            U1G();
            System.out.println("U1 verde");
        }else if(U1==false){//SI EL SEMAFORO ESTA EN ROJO
            U1R();
            System.out.println("U1 rojo");
        }
        if(U2==true){//SI EL SEMAFORO ESTA EN VERDE
            U2G();
            System.out.println("U2 verde");
        }else if(U2==false){//SI EL SEMAFORO ESTA EN ROJO
            U2R();
            System.out.println("U2 rojo");
        }
        if(U3==true){//SI EL SEMAFORO ESTA EN VERDE
            U3G();
            System.out.println("U3 verde");
        }else if(U3==false){//SI EL SEMAFORO ESTA EN ROJO
            U3R();
            System.out.println("U3 rojo");
        }
        if(U4==true){//SI EL SEMAFORO ESTA EN VERDE
            U4G();
            System.out.println("U4 verde");
        }else if(U4==false){//SI EL SEMAFORO ESTA EN ROJO
            U4R();
            System.out.println("U4 rojo");
        }
        if(U5==true){//SI EL SEMAFORO ESTA EN VERDE
            U5G();
            System.out.println("U5 verde");
        }else if(U5==false){//SI EL SEMAFORO ESTA EN ROJO
            U5R();
            System.out.println("U5 rojo");
        }
        if(U6==true){//SI EL SEMAFORO ESTA EN VERDE
            U6G();
            System.out.println("U6 verde");
        }else if(U6==false){//SI EL SEMAFORO ESTA EN ROJO
            U6R();
            System.out.println("U6 rojo");
        }
        if(U7==true){//SI EL SEMAFORO ESTA EN VERDE
            U7G();
            System.out.println("U7 verde");
        }else if(U7==false){//SI EL SEMAFORO ESTA EN ROJO
            U7R();
            System.out.println("U7 rojo");
        }
        if(U8==true){//SI EL SEMAFORO ESTA EN VERDE
            U8G();
            System.out.println("U8 verde");
        }else if(U8==false){//SI EL SEMAFORO ESTA EN ROJO
            U8R();
            System.out.println("U8 rojo");
        }
        //SENTENCIAS PARA DEMOSTRAR SI LOS CAMINOS INFERIORES ESTAN EN VERDE O EN ROJO
        if(L1==true){//SI EL SEMAFORO ESTA EN VERDE
            L1G();
            System.out.println("L1 verde");
        }else if(L1==false){//SI EL SEMAFORO ESTA EN ROJO
            L1R();
            System.out.println("L1 rojo");
        }
        if(L2==true){//SI EL SEMAFORO ESTA EN VERDE
            L2G();
            System.out.println("L2 verde");
        }else if(L2==false){//SI EL SEMAFORO ESTA EN ROJO
            L2R();
            System.out.println("L2 rojo");
        }
        if(L3==true){//SI EL SEMAFORO ESTA EN VERDE
            L3G();
            System.out.println("L3 verde");
        }else if(L3==false){//SI EL SEMAFORO ESTA EN ROJO
            L3R();
            System.out.println("L3 rojo");
        }
        if(L4==true){//SI EL SEMAFORO ESTA EN VERDE
            L4G();
            System.out.println("L4 verde");
        }else if(L4==false){//SI EL SEMAFORO ESTA EN ROJO
            L4R();
            System.out.println("L4 rojo");
        }
        if(L5==true){//SI EL SEMAFORO ESTA EN VERDE
            L5G();
            System.out.println("L5 verde");
        }else if(L5==false){//SI EL SEMAFORO ESTA EN ROJO
            L5R();
            System.out.println("L5 rojo");
        }
        if(L6==true){//SI EL SEMAFORO ESTA EN VERDE
            L6G();
            System.out.println("L6 verde");
        }else if(L1==false){//SI EL SEMAFORO ESTA EN ROJO
            L6R();
            System.out.println("L6 rojo");
        }
        
    }
    
    //IMAGENES
    public void imagen(){
        labelImagen = new JLabel();
        labelImagen.setBounds(0,0,1000,457);
        labelImagen.setIcon(new ImageIcon(getClass().getResource("/imagen/diagramaTrenes1.jpg")));
        add(labelImagen);
    }
    
     //SOTANOS OCUPADOS
     public void S1O(){
        S1O = new JLabel();
        S1O.setBounds(0,0,1000,457);
        S1O.setIcon(new ImageIcon(getClass().getResource("/imagen/S1O.png")));
        add(S1O);
    }
     public void S2O(){
        S2O = new JLabel();
        S2O.setBounds(0,0,1000,457);
        S2O.setIcon(new ImageIcon(getClass().getResource("/imagen/S2O.png")));
        add(S2O);
    }     
     public void S3O(){
        S3O = new JLabel();
        S3O.setBounds(0,0,1000,457);
        S3O.setIcon(new ImageIcon(getClass().getResource("/imagen/S3O.png")));
        add(S3O);
    }
     public void S4O(){
        S4O = new JLabel();
        S4O.setBounds(0,0,1000,457);
        S4O.setIcon(new ImageIcon(getClass().getResource("/imagen/S4O.png")));
        add(S4O);
    }
     public void S5O(){
        S5O = new JLabel();
        S5O.setBounds(0,0,1000,457);
        S5O.setIcon(new ImageIcon(getClass().getResource("/imagen/S5O.png")));
        add(S5O);
    }
     
     //SOTANOS LIBRES
     public void S1L(){
        S1L = new JLabel();
        S1L.setBounds(0,0,1000,457);
        S1L.setIcon(new ImageIcon(getClass().getResource("/imagen/S1L.png")));
        add(S1L);
    }    
     public void S2L(){
        S2L = new JLabel();
        S2L.setBounds(0,0,1000,457);
        S2L.setIcon(new ImageIcon(getClass().getResource("/imagen/S2L.png")));
        add(S2L);
    }   
     public void S3L(){
        S3L = new JLabel();
        S3L.setBounds(0,0,1000,457);
        S3L.setIcon(new ImageIcon(getClass().getResource("/imagen/S3L.png")));
        add(S3L);
    }
     public void S4L(){
        S4L = new JLabel();
        S4L.setBounds(0,0,1000,457);
        S4L.setIcon(new ImageIcon(getClass().getResource("/imagen/S4L.png")));
        add(S4L);
    }
     public void S5L(){
        S5L = new JLabel();
        S5L.setBounds(0,0,1000,457);
        S5L.setIcon(new ImageIcon(getClass().getResource("/imagen/S5L.png")));
        add(S5L);
    }
     
     //FREE UPPER PATH 
     public void U1G(){
        U1G = new JLabel();
        U1G.setBounds(0,0,1000,457);
        U1G.setIcon(new ImageIcon(getClass().getResource("/imagen/U1G.png")));
        add(U1G);
    }
     public void U2G(){
        U2G = new JLabel();
        U2G.setBounds(0,0,1000,457);
        U2G.setIcon(new ImageIcon(getClass().getResource("/imagen/U2G.png")));
        add(U2G);
    }
     public void U3G(){
        U3G = new JLabel();
        U3G.setBounds(0,0,1000,457);
        U3G.setIcon(new ImageIcon(getClass().getResource("/imagen/U3G.png")));
        add(U3G);
    }
     public void U4G(){
        U4G = new JLabel();
        U4G.setBounds(0,0,1000,457);
        U4G.setIcon(new ImageIcon(getClass().getResource("/imagen/U4G.png")));
        add(U4G);
    }
     public void U5G(){
        U5G = new JLabel();
        U5G.setBounds(0,0,1000,457);
        U5G.setIcon(new ImageIcon(getClass().getResource("/imagen/U5G.png")));
        add(U5G);
    }
     public void U6G(){
        U6G = new JLabel();
        U6G.setBounds(0,0,1000,457);
        U6G.setIcon(new ImageIcon(getClass().getResource("/imagen/U6G.png")));
        add(U6G);
    }
     public void U7G(){
        U7G = new JLabel();
        U7G.setBounds(0,0,1000,457);
        U7G.setIcon(new ImageIcon(getClass().getResource("/imagen/U7G.png")));
        add(U7G);
    }
     public void U8G(){
        U8G = new JLabel();
        U8G.setBounds(0,0,1000,457);
        U8G.setIcon(new ImageIcon(getClass().getResource("/imagen/U8G.png")));
        add(U8G);
    }
     
     //BUSSY UPPER PATH
     public void U1R(){
        U1R = new JLabel();
        U1R.setBounds(0,0,1000,457);
        U1R.setIcon(new ImageIcon(getClass().getResource("/imagen/U1R.png")));
        add(U1R);
    }
     public void U2R(){
        U2R = new JLabel();
        U2R.setBounds(0,0,1000,457);
        U2R.setIcon(new ImageIcon(getClass().getResource("/imagen/U2R.png")));
        add(U2R);
    }
     public void U3R(){
        U3R = new JLabel();
        U3R.setBounds(0,0,1000,457);
        U3R.setIcon(new ImageIcon(getClass().getResource("/imagen/U3R.png")));
        add(U3R);
    }
     public void U4R(){
        U4R = new JLabel();
        U4R.setBounds(0,0,1000,457);
        U4R.setIcon(new ImageIcon(getClass().getResource("/imagen/U4R.png")));
        add(U4R);
    }
     public void U5R(){
        U5R = new JLabel();
        U5R.setBounds(0,0,1000,457);
        U5R.setIcon(new ImageIcon(getClass().getResource("/imagen/U5R.png")));
        add(U5R);
    }
     public void U6R(){
        U6R = new JLabel();
        U6R.setBounds(0,0,1000,457);
        U6R.setIcon(new ImageIcon(getClass().getResource("/imagen/U6R.png")));
        add(U6R);
    }
     public void U7R(){
        U7R = new JLabel();
        U7R.setBounds(0,0,1000,457);
        U7R.setIcon(new ImageIcon(getClass().getResource("/imagen/U7R.png")));
        add(U7R);
    }
     public void U8R(){
        U8R = new JLabel();
        U8R.setBounds(0,0,1000,457);
        U8R.setIcon(new ImageIcon(getClass().getResource("/imagen/U8R.png")));
        add(U8R);
    }
     
     
     //FREE LOWER PATH
     public void L1G(){
        L1G = new JLabel();
        L1G.setBounds(0,0,1000,457);
        L1G.setIcon(new ImageIcon(getClass().getResource("/imagen/L1G.png")));
        add(L1G);
    }
     public void L2G(){
        L2G = new JLabel();
        L2G.setBounds(0,0,1000,457);
        L2G.setIcon(new ImageIcon(getClass().getResource("/imagen/L2G.png")));
        add(L2G);
    }
     public void L3G(){
        L3G = new JLabel();
        L3G.setBounds(0,0,1000,457);
        L3G.setIcon(new ImageIcon(getClass().getResource("/imagen/L3G.png")));
        add(L3G);
    }
     public void L4G(){
        L4G = new JLabel();
        L4G.setBounds(0,0,1000,457);
        L4G.setIcon(new ImageIcon(getClass().getResource("/imagen/L4G.png")));
        add(L4G);
    }
     public void L5G(){
        L5G = new JLabel();
        L5G.setBounds(0,0,1000,457);
        L5G.setIcon(new ImageIcon(getClass().getResource("/imagen/L5G.png")));
        add(L5G);
    }
     public void L6G(){
        L6G = new JLabel();
        L6G.setBounds(0,0,1000,457);
        L6G.setIcon(new ImageIcon(getClass().getResource("/imagen/L6G.png")));
        add(L6G);
    }
     
     
     //BUSSY LOWER PATH
     public void L1R(){
        L1R = new JLabel();
        L1R.setBounds(0,0,1000,457);
        L1R.setIcon(new ImageIcon(getClass().getResource("/imagen/L1R.png")));
        add(L1R);
    }
     public void L2R(){
        L2R = new JLabel();
        L2R.setBounds(0,0,1000,457);
        L2R.setIcon(new ImageIcon(getClass().getResource("/imagen/L2R.png")));
        add(L2R);
    }
     public void L3R(){
        L3R = new JLabel();
        L3R.setBounds(0,0,1000,457);
        L3R.setIcon(new ImageIcon(getClass().getResource("/imagen/L3R.png")));
        add(L3R);
    }
     public void L4R(){
        L4R = new JLabel();
        L4R.setBounds(0,0,1000,457);
        L4R.setIcon(new ImageIcon(getClass().getResource("/imagen/L4R.png")));
        add(L4R);
    }
     public void L5R(){
        L5R = new JLabel();
        L5R.setBounds(0,0,1000,457);
        L5R.setIcon(new ImageIcon(getClass().getResource("/imagen/L5R.png")));
        add(L5R);
    }
     public void L6R(){
        L6R = new JLabel();
        L6R.setBounds(0,0,1000,457);
        L6R.setIcon(new ImageIcon(getClass().getResource("/imagen/L6R.png")));
        add(L6R);
    }
     
     

    
    
    private void setOpaque(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
