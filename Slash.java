import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Slash extends JFrame implements ActionListener{

    JTextField text1 =null;
    JLabel label;

    public static void main(String[] args){
        Slash m = new Slash("sample");
        m.setVisible(true);
    }

    Slash(String title){
        setBounds(100, 100, 300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        Container con = getContentPane();

        text1 = new JTextField("バクスラ消したい文章", 20);
        JButton button = new JButton("変換");

        button.setActionCommand("trans");
        button.addActionListener(this);
        label=new JLabel();
        panel.add(text1);
        panel.add(button);

        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if("trans".equals(e.getActionCommand())){
            String str=rem_slash(text1.getText());
            setClipboardString(str);
        }
    }

   static void setClipboardString(String str) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Clipboard clip = kit.getSystemClipboard();
		StringSelection ss = new StringSelection(str);
		clip.setContents(ss, ss);
	}


    static String rem_slash(String line){
        line.replace("\r\n"," ");
        line.replace("\n"," ");
        return line;
    }
}

