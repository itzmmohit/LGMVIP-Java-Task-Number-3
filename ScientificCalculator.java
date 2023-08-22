import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ScientificCalculator extends JFrame {

	private JPanel contentPane;
	//For Display
	JLabel dis;
	//For Taking Input
	String st="";
	//For Input Handling
	double val[];
    char ope[];
    //For Trigonometric Enabling
    int trig=1;
    //For Hyperbolic Performing
    int h=1;
    //For Global Declaration
    JButton xpower3,xpower2,Threerootx,Tworootx,yrootx,xpowery,Twopowerx,TenpowerX,logxbasey,log,expowerx,ln;
    //For String Handling
    private StringBuilder currentInput = new StringBuilder();
    private Map<String, Integer> operatorPrecedence = new HashMap<>();
    //For History
    JTextArea textArea;
    private String fullExpression = "";
    //For Clear Screen Button
    JButton CE;
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScientificCalculator frame = new ScientificCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ScientificCalculator() {
		
		val=new double[100];
		ope= new char[100];
		
		operatorPrecedence.put("+", 1);
	    operatorPrecedence.put("-", 1);
	    operatorPrecedence.put("*", 2);
	    operatorPrecedence.put("/", 2);
	    operatorPrecedence.put("%", 2);
	    operatorPrecedence.put("^", 3);
		
		setTitle("ScientificCalculator TASK3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 604);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 32, 32));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dis = new JLabel("0.0");
		dis.setForeground(new Color(192, 192, 192));
		dis.setBackground(new Color(255, 255, 255));
		dis.setEnabled(false);
		dis.setFont(new Font("Tahoma", Font.PLAIN, 26));
		dis.setHorizontalAlignment(SwingConstants.RIGHT);
		dis.setBounds(10, 10, 841, 100);
		contentPane.add(dis);
		
		JButton Number_1 = new JButton("1");
		Number_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Number_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("1");
                handleButtonAction("1");
			}
		});
		Number_1.setBounds(249, 445, 143, 51);
		contentPane.add(Number_1);
		
		JButton Number_2 = new JButton("2");
		Number_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Number_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("2");
                handleButtonAction("2");
			}
		});
		Number_2.setBounds(402, 445, 143, 51);
		contentPane.add(Number_2);
		
		JButton Number_3 = new JButton("3");
		Number_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Number_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("3");
                handleButtonAction("3");
			}
		});
		Number_3.setBounds(555, 445, 143, 51);
		contentPane.add(Number_3);
		
		JButton Add = new JButton("+");
		Add.setBackground(new Color(166, 166, 166));
		Add.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("+");
                handleButtonAction("+");
			}
		});
		Add.setBounds(708, 445, 143, 51);
		contentPane.add(Add);
		
		CE = new JButton("CLR");
		CE.setBackground(new Color(255, 128, 128));
		CE.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("CE");
                handleButtonAction("CE");
			}
		});
		CE.setBounds(555, 140, 143, 51);
		contentPane.add(CE);
		
		JButton Number_4 = new JButton("4");
		Number_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Number_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("4");
                handleButtonAction("4");
			}
		});
		Number_4.setBounds(249, 384, 143, 51);
		contentPane.add(Number_4);
		
		JButton Number_5 = new JButton("5");
		Number_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Number_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("5");
                handleButtonAction("5");
			}
		});
		Number_5.setBounds(402, 384, 143, 51);
		contentPane.add(Number_5);
		
		JButton Number_6 = new JButton("6");
		Number_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Number_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("6");
                handleButtonAction("6");
			}
		});
		Number_6.setBounds(555, 384, 143, 51);
		contentPane.add(Number_6);
		
		JButton Subtract = new JButton("-");
		Subtract.setBackground(new Color(166, 166, 166));
		Subtract.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Subtract.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("-");
                handleButtonAction("-");
			}
		});
		Subtract.setBounds(708, 384, 143, 51);
		contentPane.add(Subtract);
		
		JButton Mod = new JButton("mod");
		Mod.setBackground(new Color(166, 166, 166));
		Mod.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Mod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("%");
                handleButtonAction("%");
			}
		});
		Mod.setBounds(708, 201, 143, 51);
		contentPane.add(Mod);
		
		JButton Number_7 = new JButton("7");
		Number_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Number_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("7");
                handleButtonAction("7");
			}
		});
		Number_7.setBounds(249, 323, 143, 51);
		contentPane.add(Number_7);
		
		JButton Number_8 = new JButton("8");
		Number_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Number_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("8");
                handleButtonAction("8");
			}
		});
		Number_8.setBounds(402, 323, 143, 51);
		contentPane.add(Number_8);
		
		JButton Number_9 = new JButton("9");
		Number_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Number_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("9");
                handleButtonAction("9");
			}
		});
		Number_9.setBounds(555, 323, 143, 51);
		contentPane.add(Number_9);
		
		JButton Multiply = new JButton("*");
		Multiply.setVerticalAlignment(SwingConstants.BOTTOM);
		Multiply.setBackground(new Color(166, 166, 166));
		Multiply.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Multiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("*");
                handleButtonAction("*");
			}
		});
		Multiply.setBounds(708, 323, 143, 51);
		contentPane.add(Multiply);
		
		JButton Dot = new JButton(".");
		Dot.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Dot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println(".");
                handleButtonAction(".");
			}
		});
		Dot.setBounds(555, 506, 143, 51);
		contentPane.add(Dot);
		
		JButton Number_0 = new JButton("0");
		Number_0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Number_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("0");
                handleButtonAction("0");
			}
		});
		Number_0.setBounds(402, 506, 143, 51);
		contentPane.add(Number_0);
		
		JButton Negative_No = new JButton("+/-");
		Negative_No.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("+/-");
                handleButtonAction("+/-");
			}
		});
		Negative_No.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Negative_No.setBounds(249, 506, 143, 51);
		contentPane.add(Negative_No);
		
		JButton Fact = new JButton("n!");
		Fact.setBackground(new Color(166, 166, 166));
		Fact.setFont(new Font("Tahoma", Font.ITALIC, 25));
		Fact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("n!");
                handleButtonAction("fact");
			}
		});
		Fact.setBounds(555, 262, 143, 51);
		contentPane.add(Fact);
		
		JButton Backspace = new JButton("");
		Backspace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Backspace");
                handleButtonAction("Backspace");
			}
		});
		Backspace.setBackground(new Color(166, 166, 166));
		Backspace.setIcon(new ImageIcon("C:\\Users\\mmmeh\\eclipse-workspace\\LetsGrow\\images\\delete.png"));
		Backspace.setBounds(708, 140, 143, 51);
		contentPane.add(Backspace);
		
		JButton Divide = new JButton("/");
		Divide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("/");
                handleButtonAction("/");
			}
		});
		Divide.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Divide.setBackground(new Color(166, 166, 166));
		Divide.setBounds(708, 262, 143, 51);
		contentPane.add(Divide);
		
		JButton Bracket_close = new JButton(")");
		Bracket_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println(")");
                handleButtonAction(")");
			}
		});
		Bracket_close.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Bracket_close.setBackground(new Color(166, 166, 166));
		Bracket_close.setBounds(402, 262, 143, 51);
		contentPane.add(Bracket_close);
		
		JButton Bracket_open = new JButton("(");
		Bracket_open.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("(");
                handleButtonAction("(");
			}
		});
		Bracket_open.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Bracket_open.setBackground(new Color(166, 166, 166));
		Bracket_open.setBounds(249, 262, 143, 51);
		contentPane.add(Bracket_open);
		
		ln = new JButton("ln");
		ln.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(trig%2 == 0) {
					if(h%2 == 0) {
						System.out.println("coth^-1");
		                handleButtonAction("acoth");
					}else {
						System.out.println("cot^-1");
		                handleButtonAction("acot");
					}
				} else{
					System.out.println("ln");
	                handleButtonAction("ln");
				}
			}
		});
		ln.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ln.setBackground(new Color(166, 166, 166));
		ln.setBounds(130, 506, 109, 51);
		contentPane.add(ln);
		
		log = new JButton("log");
		log.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(trig%2 == 0) {
					if(h%2 == 0) {
						System.out.println("cosech^-1");
		                handleButtonAction("acosech");
					}else {
						System.out.println("cosec^-1");
		                handleButtonAction("acosec");
					}
				} else{
					System.out.println("log");
	                handleButtonAction("log");
				}
			}
		});
		log.setFont(new Font("Tahoma", Font.PLAIN, 16));
		log.setBackground(new Color(166, 166, 166));
		log.setBounds(130, 443, 109, 51);
		contentPane.add(log);
		
		TenpowerX = new JButton("10^x");
		TenpowerX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(trig%2 == 0) {
					if(h%2 == 0) {
						System.out.println("sech^-1");
		                handleButtonAction("asech");
					}else {
						System.out.println("sec^-1");
		                handleButtonAction("asec");
					}
				} else{
					System.out.println("10^x");
	                handleButtonAction("10^x");
				}
			}
		});
		TenpowerX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TenpowerX.setBackground(new Color(166, 166, 166));
		TenpowerX.setBounds(130, 384, 109, 51);
		contentPane.add(TenpowerX);
		
		xpowery = new JButton("x^y");
		xpowery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(trig%2 == 0) {
					if(h%2 == 0) {
						System.out.println("tanh^-1");
		                handleButtonAction("atanh");
					}else {
						System.out.println("tan^-1");
		                handleButtonAction("atan");
					}
				} else{
					System.out.println("x^y");
	                handleButtonAction("x^y");
				}
			}
		});
		xpowery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xpowery.setBackground(new Color(166, 166, 166));
		xpowery.setBounds(130, 323, 109, 51);
		contentPane.add(xpowery);
		
		Tworootx = new JButton("2 (root) x");
		Tworootx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(trig%2 == 0) {
					if(h%2 == 0) {
						System.out.println("cosh^-1");
		                handleButtonAction("acosh");
					}else {
						System.out.println("cos^-1");
		                handleButtonAction("acos");
					}
				} else{
					System.out.println("sqrt");
	                handleButtonAction("sqrt");
				}
			}
		});
		Tworootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Tworootx.setBackground(new Color(166, 166, 166));
		Tworootx.setBounds(130, 262, 109, 51);
		contentPane.add(Tworootx);
		
		xpower2 = new JButton("x^2");
		xpower2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(trig%2 == 0) {
					if(h%2 == 0) {
						System.out.println("sinh^-1");
		                handleButtonAction("asinh");
					}else {
						System.out.println("sin^-1");
		                handleButtonAction("asin");
					}
				} else{
					System.out.println("x^2");
	                handleButtonAction("power2");
				}
			}
		});
		xpower2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xpower2.setBackground(new Color(166, 166, 166));
		xpower2.setBounds(130, 201, 109, 51);
		contentPane.add(xpower2);
		
		JButton Onebyx = new JButton("1/x");
		Onebyx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(currentInput.length() <= 0) {
					dis.setText("Cannot Divide By Zero");
				}else {
					System.out.println("1/x");
	                handleButtonAction("1/x");
				}
			}
		});
		Onebyx.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Onebyx.setBackground(new Color(166, 166, 166));
		Onebyx.setBounds(249, 201, 143, 51);
		contentPane.add(Onebyx);
		
		JButton Abs = new JButton("|x|");
		Abs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("|x|");
                handleButtonAction("|x|");
			}
		});
		Abs.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Abs.setBackground(new Color(166, 166, 166));
		Abs.setBounds(402, 201, 143, 51);
		contentPane.add(Abs);
		
		JButton exp = new JButton("exp");
		exp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("exp");
                handleButtonAction("exp");
			}
		});
		exp.setFont(new Font("Tahoma", Font.PLAIN, 25));
		exp.setBackground(new Color(166, 166, 166));
		exp.setBounds(555, 201, 143, 51);
		contentPane.add(exp);
		
		JButton hyp = new JButton("hyp");
		hyp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h++;
				if(h%2==0) {
					xpower3.setText("sinh");
					xpower3.setFont(new Font("Tahoma", Font.PLAIN, 16));
					xpower2.setText("sinh^-1");
					xpower2.setFont(new Font("Tahoma", Font.PLAIN, 16));
					
					Threerootx.setText("cosh");
					Threerootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					Tworootx.setText("cosh^-1");
					Tworootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					
					yrootx.setText("tanh");
					yrootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					xpowery.setText("tanh^-1");
					xpowery.setFont(new Font("Tahoma", Font.PLAIN, 16));
					
					Twopowerx.setText("sech");
					Twopowerx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					TenpowerX.setText("sech^-1");
					TenpowerX.setFont(new Font("Tahoma", Font.PLAIN, 16));
					
					logxbasey.setText("cosech");
					logxbasey.setFont(new Font("Tahoma", Font.PLAIN, 16));
					log.setText("cosech^-1");
					log.setFont(new Font("Tahoma", Font.PLAIN, 16));
					
					expowerx.setText("coth");
					expowerx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					ln.setText("coth^-1");
					ln.setFont(new Font("Tahoma", Font.PLAIN, 16));
					
				}else if(h%2!=0) {
					xpower3.setText("sin");
					xpower3.setFont(new Font("Tahoma", Font.PLAIN, 16));
					xpower2.setText("sin^-1");
					xpower2.setFont(new Font("Tahoma", Font.PLAIN, 16));
					
					Threerootx.setText("cos");
					Threerootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					Tworootx.setText("cos^-1");
					Tworootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					
					yrootx.setText("tan");
					yrootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					xpowery.setText("tan^-1");
					xpowery.setFont(new Font("Tahoma", Font.PLAIN, 16));
					
					Twopowerx.setText("sec");
					Twopowerx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					TenpowerX.setText("sec^-1");
					TenpowerX.setFont(new Font("Tahoma", Font.PLAIN, 16));
					
					logxbasey.setText("cosec");
					logxbasey.setFont(new Font("Tahoma", Font.PLAIN, 16));
					log.setText("cosec^-1");
					log.setFont(new Font("Tahoma", Font.PLAIN, 16));
					
					expowerx.setText("cot");
					expowerx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					ln.setText("cot^-1");
					ln.setFont(new Font("Tahoma", Font.PLAIN, 16));
				}
			}
		});
		hyp.setEnabled(false);
		hyp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hyp.setBackground(new Color(255, 255, 128));
		hyp.setBounds(130, 140, 109, 51);
		contentPane.add(hyp);
		
		JButton Pie = new JButton("π (Pie)");
		Pie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Pie");
                handleButtonAction("Pie");
			}
		});
		Pie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Pie.setBackground(new Color(166, 166, 166));
		Pie.setBounds(249, 140, 143, 51);
		contentPane.add(Pie);
		
		JButton e = new JButton("e");
		e.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("e");
                handleButtonAction("e");
			}
		});
		e.setFont(new Font("Tahoma", Font.PLAIN, 25));
		e.setBackground(new Color(166, 166, 166));
		e.setBounds(402, 140, 143, 51);
		contentPane.add(e);
		
		expowerx = new JButton("e^x");
		expowerx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent expowerx) {
				if(trig%2 == 0) {
					if(h%2 == 0) {
						System.out.println("coth");
		                handleButtonAction("coth");
					}else {
						System.out.println("cot");
		                handleButtonAction("cot");
					}
				} else{
					System.out.println("e^x");
	                handleButtonAction("e^x");
				}
			}
		});
		expowerx.setFont(new Font("Tahoma", Font.PLAIN, 16));
		expowerx.setBackground(new Color(166, 166, 166));
		expowerx.setBounds(11, 506, 109, 51);
		contentPane.add(expowerx);
		
		logxbasey = new JButton("log (y) x");
		logxbasey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent logxbasey) {
				if(trig%2 == 0) {
					if(h%2 == 0) {
						System.out.println("cosech");
		                handleButtonAction("cosech");
					}else {
						System.out.println("cosec");
		                handleButtonAction("cosec");
					}
				} else{
					System.out.println("log (y) x");
	                handleButtonAction("ylogx");
				}
			}
		});
		logxbasey.setFont(new Font("Tahoma", Font.PLAIN, 16));
		logxbasey.setBackground(new Color(166, 166, 166));
		logxbasey.setBounds(10, 445, 109, 51);
		contentPane.add(logxbasey);
		
		Twopowerx = new JButton("2^x");
		Twopowerx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(trig%2 == 0) {
					if(h%2 == 0) {
						System.out.println("sech");
		                handleButtonAction("sech");
					}else {
						System.out.println("sec");
		                handleButtonAction("sec");
					}
				} else{
					System.out.println("2^x");
	                handleButtonAction("2^x");
				}
			}
		});
		Twopowerx.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Twopowerx.setBackground(new Color(166, 166, 166));
		Twopowerx.setBounds(11, 384, 109, 51);
		contentPane.add(Twopowerx);
		
		yrootx = new JButton("y (root) x");
		yrootx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(trig%2 == 0) {
					if(h%2 == 0) {
						System.out.println("tanh");
		                handleButtonAction("tanh");
					}else {
						System.out.println("tan");
		                handleButtonAction("tan");
					}
				} else{
					System.out.println("y (root) x");
	                handleButtonAction("yroot");
				}
			}
		});
		yrootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
		yrootx.setBackground(new Color(166, 166, 166));
		yrootx.setBounds(10, 323, 109, 51);
		contentPane.add(yrootx);
		
		Threerootx = new JButton("3 (root) x");
		Threerootx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(trig%2 == 0) {
					if(h%2 == 0) {
						System.out.println("cosh");
		                handleButtonAction("cosh");
					}else {
						System.out.println("cos");
		                handleButtonAction("cos");
					}
				} else{
					System.out.println("3 (root) x");
	                handleButtonAction("cbrt");
				}
			}
		});
		Threerootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Threerootx.setBackground(new Color(166, 166, 166));
		Threerootx.setBounds(11, 262, 109, 51);
		contentPane.add(Threerootx);
		
		xpower3 = new JButton("x^3");
		xpower3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(trig%2 == 0) {
					if(h%2 == 0) {
						System.out.println("sinh");
		                handleButtonAction("sinh");
					}else {
						System.out.println("sin");
		                handleButtonAction("sin");
					}
				} else{
					System.out.println("x^3");
	                handleButtonAction("power3");
				}
			}
		});
		xpower3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xpower3.setBackground(new Color(166, 166, 166));
		xpower3.setBounds(10, 201, 109, 51);
		contentPane.add(xpower3);
		
		JButton Trig = new JButton("Trig");
		Trig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				trig++;
				if(h%2==0) {
					h--;
				}
				if(trig%2==0) {   //Trigonometry things will not appear
					hyp.setBackground(new Color(128, 255, 128));
					hyp.setEnabled(true);
					
					xpower3.setText("sin");
					xpower3.setFont(new Font("Tahoma", Font.PLAIN, 16));
					xpower3.setBackground(new Color(193, 255, 193));
					xpower2.setText("sin^-1");
					xpower2.setFont(new Font("Tahoma", Font.PLAIN, 16));
					xpower2.setBackground(new Color(193, 255, 193));
					
					Threerootx.setText("cos");
					Threerootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					Threerootx.setBackground(new Color(193, 255, 193));
					Tworootx.setText("cos^-1");
					Tworootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					Tworootx.setBackground(new Color(193, 255, 193));
					
					yrootx.setText("tan");
					yrootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					yrootx.setBackground(new Color(193, 255, 193));
					xpowery.setText("tan^-1");
					xpowery.setFont(new Font("Tahoma", Font.PLAIN, 16));
					xpowery.setBackground(new Color(193, 255, 193));
					
					Twopowerx.setText("sec");
					Twopowerx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					Twopowerx.setBackground(new Color(193, 255, 193));
					TenpowerX.setText("sec^-1");
					TenpowerX.setFont(new Font("Tahoma", Font.PLAIN, 16));
					TenpowerX.setBackground(new Color(193, 255, 193));
					
					logxbasey.setText("cosec");
					logxbasey.setFont(new Font("Tahoma", Font.PLAIN, 16));
					logxbasey.setBackground(new Color(193, 255, 193));
					log.setText("cosec^-1");
					log.setFont(new Font("Tahoma", Font.PLAIN, 16));
					log.setBackground(new Color(193, 255, 193));
					
					expowerx.setText("cot");
					expowerx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					expowerx.setBackground(new Color(193, 255, 193));
					ln.setText("cot^-1");
					ln.setFont(new Font("Tahoma", Font.PLAIN, 16));
					ln.setBackground(new Color(193, 255, 193));
					
				}
				else if(trig%2!=0) {  //Trigonometry things will appear
					hyp.setBackground(new Color(255, 255, 128));
					hyp.setEnabled(false);
					
					xpower3.setText("x^3");
					xpower3.setFont(new Font("Tahoma", Font.PLAIN, 16));
					xpower3.setBackground(new Color(166, 166, 166));
					xpower2.setText("x^2");
					xpower2.setFont(new Font("Tahoma", Font.PLAIN, 16));
					xpower2.setBackground(new Color(166, 166, 166));
					
					Threerootx.setText("3 (root) x");
					Threerootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					Threerootx.setBackground(new Color(166, 166, 166));
					Tworootx.setText("2 (root) x");
					Tworootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					Tworootx.setBackground(new Color(166, 166, 166));
					
					yrootx.setText("y (root) x");
					yrootx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					yrootx.setBackground(new Color(166, 166, 166));
					xpowery.setText("x^y");
					xpowery.setFont(new Font("Tahoma", Font.PLAIN, 16));
					xpowery.setBackground(new Color(166, 166, 166));
					
					Twopowerx.setText("2^x");
					Twopowerx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					Twopowerx.setBackground(new Color(166, 166, 166));
					TenpowerX.setText("10^x");
					TenpowerX.setFont(new Font("Tahoma", Font.PLAIN, 16));
					TenpowerX.setBackground(new Color(166, 166, 166));
					
					logxbasey.setText("log (y) x");
					logxbasey.setFont(new Font("Tahoma", Font.PLAIN, 16));
					logxbasey.setBackground(new Color(166, 166, 166));
					log.setText("log");
					log.setFont(new Font("Tahoma", Font.PLAIN, 16));
					log.setBackground(new Color(166, 166, 166));
					
					expowerx.setText("e^x");
					expowerx.setFont(new Font("Tahoma", Font.PLAIN, 16));
					expowerx.setBackground(new Color(166, 166, 166));
					ln.setText("ln");
					ln.setFont(new Font("Tahoma", Font.PLAIN, 16));
					ln.setBackground(new Color(166, 166, 166));
				}
			}
		});
		Trig.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Trig.setBackground(new Color(128, 255, 128));
		Trig.setBounds(10, 140, 109, 51);
		contentPane.add(Trig);
		
		JButton Equal = new JButton("=");
		Equal.setBackground(new Color(71, 177, 232));
		Equal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Equal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					System.out.println("=");
	                handleButtonAction("=");
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				}				
			}
		});
		Equal.setBounds(708, 506, 143, 51);
		contentPane.add(Equal);
		
		JPanel History = new JPanel();
		History.setBounds(867, 10, 186, 547);
		contentPane.add(History);
		History.setLayout(null);
		
		JLabel Label = new JLabel("History");
		Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label.setBounds(10, 10, 166, 31);
		History.add(Label);
		
		textArea = new JTextArea(10, 20);
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setLocation(867, 57);
		scrollPane.setSize(186, 500);
		getContentPane().add(scrollPane, BorderLayout.SOUTH);
		
		JPanel extra = new JPanel();
		extra.setBounds(10, 113, 841, 17);
		contentPane.add(extra);
		extra.setLayout(null);	
	}
	
	private void handleButtonAction(String label) {
	    if (label.equals("=")) {
	        try {
	        	double result = evaluateExpression(currentInput.toString());
	            dis.setText(Double.toString(result));
	            
	            // Count open brackets in currentInput
	            int openBracketCount = countCharOccurrences(currentInput.toString(), '(');
	            int closeBracketCount = countCharOccurrences(currentInput.toString(), ')');

	            // Add closing brackets if there are more open brackets
	            for (int i = 0; i < openBracketCount - closeBracketCount; i++) {
	                currentInput.append(")");
	            }

	            fullExpression = currentInput + " = " + result + "\n";
	            currentInput.setLength(0);
	            currentInput.append(result);

	            // Update history
	            textArea.append(fullExpression + "\n");

	        } catch (Exception ex) {
	            dis.setText("Error");
	            currentInput.setLength(0);
	        }
	    } 
	    else if (label.equals("CE")) {
	        fullExpression = ""; // Clear the full expression
	        currentInput.setLength(0);
	        dis.setText("0.0");
	    } 
	    else if (label.equals("sin") || label.equals("cos") || label.equals("tan") ||
	               label.equals("sec") || label.equals("cosec") || label.equals("cot") ||
	               label.equals("sinh") || label.equals("cosh") || label.equals("tanh") ||
	               label.equals("sech") || label.equals("cosech") || label.equals("coth") ||
	               label.equals("asin") || label.equals("acos") || label.equals("atan") ||
	               label.equals("asec") || label.equals("acosec") || label.equals("acot") ||
	               label.equals("asinh") || label.equals("acosh") || label.equals("atanh") ||
	               label.equals("asech") || label.equals("acosech") || label.equals("acoth") ||
	               label.equals("sqrt") || label.equals("power2") || label.equals("power3") ||
	               label.equals("exp") || label.equals("fact") || label.equals("yroot") ||
	               label.equals("log") || label.equals("cbrt") || label.equals("2^x") ||
	               label.equals("10^x") || label.equals("ln") || label.equals("ylogx")) {
	        currentInput.append(label + "(");
	        dis.setText(currentInput.toString());
	    }
	    else if (label.equals("x^y")) {
	        currentInput.append("^");
	        dis.setText(currentInput.toString());
	    } 
		else if (label.equals("|x|")) {
	        currentInput.append("abs(");
	        dis.setText(currentInput.toString());
	    } 
	    else if (label.equals("+/-")) {
	        toggleSign();
	    } 
	    else if(label.equals("Backspace")) {
        	String s = currentInput.toString();
            if (currentInput.length() > 0) {
                currentInput = new StringBuilder(s.substring(0, s.length() - 1));
                if(currentInput.length() == 0) {
                	currentInput = new StringBuilder();
                    dis.setText("0.0");
                } else {
                	dis.setText(currentInput.toString());
                }
            }
        } 
	    else if (label.equals("Pie")){
        	if (isPreviousCharOperator()) {
                currentInput.append("3.1415926535897932384626433832795");
                dis.setText(currentInput.toString());
            } else if(currentInput.length() == 0){
        		currentInput = new StringBuilder();
                currentInput.append("3.1415926535897932384626433832795");
                dis.setText(currentInput.toString());
        	}
        } 
        else if (label.equals("e")){
        	if (isPreviousCharOperator()) {
                currentInput.append("2.7182818284590452353602874713527");
                dis.setText(currentInput.toString());
            } else if(currentInput.length() == 0){
        		currentInput = new StringBuilder();
                currentInput.append("2.7182818284590452353602874713527");
                dis.setText(currentInput.toString());
        	}
        } 
        else {
            currentInput.append(label);
            dis.setText(currentInput.toString());
        }
    }
	
	private boolean isPreviousCharOperator() {
	    if (currentInput.length() > 0) {
	        char lastChar = currentInput.charAt(currentInput.length() - 1);
	        return lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/' || lastChar == '%';
	    }
	    return false;
	}
	
	private double evaluateExpression(String expression) {
        String postfix = infixToPostfix(expression);
        double result = evaluatePostfix(postfix);
        return result;
    }
	
	private String infixToPostfix(String infix) {
	    StringBuilder postfix = new StringBuilder();
	    Stack<String> stack = new Stack<>();

	    for (int i = 0; i < infix.length(); i++) {
	        char ch = infix.charAt(i);

	        if (Character.isDigit(ch) || ch == '.') {
	            int startIndex = i;
	            while (i < infix.length() && (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
	                i++;
	            }
	            postfix.append(infix.substring(startIndex, i)).append(" ");
	            i--;
	        } else if (Character.isLetter(ch)) {
	            int startIndex = i;
	            while (i < infix.length() && Character.isLetter(infix.charAt(i))) {
	                i++;
	            }
	            String function = infix.substring(startIndex, i);
	            stack.push(function);
	        } else if (ch == '(') {
	            stack.push("(");
	        } else if (ch == ')') {
	            while (!stack.isEmpty() && !stack.peek().equals("(")) {
	                postfix.append(stack.pop()).append(" ");
	            }
	            stack.pop(); // Pop the '('
	        } else if (operatorPrecedence.containsKey(Character.toString(ch))) {
	            String operator = Character.toString(ch);
	            if (operator.equals("-") && (i == 0 || infix.charAt(i - 1) == '(')) {
	                // Handle negative sign as a unary operator
	                stack.push("~"); // Push "~" to represent unary negative operation
	            } else {
	                while (!stack.isEmpty() && operatorPrecedence.containsKey(stack.peek()) &&
	                        operatorPrecedence.get(operator) <= operatorPrecedence.get(stack.peek())) {
	                    postfix.append(stack.pop()).append(" ");
	                }
	                stack.push(operator);
	            }
	        }
	    }

	    while (!stack.isEmpty()) {
	        postfix.append(stack.pop()).append(" ");
	    }

	    return postfix.toString();
	}

    private double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.trim().split("\\s+");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Double.parseDouble(token));
            } else if (operatorPrecedence.containsKey(token)) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(token, operand1, operand2);
                stack.push(result);
            } else if (token.equals("sin") || token.equals("cos") || token.equals("tan") ||
            		   token.equals("sec") || token.equals("cosec") || token.equals("cot") ||
            		   token.equals("sinh") || token.equals("cosh") || token.equals("tanh") ||
            		   token.equals("sech") || token.equals("cosech") || token.equals("coth") ||
            		   token.equals("asin") || token.equals("acos") || token.equals("atan") ||
            		   token.equals("asec") || token.equals("acosec") || token.equals("acot") ||
            		   token.equals("asinh") || token.equals("acosh") || token.equals("atanh") ||
            		   token.equals("asech") || token.equals("acosech") || token.equals("acoth") ||
                       token.equals("sqrt") || token.equals("power2") || token.equals("power3") ||
                       token.equals("yroot") || token.equals("exp") || token.equals("fact") ||
                       token.equals("log") || token.equals("cbrt") || token.equals("2^x") ||
                       token.equals("10^x") || token.equals("ln") || token.equals("ylogx")) {
                double operand = stack.pop();
                double result = performFunction(token, operand);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private double performOperation(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":	return operand1 + operand2;
            case "-":	return operand1 - operand2;
            case "*":	return operand1 * operand2;
            case "/":	return operand1 / operand2;
            case "%":	return operand1 % operand2;
            case "^":	return Math.pow(operand1, operand2);
            default:	throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    private double performFunction(String functionName, double operand) {
    	System.out.println("------>"+operand);
    	double n;
        switch (functionName) {
        	// Trigonometric Functions
            case "sin":	   return Math.sin(operand);         
            case "cos":	   return Math.cos(operand);           
            case "tan":	   return Math.tan(operand);            
            case "sec":    n = 1/(Math.cos(operand));
            			   return n;           
            case "cosec":  n = 1/(Math.sin(operand));
			               return n; 				               
            case "cot":    n = 1/(Math.tan(operand));
			               return n;
			               
			// Inverse Trigonometric Functions
            case "asin":	 return Math.asin(operand);         
            case "acos":	 return Math.acos(operand);           
            case "atan":	 return Math.atan(operand);
            case "asec":     return Math.acos(1 / operand);
            case "acosec":   return Math.asin(1 / operand);
            case "acot":     return Math.atan(1 / operand);
            
			// Hyperbolic Functions               
            case "sinh":   return Math.sinh(operand);        
            case "cosh":   return Math.cosh(operand);           
            case "tanh":   return Math.tanh(operand);           
            case "sech":   n = 1/(Math.cosh(operand));
						   return n;			
			case "cosech": n = 1/(Math.sinh(operand));
			               return n; 				            
			case "coth":   n = 1/(Math.tanh(operand));
			               return n;   
			               
			// Inverse Hyperbolic Functions    
			case "asinh":	 return Math.log(operand + Math.sqrt(operand * operand + 1));       
	        case "acosh":	 return Math.log(operand + Math.sqrt(operand * operand - 1));          
	        case "atanh":	 return 0.5 * Math.log((1 + operand) / (1 - operand));
	        case "asech":    return Math.log((1 + Math.sqrt(1 - operand * operand)) / operand);
	        case "acosech":  return Math.log((1 + Math.sqrt(1 + operand * operand)) / operand);
	        case "acoth":    return 0.5 * Math.log((operand + 1) / (operand - 1));

			// Functions  
	        case "|x|":    return Math.abs(operand);            
            case "exp":    return Math.exp(operand);   
            case "fact":   n=1;
						   for(int i=1;i<=operand;i++){
							   n=n*i;
						   }
						   return n;
						   
	        case "cbrt":   return Math.cbrt(operand);
            case "sqrt":   return Math.sqrt(operand);  
            case "power3":    System.out.println("------>"+operand);
            				Math.pow(operand, 3);  
            case "power2":    System.out.println("------>"+operand);
            				Math.pow(operand, 2);           
            
            case "yroot":  return Math.pow(operand, 1.0 / getCurrentInputValue()); // Implement getCurrentInputValue()
            case "x^y":    return Math.pow(operand, getCurrentInputValue());
            
            case "2^x":    return Math.pow(2, operand);
            case "10^x":   return Math.pow(10, operand);          
            
            case "ylogx":	   // Implement log x base y
			                double yValue = getCurrentInputValue(); // Implement getCurrentInputValue()
			                return Math.log(operand) / Math.log(yValue);
            
            case "log":    return Math.log10(operand);
            case "e^x":    return Math.pow(2.7182818284590452353602874713527, operand);
            case "ln":	   return Math.log(operand);
                 
            default:	throw new IllegalArgumentException("Unknown function: " + functionName);
        }
    }
    
    private double getCurrentInputValue() {
        String inputValue = JOptionPane.showInputDialog(this, "Enter value for y:");
        
        try {
            return Double.parseDouble(inputValue);
        } catch (NumberFormatException e) {
            // Handle invalid input
            return 0.0; // Return a default value or show an error message
        }
    }
  
    private void toggleSign() {
        if (currentInput.length() > 0) {
            double value = Double.parseDouble(currentInput.toString());
            value *= -1;  // Toggle the sign
            currentInput.setLength(0);
            currentInput.append(value);
            dis.setText(currentInput.toString());
        }
    }
    
    private int countCharOccurrences(String text, char targetChar) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == targetChar) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isPreviousCharNumeric() {
        if (currentInput.length() > 0) {
            char lastChar = currentInput.charAt(currentInput.length() - 1);
            return Character.isDigit(lastChar);
        }
        return false;
    }

    private boolean isPreviousCharClosingParenthesis() {
        if (currentInput.length() > 0) {
            char lastChar = currentInput.charAt(currentInput.length() - 1);
            return lastChar == ')';
        }
        return false;
    }


}