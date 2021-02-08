package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class TextEditor2 extends JFrame implements ActionListener{
	//필요한 static final 상수 정의하기 
	public static final String COMMAND_NEW="new";
	public static final String COMMAND_OPEN="open";
	public static final String COMMAND_SAVE="save";
	
	JTextArea area;
	
	//생성자
	public TextEditor2 (String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		//메뉴1
		JMenu menu1=new JMenu("File");
		//메뉴2
		JMenu menu2=new JMenu("Help");
		
		//메뉴바
		JMenuBar mb=new JMenuBar();
		//메뉴바 메뉴 추가
		mb.add(menu1);
		mb.add(menu2);
		//프레임에 메뉴바 추가
		this.setJMenuBar(mb);
		
		//메뉴 아이템1
		JMenuItem item1=new JMenuItem("New");
		//메뉴 아이템2
		JMenuItem item2=new JMenuItem("Open");
		//메뉴 아이템3
		JMenuItem item3=new JMenuItem("Save");
		
		//메뉴 아이템을 메뉴에 추가하기
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		
		//아이템에 액션 리스너 등록
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		
		//아이템에 액션 command 지정
		item1.setActionCommand(TextEditor2.COMMAND_NEW);
		item2.setActionCommand(TextEditor2.COMMAND_OPEN);
		//동일한 클래스에 있는 static필드를 참조할때는 클래스명 생략 가능 
		//오타가 날 확률이 줄어든다.
		item3.setActionCommand(TextEditor2.COMMAND_SAVE);
		
		//JTextArea
		area=new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.pink);
		//일단 안보이게 해놓는다
		area.setVisible(false);
		//new했을때 보이게 하고싶다면 
		//밖에서 선언해야하므로 (Override)
		//필드에 JTextArea area;선언 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { //분기를 할 수 있다
		//액션 command를 읽어온다.
		String command=e.getActionCommand();
		if(command.equals(COMMAND_NEW)) {
			area.setVisible(true);
			area.grabFocus();//포커스 주기
			
		}else if(command.equals(COMMAND_OPEN)) {
			JFileChooser fc=new JFileChooser("c:/myFolder");
			int result=fc.showOpenDialog(this);
			
		}else if(command.equals(COMMAND_SAVE)) {
			JFileChooser fc=new JFileChooser("c:/myFolder");
			int result=fc.showSaveDialog(this);
		}
	}
	
	public static void main(String[] args) {
		TextEditor2 te=new TextEditor2("텍스트 편집기");
		te.setBounds(100, 100, 500, 500);
		te.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		te.setVisible(true);
	}
}
