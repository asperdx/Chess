/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import game.Board;
import game.Locations;
import game.Main;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 *
 * @author David
 */
public class InputHandler {

    public static final int MOUSE_CLICKED = 0;
    public static final int MOUSE_RELEASED = 1;
    public static final int MOUSE_PRESSED = 2;
    private static int lastAction = -1;
    private static Locations[] moves;
    private static boolean drag = false;
    private static Point dragStart = null;

    public static void handleInput(int mouseCode, MouseEvent e) {
        if (checkPointLoc(e.getPoint())) {
            if (mouseCode == MOUSE_CLICKED) {
                store(Main.getGui().getGraphicsControl().getSquare(e.getPoint()), MOUSE_CLICKED);
            }
            if (mouseCode == MOUSE_PRESSED) {
                //store(Main.getGui().getGraphicsControl().getSquare(e.getPoint()), MOUSE_PRESSED);
            }
            if( mouseCode == MOUSE_RELEASED && drag){
                moves[0] = Main.getGui().getGraphicsControl().getSquare(dragStart);
                moves[1] =  Main.getGui().getGraphicsControl().getSquare(e.getPoint());
                ExecuteMove();
            }
        }
    }

    private static boolean checkPointLoc(Point e) {
        return Main.getGui().getGraphicsControl().getInnerBoardBounds().contains(e);
    }

    public static void setup() {
        moves = new Locations[2];
    }

    private static void store(Locations square, int InputCode) {
        moves[0] = moves[1];
        if (InputCode == lastAction) {
            moves[1] = square;
            if(moves[0] != null)
            ExecuteMove();
        } else {
            moves[0] = null;
            moves[1] = square;
            lastAction = InputCode;
        }
    }

    private static void ExecuteMove() {
        String moveString = Locations.toCoordinateString(moves[0]) + " to " +
                 Locations.toCoordinateString(moves[1]);
        System.out.println(moveString);
      Main.getGame().makeMove(moveString, true);
    }

    static void startDrag(Point point) {
        drag = true;
        dragStart = point;
    }
}
