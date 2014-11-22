/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import game.Main;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author David
 */
public class MouseRunner implements MouseListener {

    private AtomicInteger width;
    private String initialLoc;
    private String endLoc;

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int[] squareData = Main.getGui().getGraphicsControl().getSquare(e.getLocationOnScreen());
        if (squareData != null) {
            initialLoc = (new String(Character.toChars(squareData[1])).concat(Integer.toString(squareData[0])));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int[] squareData = Main.getGui().getGraphicsControl().getSquare(e.getLocationOnScreen());
        if (squareData != null) {
            endLoc = (new String(Character.toChars(squareData[1])).concat(Integer.toString(squareData[0])));
            System.out.println(initialLoc + " to " + endLoc);
            Main.getGame().makeMove(initialLoc + " to " + endLoc);
            initialLoc = endLoc = "";
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
