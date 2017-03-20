package example43_interfacePractice2;

public class InterfacePractice2 {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(5, 10);
		Square square = new Square(5);
		System.out.println("長方形的面積:" + rectangle.countarea());
		System.out.println("正方形的面積:" + square.countarea());

	}
}

interface Polygon {
	// 計算周長的方法
	double countgirth();

	// 計算面積的方法
	double countarea();
}

class Rectangle implements Polygon {
	double l, w;

	// 利用建構式存入初始值
	Rectangle(double l, double w) {
		this.l = l;
		this.w = w;
	}

	public double countgirth() {
		return l * 2 + w * 2;

	}

	public double countarea() {
		return l * w;
	}

}

class Square implements Polygon {
	double l;

	Square(double l) {
		this.l = l;
	}

	public double countgirth() {
		return l * 4;

	}

	public double countarea() {
		return l * l;
	}

}
