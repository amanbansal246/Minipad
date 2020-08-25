import java.awt.Font;

public class Function_Format {
	MiniPad miniPad;
	Font arial,comicSansMS,timesNewRoman;
	String selectedFont;
	Function_Format(MiniPad miniPad){
		this.miniPad=miniPad;
	}
	public void wordWrap() {
		if(miniPad.wordWrapOn==false) {
			miniPad.wordWrapOn=true;
			miniPad.textarea.setLineWrap(true); 
			miniPad.textarea.setWrapStyleWord(true); //do not break words.mean line break between words
			miniPad.iWrap.setText("Word Wrap: On");
		}else if(miniPad.wordWrapOn==true) {
			miniPad.wordWrapOn=false;
			miniPad.textarea.setLineWrap(false); 
			miniPad.textarea.setWrapStyleWord(false); //do not break words.mean line break between words
			miniPad.iWrap.setText("Word Wrap: Off");
		}
	}
	public void createFont(int fontSize) {
		arial=new Font( "Arial",Font.PLAIN,fontSize);
		comicSansMS=new Font("Comic",Font.PLAIN,fontSize);
		timesNewRoman=new Font("Times New Roman",Font.PLAIN,fontSize);
		setFont(selectedFont);
	}
	public void setFont(String font) {
		selectedFont=font;
		switch(selectedFont) {
		case "Arial":
			miniPad.textarea.setFont(arial);  
			break;
		case "Comic Sans MS ":
			miniPad.textarea.setFont(comicSansMS);
			break;
		case "Times New Roman":
			miniPad.textarea.setFont(timesNewRoman);
			break;
		}
	}

}
