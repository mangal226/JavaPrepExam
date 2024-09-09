package src.implementLocalization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextHitInfo;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Hashtable;

public class SelectionDemo extends JPanel {
    private static String mixed = "\u05D0\u05E0\u05D9 Hello \u05DC\u05D0 \u05DE\u05D1\u05D9\u05DF "
            + "\u05E2\u05D1\u05E8\u05D9\u05EA Arabic \u0644\u0645\u062C\u0645\u0648\u0639\u0629";;
    private static final FontRenderContext DEFAULT_FRC = new FontRenderContext(null, false, false);
    private static JFrame jFrame;
    private static final Hashtable<TextAttribute, Object> map = new Hashtable<>();
        static {
            map.put(TextAttribute.FAMILY, "Serif");
            map.put(TextAttribute.SIZE, "24.0F");
        }


    private static final Color STRONG_CARET_COLOR = Color.red;
    private static final Color WEAK_CARET_COLOR = Color.black;
    private static final Color HIGHLIGHT_COLOR = Color.pink;
    private static final Color TEXT_COLOR = Color.black;
    private TextLayout textLayout;
    private int anchorEnd;
    private int activeEnd;
    public SelectionDemo(){
        AttributedString attributedMixed = new AttributedString(mixed, map);
        AttributedCharacterIterator text = attributedMixed.getIterator();

        textLayout = new TextLayout(text, DEFAULT_FRC);

        anchorEnd = 0;
        activeEnd = 0;

        addMouseListener(new SelectionMouseListener());
        addMouseMotionListener(new SelectionMouseMotionListener());
    }

    private static void createAndShowGUI() {

        // Create and set up the window.

        SelectionDemo demo = new SelectionDemo();
        jFrame = new JFrame("Selection Sample");

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add contents to the window.

        jFrame.add(demo);
        jFrame.setBackground(Color.white);

        // Display the window.
        jFrame.pack();
        jFrame.setSize(new Dimension(400, 250));
        jFrame.setVisible(true);
    }

    /**
     * Compute a location within this Panel for textLayout's origin, such that
     * textLayout is centered horizontally and vertically.
     *
     * Note that this location is unknown to textLayout; it is used only by this
     * Panel for positioning.
     */
    private Point2D computeLayoutOrigin() {
        Dimension size = getSize();
        Point2D.Float origin = new Point2D.Float();
        origin.x = (size.width - textLayout.getAdvance()) / 2;
        origin.y = (size.height - textLayout.getDescent() + textLayout.getAscent()) / 2;
        return origin;
    }

    /**
     * Draw textLayout and either: the selection range (if a range of characters
     * is selected), or the carets (if the selection range is 0-length).
     */

    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        Point2D origin = computeLayoutOrigin();

        // Since the selection and caret Shapes are relative to the
        // origin of textLayout, we'll translate the graphics so that
        // the origin of the graphics is where we want textLayout to
        // appear.

        graphics2D.translate(origin.getX(), origin.getY());

        // If the insertion indices of the two selection endpoints
        // are equal, the method we will draw caret(s) at the insertion index.
        // Otherwise we will draw a highlight region between the
        // insertion indices.

        boolean haveCaret = anchorEnd == activeEnd;

        if (!haveCaret) {
            // Retrieve highlight region for selection range.
            Shape highlight = textLayout.getLogicalHighlightShape(anchorEnd,
                    activeEnd);
            // Fill the highlight region with the highlight color.
            graphics2D.setColor(HIGHLIGHT_COLOR);
            graphics2D.fill(highlight);
        }

        // Draw textLayout.
        graphics2D.setColor(TEXT_COLOR);
        textLayout.draw(graphics2D, 0, 0);

        if (haveCaret) {
            // Retrieve caret Shapes for the insertion index.
            Shape[] carets = textLayout.getCaretShapes(anchorEnd);

            // Draw the carets. carets[0] is the strong caret, and
            // is never null. carets[1], if it is not null, is the
            // weak caret.
            graphics2D.setColor(STRONG_CARET_COLOR);
            graphics2D.draw(carets[0]);

            if (carets[1] != null) {
                graphics2D.setColor(WEAK_CARET_COLOR);
                graphics2D.draw(carets[1]);
            }
        }
    }

    /**
     * Set the active selection endpoint to the character position of the mouse.
     */

    private class SelectionMouseMotionListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            Point2D origin = computeLayoutOrigin();
            // Compute the mouse location relative to
            // textLayout's origin.
            float clickX = (float) (e.getX() - origin.getX());
            float clickY = (float) (e.getY() - origin.getY());
            // Get the character position of the mouse location.
            TextHitInfo position = textLayout.hitTestChar(clickX, clickY);
            int newActiveEnd = position.getInsertionIndex();
            // If newActiveEnd is different from activeEnd, update activeEnd
            // and repaint the Panel so the new selection will be displayed.
            if (activeEnd != newActiveEnd) {
                activeEnd = newActiveEnd;
                jFrame.repaint();
            }
        }
    }

    /**
     * Set the active and anchor selection endpoints to the character position of
     * the mouse click.
     */

    private class SelectionMouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            Point2D origin = computeLayoutOrigin();
            // Compute the mouse location relative to
            // TextLayout's origin.
            float clickX = (float) (e.getX() - origin.getX());
            float clickY = (float) (e.getY() - origin.getY());
            // Set the anchor and active ends of the selection
            // to the character position of the mouse location.
            TextHitInfo position = textLayout.hitTestChar(clickX, clickY);
            anchorEnd = position.getInsertionIndex();
            activeEnd = anchorEnd;
            // Repaint the Panel so the new selection will be displayed.
            jFrame.repaint();
        }
    }

    public static void main(String[] args) {
        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}
