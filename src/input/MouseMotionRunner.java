/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import game.Locations;
import game.Main;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author David
 */
public class MouseMotionRunner implements MouseMotionListener {

    public MouseMotionRunner() {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       InputHandler.startDrag(e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Locations l = Main.getGui().getGraphicsControl().getSquare(e.getPoint());
        //if (l != null)
        //System.out.println(Locations.toCoordinateString(l));
    }
    
}
