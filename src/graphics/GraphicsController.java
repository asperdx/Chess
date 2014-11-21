package graphics;

import game.Board;
import game.Locations;
import pieces.Piece;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author David
 */
public class GraphicsController {

    private boolean lock;
    private Board board;
    public static final int OFFSET_SPACE = 25;

    public GraphicsController() {

    }

    void render(Graphics2D g, int width, int height, Insets insets) {
        if (!lock) {
            try {
                width -= (insets.left + insets.right);
                height -= (insets.top + insets.bottom);
                drawBoard(width, height, OFFSET_SPACE, 5, g);
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
        g.fillRect(offset, offset, width - (2 * offset), height - (2 * offset));

        //Draws white squares
        g.setColor(Color.WHITE);
        int BoardXOrigin = offset + border + ((xDist % 8) / 2);
        int BoardYOrigin = offset + border + ((yDist % 8) / 2);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                BufferedImage image = getImageFromLocation(new Locations(j, i), cellXSpace, cellYSpace);
                g.drawImage(image, BoardXOrigin + (cellXSpace * i), BoardYOrigin + (cellYSpace * j), null);
            }
        }
        drawLabels(cellXSpace, cellYSpace, border, offset, g);
        g.setColor(c);
    }

    private void drawLabels(int xSpace, int ySpace, int border, int offset, Graphics2D g) {
        int alphaX = offset / 2;
        int alphaY = ySpace / 2 +  offset + 2 * border;
        int numericX = xSpace / 2 + offset + border;
        int numericY = ySpace * 8 + 2 * offset + 2 * border;
        for (int i = 0; i < 8; i++) {
            g.drawString(Integer.toString(i + 1), numericX, numericY);
            numericX+= xSpace;
        
            g.drawString(Character.toString(Character.toChars('A' + i)[0]), alphaX, alphaY);
            alphaY+=ySpace;
        }
    }
    public void updateBoard(Board board) {
        lock = true;
        this.board = board;
        lock = false;
    }

    public BufferedImage getImageFromLocation(Locations BoardLoc, int width, int height) {
        BufferedImage tileData = new BufferedImage(width, height, BufferedImage.OPAQUE);
        Graphics2D g = tileData.createGraphics();
        g.setBackground((BoardLoc.getRow() + BoardLoc.getColumn()) % 2 == 0 ? Color.WHITE : Color.GRAY);
        g.clearRect(0, 0, width, height);
        try {           
            Piece p = board.getBoard()[BoardLoc.getRow()][BoardLoc.getColumn()];
            g.setColor(p.colorTeam.getTeam().equals("white") ? Color.BLUE : Color.RED);
            p.draw(g, width, height);     
        } catch (NullPointerException e) {

        }
        return tileData;
    }

    public int getFontHeight(int pixels) { //Unfinished
        int x = 100;
        return x;
    }
}
