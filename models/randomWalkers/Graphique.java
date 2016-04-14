
/**
 * Class randomWalkers.Graphique.java
 *
 *
 * Created: Tue Sep 19 09:34:47 2000
 *
 * @author frederic.falempin@enst-bretagne.fr, Gregory.Gackel@enst-bretagne.fr
 * @version 1.2  august,5, 2002
* @version 1.4. february 2004   
 */

   package models.randomWalkers;

   import modulecoGUI.grapheco.graphix.Trace;

   import java.awt.Color;

   public class Graphique extends modulecoGUI.grapheco.graphix.Graphique 
   {    
      public Graphique() 
      {
         super();
      
         this.addTrace(new Trace("distance From Beginning", Color.black, "FromBeginning"), true);
      //	this.addTrace(new Trace("Ant alives", Color.blue, "Living"), true);
      }   
   } // Graphique
