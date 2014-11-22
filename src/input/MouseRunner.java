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
        if (Main.getGui().getGraphicsControl().getInnerBoardBounds().contains(e.getPoint())) {
            clicked[0] = clicked[1];
            Locations squareData = Main.getGui().getGraphicsControl().getSquare(e.getPoint());
            if (squareData != null) {
                String squareString = Locations.toCoordinateString(squareData);
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

                        }
                    }
                    clicked[0] = clicked[1] = null;
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (Main.getGui().getGraphicsControl().getInnerBoardBounds().contains(e.getPoint())) {
            Locations squareData = Main.getGui().getGraphicsControl().getSquare(e.getPoint());
            if (squareData != null) {
                initialLoc = Locations.toCoordinateString(squareData);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (Main.getGui().getGraphicsControl().getInnerBoardBounds().contains(e.getPoint())) {
            Locations squareData = Main.getGui().getGraphicsControl().getSquare(e.getPoint());
            if (squareData != null) {
                initialLoc = Locations.toCoordinateString(squareData);
                System.out.println(initialLoc + " to " + endLoc);
                if (clicked[1] != null) {
                    Main.getGame().makeMove(initialLoc + " to " + endLoc, false);
                }
                initialLoc = endLoc = "";
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
