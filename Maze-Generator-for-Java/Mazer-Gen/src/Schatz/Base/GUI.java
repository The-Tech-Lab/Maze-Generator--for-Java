package Base;



import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private static JFrame frame;
    public static Boolean Done;
    public static String End;

    private JPanel Panel0;
    private JSlider WidthSlider;
    private JSlider HeightSlider;
    private JSlider SizeSlider;
    private JButton DoneButton;
    private JComboBox MazeLib;
    private JLabel WidthText;
    private JLabel HeightText;
    private JLabel SizeText;
    private JLabel cellLable;
    private JLabel heightLabel;
    private JLabel widthLabel;
    private JCheckBox watchCheckBox;

    public GUI() {
        WidthSlider.addChangeListener(new ChangeListener() {
                                          @Override
                                          public void stateChanged(ChangeEvent changeEvent) {
                                              WidthText.setText("" + WidthSlider.getValue());
                                          }
                                      }
        );
        HeightSlider.addChangeListener(new ChangeListener() {
                                           @Override
                                           public void stateChanged(ChangeEvent changeEvent) {
                                               HeightText.setText("" + HeightSlider.getValue());
                                           }
                                       }
        );
        SizeSlider.addChangeListener(new ChangeListener() {
                                         @Override
                                         public void stateChanged(ChangeEvent changeEvent) {
                                             SizeText.setText("" + SizeSlider.getValue());
                                             HeightSlider.setMaximum(900/SizeSlider.getValue());
                                             WidthSlider.setMaximum(2050/SizeSlider.getValue());
                                         }
                                     }
        );


        DoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                frame.setVisible(false);
                End += MazeLib.getSelectedItem() + " ";
                End += WidthText.getText() + " ";
                End += HeightText.getText() + " ";
                End += SizeText.getText() + " ";
                End += (Boolean) watchCheckBox.isSelected();

                Done = true;

            }
        });
    }

    public String getComboName(int i) {
        return "" + MazeLib.getItemAt(i);
    }

    public static void main(String[] args) {
        End = "";
        Done = false;
        frame = new JFrame("GUI");
        frame.setContentPane(new GUI().Panel0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
