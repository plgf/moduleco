 /* Source File Name:   Canevas.java
 * Copyright:    Copyright (c)enst-bretagne
 * @author denis.phan@enst-bretagne.fr
 * @version 1.2  august,5, 2002  
 */

   package models.lux;

   import modulecoFramework.modeleco.EWorld;
   import modulecoFramework.modeleco.CAgent;

   import java.awt.Graphics;
   import java.awt.Color;

   public class Canevas extends modulecoGUI.grapheco.Canevas
   {
   
      protected double state [][];
      protected Color c[];
      protected int OPT=0,PESS=1,FOND=2;
   
      public Canevas()
      {
         super();
      }
   
   
      public void setCAgent(CAgent cAgent)
      {
         this.eWorld = (EWorld) cAgent;
         c = ((World) eWorld).getColors();
         size = (new Double(Math.sqrt(eWorld.getAgentSetSize()))).intValue();
         state = new double [size][size];
         for(int i = 0; i < size ; i++)
            for(int j = 0; j < size ; j++)
            {
               state[j][i] = ((Agent) eWorld.get(j*size+i)).getEtat() ;
            }
         drawAble =true; // DP 20/08/2002
      }
   
      protected void drawPoint(Graphics g, int i, int j,int a, int b, int x, int y) 
      {
         if (eWorld != null)
         {
            int i1,j1;
            if (  ( (Integer) ((Agent) eWorld.get(j*size+i)).getState() ).intValue()==OPT  ) 
               g.setColor(new Color(0,255,0)); 
            else if (  ( (Integer) ((Agent) eWorld.get(j*size+i)).getState() ).intValue()==PESS  ) 
               g.setColor(new Color(255,0,0));
            else g.setColor(new Color(0,0,255));
         
            i1 = i * a;
            j1 = j * b;
            if(size<40){
            // dessine un secteur circulaire
            // x,y, largeur, hauteur,debut arc, fin arc)
               g.fillArc(i1 + 1 + x/2, j1 + 1 + y/2, a - 2, b - 2, 0, 360);
            }
            else{
               g.fillRect(i1 + 1 + x/2, j1 + 1 + y/2, a, b);
            }
         //x,y,largeur, hauteur
         }
      }
   
   
   }
