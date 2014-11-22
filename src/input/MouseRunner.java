/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import game.Board;
import game.Locations;
import game.Main;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author David
 */
public class MouseRunner implements MouseListener {


    public MouseRunner() {
        InputHandler.setup();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        InputHandler.handleInput(0, e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        InputHandler.handleInput(1, e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         InputHandler.handleInput(1, e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
