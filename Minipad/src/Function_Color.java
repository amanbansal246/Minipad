import java.awt.Color;

public class Function_Color {
	MiniPad miniPad;
	Function_Color(MiniPad miniPad){
		this.miniPad=miniPad;
	}
	public void changeColor(String color) {
		switch(color) {
		case "White":
			miniPad.window.getContentPane().setBackground(Color.white);
			miniPad.textarea.setBackground(Color.white);
			miniPad.textarea.setForeground(Color.black);
			break;
		case "Black":
			miniPad.window.getContentPane().setBackground(Color.black);
			miniPad.textarea.setBackground(Color.black);
			miniPad.textarea.setForeground(Color.white);
			break;
		case "Blue":
			miniPad.window.getContentPane().setBackground(new Color(28,186,186));
			miniPad.textarea.setBackground(new Color(28,186,186));
			miniPad.textarea.setForeground(Color.white);
			break;
		}
	}
}
