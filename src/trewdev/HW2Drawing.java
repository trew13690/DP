package trewdev;

/**
 *  HW2Drawing produces two panels; One panels draws a parabola shape using lines and panel 2 draws assorted shapes;
 * @author trew
 * @version 4-14-19
 */

import java.awt.*;
import java.util.Random;


public class HW2Drawing {
    private final static int WIDTH1 = 500;
    private final static int HEIGHT1 = 500;

    private final static int WIDTH2 = 400;
    private final static int HEIGHT2 = 400;

    private final static int INTERVAL = 5;


    private final static int RECX_1 = 200;
    private final static int RECY_1 = 0;

    private final static int RECX_2 = 400;
    private final static int RECY_2 = 200;

    private final static int CIRX_1 = 100;
    private final static int CIRY_1 = 100;
    private final static int CIRX_2 = 20;
    private final static int CIRY_2 = 20;

    private final static Color CIR_COLOR = Color.blue;

    private final static Color REC_COLOR = Color.RED;

    private final static Color SECOND_PANEL_COLOR = Color.WHITE;

    public static void main(String[] args) {
        appRun();
    }

    /**
     * AppRun - Creates the two panels and calls the drawing methods
     *
     */
    private static void appRun() {
        DrawingPanel mainPanel = new DrawingPanel(WIDTH1, HEIGHT1);
        DrawingPanel secondPanel = new DrawingPanel(WIDTH2, HEIGHT2);
        secondPanel.setBackground(SECOND_PANEL_COLOR);
        mainPanel.getGraphics();
        drawAmazingLines(mainPanel, INTERVAL);
        drawAmazingShapes(secondPanel);
    }

    /**
     * drawAmazingLines loops drawing lines creating a parabolalookingg diagram
     * @param p - Drawing panel to be drawn upon
     * @param intervels - How many lines to draw in each quadrant
     */
    private static void drawAmazingLines(DrawingPanel p, int intervels ) {
        Random randColor = new Random();

        for (int i = 0; i < p.getWidth() / 2 / intervels + 1; i++) {
//            Generate lines for first quad
            p.getGraphics().setPaint(new Color(randColor.nextInt()));
            p.getGraphics().drawLine(p.getWidth() / 2, i * intervels, p.getWidth() / 2 + intervels * i, p.getHeight() / 2);
//            Generate lines for second quad
            p.getGraphics().setPaint(Color.magenta);
            p.getGraphics().drawLine(p.getWidth() / 2, i * intervels, p.getWidth() / 2 - intervels * i, p.getHeight() / 2);
//            Generate lines for third quad
            p.getGraphics().setPaint(Color.CYAN);
            p.getGraphics().drawLine(p.getWidth() / 2, p.getHeight() - (i * intervels), p.getWidth() / 2 - intervels * i, p.getHeight() / 2);
//            Generate lines for fourth quad
            p.getGraphics().setPaint(Color.GREEN);
            p.getGraphics().drawLine(p.getWidth() / 2, p.getHeight() - (i * intervels), p.getWidth() / 2 + intervels * i, p.getHeight() / 2);
        }



    }

    /**
     * drawAmazingShapes calls methods which draw each type of shape
     * @param p - Drawing Panel in which to draw on;
     */
    private static void drawAmazingShapes(DrawingPanel p) {

        createRec(p, RECX_1, RECY_1, RECX_2, RECY_2, REC_COLOR);
        createCir(p, CIRX_1, CIRY_1, CIRX_2, CIRY_2, CIR_COLOR);
        createManyShapes(p);

    }

    /**
     * createManyShapes loops though making smaller and smaller squares with random colors
     * @param p
     */
    private static void createManyShapes(DrawingPanel p) {
        Random sRandom = new Random();


        for (int i = 1; i <= 5; i++) {
            p.getGraphics().setPaint(new Color(sRandom.nextInt()));
            p.getGraphics().fillRect(0, p.getHeight() / 2, (p.getWidth() / 2) / i, (p.getHeight() / 2) / i);
        }
    }

    /**
     * createRec will make a rectangle
     * @param p - the drawing panel to be drawn upon
     * @param x1 - the inital x coordinate
     * @param y1 - the inital y coordinate
     * @param x2 - the width of the rectangle
     * @param y2 - the height of the rectangle
     * @param c - the color of the rectangle
     */
    private static void createRec(DrawingPanel p, int x1, int y1, int x2, int y2, Color c) {


        p.getGraphics().setPaint(c);
        p.getGraphics().fillRect(x1, y1, x2, y2);

    }

    /**
     * createCir creates a circle with a color
     * @param p - the drawing panel which the shape is drawn on
     * @param x1 - the initial x coordinate
     * @param y1 - the initial y coordinate
     * @param x2 - the width of the oval
     * @param y2 - the height of the oval
     * @param c  - the color of the oval
     */
    private static void createCir(DrawingPanel p, int x1, int y1, int x2, int y2, Color c) {
        p.getGraphics().setPaint(c);
        p.getGraphics().fillOval(x1 , y1, x2, y2);


    }
}
