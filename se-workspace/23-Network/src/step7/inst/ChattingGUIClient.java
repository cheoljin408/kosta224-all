package step7.inst;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import common.IP;

public class ChattingGUIClient {

 private JFrame frame;
 private JTextArea textArea;
 private JPanel panel;
 private JTextField textField;
 private JButton button;
 /*
  * 네트워크 통신을 위한 변수를 선언 
  */
 private Socket socket;
 private BufferedReader br;
 private PrintWriter pw;
 /*
  *  스트림과 소켓을 닫는 메서드를 정의한다 
  */
 public void closeAll() throws IOException {
	 if(br!=null)
		 br.close();
	 if(pw!=null)
		 pw.close();
	 if(socket!=null)
		 socket.close();
 }

 public void startUI() {
  frame = new JFrame("kostatok");
  frame.addWindowListener(new WindowAdapter() {
   @Override
   public void windowClosing(WindowEvent e) {
    /*
     * ServerWorker Thread에서 종료할것임을 알린다 
     */
	  // System.out.println("종료버튼");
	   pw.println("exit");
	   try {
		closeAll();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
       System.exit(0);//시스템 종료
   }
  });
  textArea = new JTextArea();
  textArea.setBackground(Color.YELLOW);
  frame.add(textArea, BorderLayout.CENTER);
  
  // 스크롤바 - 업데이트
    DefaultCaret caret = (DefaultCaret) textArea.getCaret();
    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    JScrollPane sp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    frame.add(sp, BorderLayout.CENTER);// 스크롤적용 JTextArea 갱신
  
  
  // textField와 button 을 생성한 후 panel에 두 요소를 추가하고
  // 이 panel을 frame의 south 위치에 추가한다
  textField = new JTextField(25);
  textField.addKeyListener(new KeyHandler());
  button = new JButton("전송");
  button.addActionListener(new ButtonHandler());
  panel = new JPanel();
  panel.add(textField);
  panel.add(button);
  frame.add(panel, BorderLayout.SOUTH);
  frame.setSize(400, 400);
  frame.setLocation(500, 200);
  frame.setVisible(true);
  // textField에 포커스를 준다
  textField.requestFocus();
 }

 public class ButtonHandler implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
   	  /*  친구들에게 보낼 메세지 쓴 내용을  textField 의 getText() 를 
	   *  이용해 가져와서 서버로 출력한다 
	   *  출력 후 setText("") 과 requestFocus()를 호출해 
	   *  입력란을 비워주고 커서를 준다
	   *  이러한 작업을 아래 별도의 메서드sendMessage에서 작업해서 
	   *  엔터키 이벤트시에도 재사용할 수 있도록 한다 
	   */	 
	  sendMessage();
  }
 }
	public void sendMessage() {
		pw.println(textField.getText());//서버로 출력 
		textField.setText("");
		textField.requestFocus();
	}

 public class KeyHandler extends KeyAdapter {
  @Override
  public void keyPressed(KeyEvent e) {
   // Enter key 를 눌렀을 때 이벤트 처리
   if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    /*  서버에 출력하는 sendMessage() 를 호출한다 
     *  
     */
	  sendMessage();
   }
  }
 }

 public void go() throws UnknownHostException, IOException {
	 /* GUI가 화면에 보이기 전에 통신에 필요한 
	  * 소켓과 입,출력 스트림을 생성한다 
	  * 또한 지속적으로 친구들의 메세지를 입력받을 
	  * ReceiverWorker Thread 를 생성하고 start 시킨다
	  * (start 시키기 전에 데몬스레드로 설정한다)
	  *  
	  */	 
	 socket=new Socket(IP.INST,5432);
	// System.out.println(socket.getInetAddress()+" "+socket.getLocalPort());
	 br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	 pw=new PrintWriter(socket.getOutputStream(),true);//true autoflush
	 ReceiverWorker worker=new ReceiverWorker();
	 Thread thread=new Thread(worker);
	 thread.setDaemon(true);
	 startUI();//화면을 구성하는 메서드 
	 thread.start();//스레드를 실행가능상태로 보내 jvm에 의해 실행하게 한다 
 }

 class ReceiverWorker implements Runnable {
  @Override
  public void run() {
   /* 서버에서 오는 친구들의 메세지를 입력받아 
    * 화면 상단 TextArea에 출력한다 
    * textArea.append(message+"\n");
    */
	  try {
		  while(true) {
			  String message=br.readLine();
			  if(message==null)
				  break;
			  textArea.append(message+"\n");
		  }
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }//run
 }//ReceiverWorker

 public static void main(String[] args) {
  ChattingGUIClient client = new ChattingGUIClient();
  try {
	
   client.go();
  } catch (IOException e) {
   e.printStackTrace();
  }//catch
 }//main
}//class
