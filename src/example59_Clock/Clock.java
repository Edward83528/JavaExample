package example59_Clock;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clock extends JFrame {
	public Clock() {
		super("類比時鐘");
		My_Clock my_Clock = new My_Clock();
		// 把設計的時鐘add進來
		add(my_Clock);
		// 下面的My_Clock已經繼承JPanel無法在繼承 TimerTask所以我選擇用Java.swing中的Timer
		// Timer(int delay, ActionListener listener)
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				my_Clock.timer();
			}
		});
		timer.start();
		setSize(400, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Clock();
	}
}

// 設計一個時鐘類別
class My_Clock extends JPanel {
	Calendar calendar = Calendar.getInstance();
	// 宣告數字刻度
	String number[] = { "12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" };
	int minute;
	int second;
	int hour;
	// x1和y1為我設定的圓心
	int x1 = 200;
	int y1 = 200;

	public My_Clock() {
		setBackground(Color.PINK);// 背景為粉色
	
	}

	public void timer() {
		// setTimeInMillis依給定的long值來設定目前日曆的現在時間
		// public static long currentTimeMillis()方法返回毫秒
		calendar.setTimeInMillis(System.currentTimeMillis());
		// 重畫
		repaint();
	}

	// 畫出時針/分針/秒針
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		// 隨時更新現在的時間
		minute = calendar.get(Calendar.MINUTE);
		second = calendar.get(Calendar.SECOND);
		hour = calendar.get(Calendar.HOUR);
		// 設置秒針
		g2D.setColor(Color.BLACK);// 秒針為黑色
		// x1,y1為圓心
		// 加110減110為我設置秒針的長度(你可以自己設定)
		g2D.drawLine(x1, y1, (int) (x1 + 110 * Math.sin((second ) * Math.PI / 30)),
				(int) (y1 - 110 * Math.cos((second ) * Math.PI / 30)));
		// 設置分針
		// x1,y1為圓心
		// 加80減80為我設置的長度(你可以自己設定)
		g2D.setColor(Color.YELLOW);// 分針為黃色
		g2D.drawLine(x1, y1, (int) (x1 + 80 * Math.sin(minute * Math.PI / 30)),
				(int) (y1 - 80 * Math.cos(minute * Math.PI / 30)));
		// 設置時針
		g2D.setColor(Color.RED);// 時針為紅色
		// x1,y1為圓心
		/// 加60減60為我設置的長度(你可以自己設定)
		g2D.drawLine(x1, y1, (int) (x1 + 60 * Math.sin((hour + minute / 60.0) * Math.PI / 6)),
				(int) (y1 - 60 * Math.cos((hour + minute / 60.0) * Math.PI / 6)));
		// 呼叫印出數字刻度
		paintNumber(g2D);
	}

	// 印出時鐘數字刻度
	public void paintNumber(Graphics2D g2d) {
		// 設置細微的60格為藍色
		// 印出格子
		g2d.setColor(Color.BLUE);
		for (int i = 0; i < 60; i++) {
			g2d.drawLine((int) (x1 - 110 * Math.cos(i * Math.PI / 30)), (int) (y1 + 110 * Math.sin(i * Math.PI / 30)),
					(int) (x1 - 120 * Math.cos(i * Math.PI / 30)), (int) (y1 + 120 * Math.sin(i * Math.PI / 30)));
		}
		// 印出數字
		for (int i = 0; i < 12; i++) {
			g2d.setColor(Color.BLACK);
			// drawString(印出的文字, int x, int y)
			g2d.drawString(number[i], (int) (x1 + 135 * Math.sin(i * Math.PI / 6)) - 5,
					(int) (y1 - 135 * Math.cos(i * Math.PI / 6)) + 5);
		}
	}
}