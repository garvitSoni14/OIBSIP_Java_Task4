import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

class Login extends JFrame implements ActionListener {
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField textField1;
    final JPasswordField textField2;

    Login() {
        userLabel = new JLabel("    Username :");
        textField1 = new JTextField(15);

        passLabel = new JLabel("    Password :");
        textField2 = new JPasswordField(8);

        b1 = new JButton("   SUBMIT   ");

        newPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        newPanel.add(new JLabel("")); // empty cell for spacing
        newPanel.add(b1);

        add(newPanel, BorderLayout.CENTER);
        b1.addActionListener(this);
        setTitle("Login Form");
    }

    public void actionPerformed(ActionEvent ae) {
        String userValue = textField1.getText();
        String passValue = new String(textField2.getPassword());
        if(!passValue.equals("")) {
            dispose(); // close login
            new OnlineTestBegin(userValue);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid password!");
        }
    }
}

class OnlineTestBegin extends JFrame implements ActionListener {
    JLabel l;
    JLabel l1;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0,x=1,now=0;
    int m[]=new int[10];
    Timer timer = new Timer();

    OnlineTestBegin(String s) {
        super("Welcome " + s);

        l = new JLabel();
        l1 = new JLabel("Time left: 10:00");
        add(l);
        add(l1);

        bg = new ButtonGroup();
        for(int i=0;i<4;i++) {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }

        b1 = new JButton("Save and Next");
        b2 = new JButton("Save for later");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);

        set();

        l.setBounds(30,40,500,20);
        l1.setBounds(400,20,200,20);
        jb[0].setBounds(50,80,200,20);
        jb[1].setBounds(50,110,200,20);
        jb[2].setBounds(50,140,200,20);
        jb[3].setBounds(50,170,200,20);
        b1.setBounds(95,240,140,30);
        b2.setBounds(270,240,150,30);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);

        // Timer in MM:SS format
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 600; // 10 minutes
            public void run() {
                int minutes = i / 60;
                int seconds = i % 60;
                l1.setText(String.format("Time left: %02d:%02d", minutes, seconds));
                i--;
                if (i < 0) {
                    timer.cancel();
                    l1.setText("Time Out");
                    JOptionPane.showMessageDialog(null, "Time Over! Your Score = " + count);
                    System.exit(0);
                }
            }
        }, 0, 1000);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            if(check())
                count++;
            current++;
            set();
            if(current==9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Save for later")) {
            JButton bk=new JButton("Review"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++) {
            if(e.getActionCommand().equals("Review"+y)) {
                if(check())
                    count++;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }
        if(e.getActionCommand().equals("Result")) {
            if(check())
                count++;
            JOptionPane.showMessageDialog(this,"Score = "+count);
            System.exit(0);
        }
    }

    void set() {
        bg.clearSelection();
        if(current==0) {
            l.setText("Que1: Who is known as father of Java programming language?");
            jb[0].setText("Charles Babbage");jb[1].setText("James Gosling");jb[2].setText("M.P.Java");jb[3].setText("Blais Pascal");
        }
        if(current==1) {
            l.setText("Que2: Number of primitive data types in Java are?");
            jb[0].setText("6");jb[1].setText("7");jb[2].setText("8");jb[3].setText("9");
        }
        if(current==2) {
            l.setText("Que3: Where is System class defined?");
            jb[0].setText("java.lang.package");jb[1].setText("java.util.package");jb[2].setText("java.io.package");jb[3].setText("None");
        }
        if(current==3) {
            l.setText("Que4: Exception created by try block is caught in which block?");
            jb[0].setText("catch");jb[1].setText("throw");jb[2].setText("final");jb[3].setText("throws");
        }
        if(current==4) {
            l.setText("Que5: Which of the following is not an OOPS concept in Java?");
            jb[0].setText("Polymorphism");jb[1].setText("Inheritance");jb[2].setText("Compilation");jb[3].setText("Encapsulation");
        }
        if(current==5) {
            l.setText("Que6: Identify the infinite loop?");
            jb[0].setText("for(;;)");jb[1].setText("while(true)");jb[2].setText("do{}while(true);");jb[3].setText("All of the above");
        }
        if(current==6) {
            l.setText("Que7: When is the finalize() method called?");
            jb[0].setText("Before garbage collection");jb[1].setText("Before an object goes out of scope");jb[2].setText("Before a variable goes out of scope");jb[3].setText("None");
        }
        if(current==7) {
            l.setText("Que8: What is the implicit return type of constructor?");
            jb[0].setText("No return type");jb[1].setText("A class object in which it is defined");jb[2].setText("void");jb[3].setText("None");
        }
        if(current==8) {
            l.setText("Que9: The class at the top of exception class hierarchy is...?");
            jb[0].setText("ArithmeticException");jb[1].setText("Throwable");jb[2].setText("Object");jb[3].setText("Console");
        }
        if(current==9) {
            l.setText("Que10: Which provides runtime environment for Java byte code to be executed?");
            jb[0].setText("JDK");jb[1].setText("JVM");jb[2].setText("JRE");jb[3].setText("JAVAC");
        }
    }

    boolean check() {
        if(current==0) return(jb[1].isSelected());
        if(current==1) return(jb[2].isSelected());
        if(current==2) return(jb[0].isSelected());
        if(current==3) return(jb[0].isSelected());
        if(current==4) return(jb[2].isSelected());
        if(current==5) return(jb[3].isSelected());
        if(current==6) return(jb[0].isSelected());
        if(current==7) return(jb[1].isSelected());
        if(current==8) return(jb[1].isSelected());
        if(current==9) return(jb[1].isSelected());
        return false;
    }
}

class OnlineExam {
    public static void main(String args[]) {
        try {
            Login form = new Login();
            form.setSize(400,150);
            form.setVisible(true);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

