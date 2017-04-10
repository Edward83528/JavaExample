package example58_blackboard;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Blackboard extends JFrame {
	private JButton clear, undo, redo, color, save, open;
	Drawer drawer;

	Blackboard() {
		super("簽名板");
		setLayout(new BorderLayout());
		clear = new JButton("刪除");
		undo = new JButton("上一洞");
		redo = new JButton("回復");
		color = new JButton("選顏色");
		save = new JButton("存檔");
		open = new JButton("打開");
		setSize(800, 600);
		JPanel jPanel = new JPanel(new FlowLayout());
		jPanel.add(clear);
		jPanel.add(undo);
		jPanel.add(redo);
		jPanel.add(color);
		jPanel.add(save);
		jPanel.add(open);
		add(jPanel, BorderLayout.NORTH);
		drawer = new Drawer();
		add(drawer, BorderLayout.CENTER);
		// 以上程式為畫面布局
		// addActionListener為button按鈕監聽器
		// 按下刪除按鈕所觸發的事件
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawer.clear();
			}
		});
		// 按下上一洞按鈕所觸發的事件
		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawer.undo();
			}
		});
		// 按下回復按鈕所觸發的事件
		redo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawer.redo();
			}
		});
		// 按下選顏色按鈕所觸發的事件
		color.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JColorChooser.showDialog(對話框的父類別,對話框的標題,顏色選色器的初始顏色設定)
				Color newColor = JColorChooser.showDialog(Blackboard.this, "Select a Color", Color.BLUE);
				drawer.color(newColor);
			}

		});
		// 按下存檔按鈕所觸發的事件
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawer.save_file();
			}
		});
		// 按下打開按鈕所觸發的事件
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawer.open_file();
			}
		});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		Blackboard blackboard = new Blackboard();

	}

}

// ==========================================================================================
class Drawer extends JPanel {
	// 最外層用LinkedList來收集多條線集合
	// 第二層用LinkedList來收集多點集合(因為有次序)
	// 最內層用HashMap收集每一點(用Map的key值來代表x和y座標可增加可讀性)
	LinkedList<LinkedList<HashMap<String, Integer>>> lines, recycle;
	Color drawer_color = Color.WHITE;

	public Drawer() {
		setBackground(Color.BLACK);
		Mouse listener = new Mouse();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		lines = new LinkedList<>();
		recycle = new LinkedList<>();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(drawer_color);
		g2d.setStroke(new BasicStroke(4));
		// 多條線
		for (LinkedList<HashMap<String, Integer>> line : lines) {
			// 一條線
			for (int i = 1; i < line.size(); i++) {
				HashMap<String, Integer> p0 = line.get(i - 1);
				HashMap<String, Integer> p1 = line.get(i);
				int x0 = p0.get("x"), y0 = p0.get("y");
				int x1 = p1.get("x"), y1 = p1.get("y");
				g2d.drawLine(x0, y0, x1, y1);
			}
		}
	}

	// 按下刪除按鈕所觸發的事件呼叫的方法
	public void clear() {
		lines.clear();
		repaint();
	}

	// 按下上一洞按鈕所觸發的事件呼叫的方法
	public void undo() {
		if (lines.size() > 0) {
			recycle.add(lines.removeLast());
			repaint();
		}
	}

	// 按下回復按鈕所觸發的事件呼叫的方法
	public void redo() {
		if (recycle.size() > 0) {
			lines.add(recycle.removeLast());
			repaint();
		}
	}

	// 按下選顏色按鈕所觸發的事件呼叫的方法
	public void color(Color color) {
		drawer_color = color;
	}

	// 按下存檔按鈕所觸發的事件呼叫的方法
	public void save_file() {

	}

	// 按下打開按鈕所觸發的事件呼叫的方法
	public void open_file() {

	}

	// MouseListener 介面 (interface)
	// 進行滑鼠事件的處理，需要實作mouseClicked()、mousePressed()、mouseReleased()、mouseEntered()、mouseExited()方法
	// 宣告Mouse直接繼承自 MouseAdapter 類別， MouseAdapter 已經實作 MouseListener介面
	// 滑鼠觸發事件的監聽器
	class Mouse extends MouseAdapter {
		// 按下滑鼠觸發事件
		@Override
		// mousePressed() 處理按住滑鼠鍵的動作
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			// 要畫新線就把垃圾桶清掉
			recycle.clear();
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
			// 用HashMap來收集點
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			// 線就是點的集合
			line.add(point);
			// 再把每條線收集成線集合用LinkedList存放
			lines.add(line);
		}

		// 拖曳滑鼠時觸發事件
		@Override
		public void mouseDragged(MouseEvent e) {
			super.mouseDragged(e);
			// 用HashMap來收集點
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			lines.getLast().add(point);
			repaint();
		}
	}

}
