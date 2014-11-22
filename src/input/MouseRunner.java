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

    private AtomicInteger width;
    private String initialLoc;
    private String endLoc;
    private Locations[] clicked;

    public MouseRunner() {
        this.clicked = new Locations[2];
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getSource().toString());
        clicked[0] = clicked[1];
        int[] squareData = Main.getGui().getGraphicsControl().getSquare(e.getLocationOnScreen());
        if (squareData != null) {
            String squareString = new String(Character.toChars(squareData[1])).concat(Integer.toString(squareData[0]));
            System.out.println(squareString);
            int x1 = (squareString.charAt(0)) - 97;
            int y1 = Integer.parseInt(squareString.substring(1)) - 1;
            clicked[1] = new Locations(x1, y1);
            if (clicked[0] != null && clicked[1] != null) {
                if (Main.getGame().validPos(clicked[0]) == 0) {
                    Board board = Main.getGame().getBoard();
                    if (board.movePiece(clicked[0], clicked[1])) {
                        board.printBoard();
                        Main.getGui().getGraphicsControl().updateBoard(board);
                        Main.getGame().newTurn();
                        clicked[0] = clicked[1] = null;
                    }
                }
            }
        }
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
            if (clicked[1] != null) {
                Main.getGame().makeMove(initialLoc + " to " + endLoc, false);
            }
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
