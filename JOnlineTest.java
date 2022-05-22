import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class JOnlineTest extends JFrame implements ActionListener {
	  
    private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	JOnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 850, 60);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 40);
		radioButton[1].setBounds(50, 110, 200, 40);
		radioButton[2].setBounds(50, 140, 200, 40);
		radioButton[3].setBounds(50, 170, 200, 40);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1: Father of Java?");
			radioButton[0].setText("James Gosling");
			radioButton[1].setText("Dennis");
			radioButton[2].setText("Berner");
			radioButton[3].setText("Gudio van rossum");
		}
		if (current == 1) {
			label.setText("Que2: Number of primitive data types in java? ");
			radioButton[0].setText("6");
			radioButton[1].setText("7");
			radioButton[2].setText("8");
			radioButton[3].setText("9");
		}
		if (current == 2) {
			label.setText("Que3: What is the size of float and double in java");
			radioButton[0].setText("32 and 64");
			radioButton[1].setText("32 and 32");
			radioButton[2].setText("64 and 64");
			radioButton[3].setText("64 and 32");
		}
		if (current == 3) {
			label.setText("Que4: When an array is passed to a method,what does the method receive");
			radioButton[0].setText("The reference of the array");
			radioButton[1].setText("A copy of the array");
			radioButton[2].setText("length of the array");
			radioButton[3].setText("copy of the fisrt element of the array");
		}
		if (current == 4) {
			label.setText("Que5: Arrays in Java are ");
			radioButton[0].setText(" Object References");
			radioButton[1].setText("objects");
			radioButton[2].setText("Primitive data type");
			radioButton[3].setText("None");
		}
		if (current == 5) {
			label.setText("Que6: When the object is created with new keyword");
			radioButton[0].setText("At run time");
			radioButton[1].setText("At compile time");
			radioButton[2].setText("Depends on code");
			radioButton[3].setText("None");
		}
		if (current == 6) {
			label.setText("Que7:  Which feature of java 7 allows to not explicitly close IO resource?");
			radioButton[0].setText("try catch finally");
			radioButton[1].setText("IOException");
			radioButton[2].setText("AutoCloseable");
			radioButton[3].setText("Streams");
		}
		if (current == 7) {
			label.setText("Que8: Identify the correct definition of a package");
			radioButton[0].setText("Collection of editing tools");
			radioButton[1].setText("Collection of classes");
			radioButton[2].setText("Collections of classes and interfaces");
			radioButton[3].setText("Collection of interfaces");
		}
		if (current == 8) {
			label.setText("Que9: In which of the following is toString() method defined");
			radioButton[0].setText("java.lang.Object");
			radioButton[1].setText("java.lang.String");
			radioButton[2].setText("java.lang.util");
			radioButton[3].setText("None");
		}
		if (current == 9) {
			label.setText("Que10: compareTo() returns");
			radioButton[0].setText("an int value");
			radioButton[1].setText("string");
			radioButton[2].setText("object");
			radioButton[3].setText("None");
		}
		label.setBounds(30, 40, 450, 40);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[0].isSelected());
		if (current == 1)
			return (radioButton[2].isSelected());
		if (current == 2)
			return (radioButton[1].isSelected());
		if (current == 3)
			return (radioButton[0].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[0].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new JOnlineTest("Online Test App");
	}

}
