package graphics;

import game.Board;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;

/**
 *
 * @author David
 */
public class GraphicsController {

    private boolean lock;
    private Board board;

    public GraphicsController() {

    }

    void render(Graphics2D g, int width, int height, Insets insets) {
        if (!lock) {
            try {
                width -= (insets.left + insets.right);
                height -= (insets.top + insets.bottom);
                drawBoard(width, height, 25, 5, g);
            } catch (RenderException e) {
                System.out.println("Rendering error: " + e.getMessage());
            }
        }

    }

    private void drawBoard(int width, int height, int offset, int border, Graphics2D g) throws RenderException {
        Color c = g.getColor();
        if (width < offset * 2 || height < offset * 2) {
            throw new RenderException("Window too small, skipping rendering");
        }        
        int xDist = width - ((offset + border) * 2);
        int yDist = height - ((offset + border) * 2);
        int cellXSpace = xDist / 8;
        int cellYSpace = yDist / 8;
        g.setColor(Color.BLUE);

        //Draws borders, keeping interior distances % 8 == 0
        g.fillRect(offset, offset, width - (2 * offset) , height - (2 * offset) );

        //Draws white squares
        g.setColor(Color.WHITE);
        int BoardXOrigin = offset + border + ((xDist % 8 ) / 2) ;
        int BoardYOrigin = offset + border + ((yDist % 8 ) / 2);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((j + i) % 2 == 0) {
                    g.fillRect(BoardXOrigin + (cellXSpace * i), 
                            BoardYOrigin + (cellYSpace * j), cellXSpace, cellYSpace);
                }
            }
        }
        //Draws Gray Squares
        g.setColor(Color.GRAY);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((j + i) % 2 == 1) {
                    g.fillRect(BoardXOrigin + (cellXSpace * i), 
                            BoardYOrigin + (cellYSpace * j), cellXSpace, cellYSpace);
                }
            }
        }
        g.setColor(c);
    }

    public void updateBoard(Board board) {
        lock = true;
        this.board = board;
        lock = false;
    }

}
