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
    public static final int BORDER_SPACE = 5;
    private Insets insets;
    private int[] boardData;

    public GraphicsController(Insets insets) {
        this.insets = insets;
        boardData = new int[2];
    }

    /**
     * Executes the render instructions for the board
     *
     * @param g the graphics context
     * @param width the width of the canvas to draw on
     * @param height the height of the canvas to draw on
     */
    void render(Graphics2D g, int width, int height) {
        if (!lock) {
            updateVals(width, height);
            try {
                width -= (insets.left + insets.right);
                height -= (insets.top + insets.bottom);
                boardData[0] = width / 2;
                boardData[1] = height / 2;
                drawBoard(boardData[0], boardData[1], g);
                Color c = g.getColor();
                g.setColor(c);
            } catch (RenderException e) {
                System.out.println("Rendering error: " + e.getMessage());
            }
        }

    }

    /**
     * Draws the entire chess board, including pieces and labels
     *
     * @param width the width of the board.
     * @param height the height of the board.
     * @param g the graphics context
     * @throws RenderException is window is too small;
     */
    private void drawBoard(int width, int height, Graphics2D g) throws RenderException {
        Color c = g.getColor();
        if (width < OFFSET_SPACE * 2 + 10 || height < OFFSET_SPACE * 2 + 10) {
            throw new RenderException("Window too small, skipping rendering");
        }
        //Draws borders, keeping interior distances % 8 == 0
        g.setColor(Color.BLUE);
        g.fill(getBoardBounds());
        //Draws white squares
        Rectangle theBoard = getInnerBoardBounds();
        int cellWidth = theBoard.width / 8;
        int cellHeight = theBoard.height / 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                BufferedImage image = getImageFromLocation(new Locations(j, i), cellWidth, cellHeight);
                g.drawImage(image, theBoard.x + (cellWidth * i), theBoard.y + (cellHeight * j), null);
            }
        }
        g.setColor(Color.WHITE);
        drawLabels(cellWidth, cellHeight, g);
        g.setColor(c);
    }

    /**
     * Draws the labels surrounding the board.
     *
     * @param xSpace the width of a cell
     * @param ySpace the height of a Cell in the
     * @param g the graphics context
     */
    private void drawLabels(int xSpace, int ySpace, Graphics2D g) {
        int alphaX = OFFSET_SPACE / 2;
        int alphaY = ySpace / 2 + OFFSET_SPACE + 2 * BORDER_SPACE;
        int numericX = xSpace / 2 + OFFSET_SPACE + BORDER_SPACE;
        int numericY = ySpace * 8 + 2 * OFFSET_SPACE + 2 * BORDER_SPACE;
        for (int i = 0; i < 8; i++) {
            g.drawString(Integer.toString(i + 1), numericX, numericY);
            numericX += xSpace;

            g.drawString(Character.toString(Character.toChars('A' + i)[0]), alphaX, alphaY);
            alphaY += ySpace;
        }
    }

    /**
     * Updates the board data
     *
     * @param board the new board
     */
    public void updateBoard(Board board) {
        lock = true;
        this.board = board;
        lock = false;
    }

    /**
     * Draws a BufferedImage containing the graphics for a given square
     *
     * @param BoardLoc the square on the board
     * @param width the width of the image
     * @param height the height of the image
     * @return a drawn BufferedImage containing the graphics for a given square
     */
    public BufferedImage getImageFromLocation(Locations BoardLoc, int width, int height) {
        BufferedImage tileData = new BufferedImage(width, height, BufferedImage.OPAQUE);
        Graphics2D g = tileData.createGraphics();
        g.setBackground((BoardLoc.getRow() + BoardLoc.getColumn()) % 2 == 0 ? Color.WHITE : Color.GRAY);
        g.clearRect(0, 0, width, height);
        try {
            Piece p = board.getBoard()[BoardLoc.getRow()][BoardLoc.getColumn()];
            g.setColor(p.colorTeam.getTeam().equals("white") ? Color.BLUE : Color.RED);
            g.setFont(g.getFont().deriveFont(getFontHeight(height - 4)));
            p.draw(g, width, height);
        } catch (NullPointerException e) {

        }
        return tileData;
    }

    /**
     * Calculates the point font height for a given number of pixels
     *
     * @param pixels the intended height in pixels of the text
     * @return a float representing the point size of the font
     */
    public float getFontHeight(int pixels) {
        double fontSize = pixels * Toolkit.getDefaultToolkit().getScreenResolution() / 72.0;
        return (float) fontSize;
    }

    /**
     *
     * @param pixelPoint a point in the coordinate space of the board
     * @return a Location object representing the grid position of location
     * @return null if the point is not inside the board
     */
    public Locations getSquare(Point pixelPoint) {

        Rectangle theBoard = this.getInnerBoardBounds();
        if (this.getInnerBoardBounds().contains(pixelPoint)) {
            int x = pixelPoint.x - (theBoard.x);
            int y = pixelPoint.y - (theBoard.y);
            Locations loc = new Locations(y / (theBoard.height / 8), x / (theBoard.width / 8));
            //System.out.println(loc.toString());
            return loc;
        }
        return null;
    }

    /**
     * Updates the width and height of the board drawn to the screen
     *
     * @param width the new width of the board
     * @param height the new height of the board
     */
    private void updateVals(int width, int height) {
        boardData[0] = width;
        boardData[1] = height;
    }

    /**
     *
     * @return the height of the board on the screen, including borders and
     * labels
     */
    public int getWidth() {
        return boardData[0];
    }

    /**
     *
     * @return the height of the board on the screen, including borders and
     * labels
     */
    public int getHeight() {
        return boardData[1];
    }

    /**
     *
     * @return A rectangle representing the area of the board, with borders.
     */
    public Rectangle getBoardBounds() {
        Rectangle r = new Rectangle();
        r.setLocation(new Point(OFFSET_SPACE, OFFSET_SPACE));
        r.setSize(boardData[0] - 2 * OFFSET_SPACE, boardData[1] - 2 * OFFSET_SPACE);
        return r;
    }

    /**
     *
     * @return A rectangle representing the area of the board, without borders.
     */
    public Rectangle getInnerBoardBounds() {
        Rectangle r = new Rectangle();
        int w = boardData[0] - 2 * (OFFSET_SPACE + BORDER_SPACE);
        int h = boardData[1] - 2 * (OFFSET_SPACE + BORDER_SPACE);
        int XOrigin = OFFSET_SPACE + BORDER_SPACE + ((w % 8) / 2);
        int YOrigin = OFFSET_SPACE + BORDER_SPACE + ((h % 8) / 2);
        r.setLocation(XOrigin, YOrigin);
        w = (w / 8) * 8;
        h = (h / 8) * 8;
        r.setSize(w, h);
        return r;
    }

}
