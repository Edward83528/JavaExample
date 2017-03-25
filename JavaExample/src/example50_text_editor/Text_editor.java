package example50_text_editor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Text_editor extends JFrame {
	JButton Open, Save, Exit;// 宣告元件
	JTextArea jTextArea;
	File selectedFile;

	Text_editor() {
		super("文字編輯器");
		setVisible(true);
		setSize(1000, 600);
		Open = new JButton("Open");
		Save = new JButton("Save");
		Exit = new JButton("Exit");
		setLayout(new BorderLayout());
		JPanel jpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jTextArea = new JTextArea();// 文字顯現區
		JScrollPane scrollpane = new JScrollPane(jTextArea);// JScrollPane若文字超出邊框則可往下移動
		jpanel.add(Open);
		jpanel.add(Save);
		jpanel.add(Exit);

		add(jpanel, BorderLayout.NORTH);
		add(scrollpane, BorderLayout.CENTER);
		// Open監聽器 產生觸發事件
		Open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();

			}
		});
		// Save監聽器 產生觸發事件
		Save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// Exit監聽器 產生觸發事件
		Exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 按下Open按鍵後觸發的事件
	protected void openFile() {
		JFileChooser filechoose = new JFileChooser();// 檔案選擇器
		/*
		 * 使用JFileChooser的showOpenDialog()方法來打開文件對話框
		 * 此方法在用戶按下按鈕或關閉對話框時會返回一個整數值,這個整數值的類型有3種,分別是:
		 * 1.JFileChooser.CANCEL_OPTION:表示用戶按下取消按鈕.
		 * 2.JFileChooser.APPROVE_OPTION:表示用戶按下確定按鈕.
		 * 3.JFileChooser.ERROR_OPEION:表示有錯誤產生或是對話框不正常關閉.
		 * 
		 */
		int returnValue = filechoose.showOpenDialog(null);
		if (returnValue == filechoose.APPROVE_OPTION) {// 假如整數值等於確定件數值就取得文件
			selectedFile = filechoose.getSelectedFile();// 利用getSelectedFile()方法取得文件對象
			print();
		}

	}

	private void print() {

		FileReader reader = null;
		try {
			int count;
			reader = new FileReader(selectedFile);
			while ((count = reader.read()) != -1) {
				jTextArea.append("" + (char) count);
			}
			reader.close();
		} catch (Exception e) {

			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		Text_editor text = new Text_editor();

	}

}
