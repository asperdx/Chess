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
                drawBoard(width, height, 25, g);
            } catch (RenderException e) {
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
        int borderYSpace = (xDist % 8) + 1;
        int borderXSpace = (yDist % 8) + 1;
        int cellXSpace = (xDist - borderXSpace) / 8;
        int cellYSpace = (yDist - borderYSpace) / 8;
        g.setColor(Color.BLUE);

        //Draws borders, keeping interior distances % 8 == 0
        g.fillRect(offset, offset, xDist, borderYSpace);
        g.fillRect(offset, offset, borderXSpace, yDist);
        g.fillRect(xDist + offset - borderXSpace, offset, borderXSpace, yDist);
        g.fillRect(offset, height - (offset + borderYSpace), xDist, borderYSpace);

        //Draws white squares
        g.setColor(Color.WHITE);
        int BoardXOrigin = offset + borderXSpace;
        int BoardYOrigin = offset + borderYSpace;
        g.drawLine(BoardXOrigin, BoardYOrigin, BoardXOrigin, BoardYOrigin);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((j + i) % 2 == 1) {
                    g.fillRect(BoardXOrigin + (cellXSpace * i), 
                            BoardYOrigin + (cellYSpace * j), cellXSpace, cellYSpace);
                }
            }
        }
        //Draws Gray Squares
        g.setColor(Color.GRAY);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((j + i) % 2 == 0) {
                    g.fillRect(BoardXOrigin + (cellXSpace * i), 
                            BoardYOrigin + (cellYSpace * j), cellXSpace, cellYSpace);
                }
            }
        }
    }

    public void updateBoard(Board board) {
        lock = true;
        this.board = board;
        lock = false;
    }

}
