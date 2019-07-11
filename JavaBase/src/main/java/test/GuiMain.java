package test;


import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;

public class GuiMain
{
  private static final int WIDTH = 1100;
  private static final int HEIGHT = 750;
  private static TextArea textArea;
  private static TextArea resulTextArea;
  private static Button button;
  private static Button button2;
  private static Button button3;

  public static void main(String[] args)
  {
    Frame frame = getFrame();

    textArea = getTextArea(20, 130);
    resulTextArea = getTextArea(15, 130);
    button = new Button("transformation");
    button2 = new Button("reset");
    button3 = new Button("copyResult");

    event();
    event2();
    event3();

    frame.add(textArea);
    frame.add(button);
    frame.add(button2);
    frame.add(button3);
    frame.add(resulTextArea);
    frame.setVisible(true);
  }

  private static void event()
  {
    button.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        GuiMain.transfter();
      }
    });
  }

  private static void event2() {
    button2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        GuiMain.reset();
      } } );
  }

  private static void event3() {
    button3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        GuiMain.copy();
      }
    });
  }

  protected static void transfter()
  {
    String text = textArea.getText();

    text = SqlHandler.handler(text);
    System.out.println(text);

    resulTextArea.setText(text);
  }

  protected static void reset() {
    textArea.getText();
    resulTextArea.getText();
    textArea.setText("");
    resulTextArea.setText("");
  }

  protected static void copy() {
    String text = resulTextArea.getText();
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    StringSelection selection = new StringSelection(text);
    clipboard.setContents(selection, null);
  }

  private static TextArea getTextArea(int rows, int columns) {
    TextArea textArea = new TextArea(rows, columns);
    textArea.setFont(new Font("Courier New", 0, 14));

    return textArea;
  }

  private static Frame getFrame() {
    Frame frame = new Frame("SQL Extract");
    frame.setLayout(new FlowLayout(0, 10, 20));
    setLocalCenter(frame);

    frame.addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    return frame;
  }

  private static void setLocalCenter(Frame frame) {
    Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    frame.setBounds(point.x - 550, point.y - 375, 1100, 750);
  }
}