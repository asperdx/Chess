/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import game.Board;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author David
 */
public class GraphicsController {

    private boolean lock;
    private Board board;

    public GraphicsController() {

    }

    void render(Graphics2D g, int width, int height) {
        if (!lock) {
            try{
            drawBoard(width, height, 25, g);
            }catch (RenderException e){
                System.out.println("Rendering error: " + e.getMessage());
            }
        }
    }

    private void drawBoard(int width, int height, int offset, Graphics2D g) throws RenderException {
        
        if (width < offset * 2 || height < offset * 2) {
            throw new RenderException("Window too small, skipping rendering");
        }
        int xDist = width - (offset * 2);
        int yDist = height - (offset * 2);
        int cellXSpace = --xDist / 8;
        int cellYSpace = --yDist / 8;
        int borderYSpace = (xDist % 8) + 1;
        int borderXSpace = (yDist % 8) + 1;
        g.setColor(Color.BLUE);
        g.drawRect(offset, offset, xDist, yDist);
    }

    public void updateBoard(Board board) {
        lock = true;
        this.board = board;
        lock = false;
    }

}
