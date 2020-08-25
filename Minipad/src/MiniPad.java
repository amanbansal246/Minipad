import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class MiniPad implements ActionListener{
	JFrame window;
	//TEXTAREA
	JTextArea textarea;
	JScrollPane scrollpane;
	boolean wordWrapOn =false;
	//TOP MENU BAR
	JMenuBar menubar;
	JMenu menuFile,menuEdit,menuFormat,menuColor;
	//FILE MENU
	JMenuItem iNew,iOpen,iSave,iSaveAs,iExit;
	//FORMAT MENU
	JMenuItem iWrap,iFontArial,iFontCSMS,iFontTNR,iFontSize8,iFontSize12,iFontSize16,iFontSize20,iFontSize24,iFontSize28,iBold,iItalic,iUnderline;
	
	JMenu menuFont,menuFontsize,menuFontstyle;
	//COLOR MENU
	JMenuItem iColor1,iColor2,iColor3;
	
	//EDIT MENU
	JMenuItem iUndo,iRedo;
	Function_File file=new Function_File(this);
	Function_Format format=new Function_Format(this);
	Function_Color color=new Function_Color(this);
	Function_Edit edit=new Function_Edit(this);
	
	UndoManager um=new UndoManager();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiniPad();
	}
	public MiniPad() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createFormatmenu();
		createColorMenu();
		
		format.selectedFont="Arial";
		format.createFont(16);
		format.wordWrap();
		color.changeColor("White");
		
		window.setVisible(true);
	}
	public void createWindow() {
		window=new JFrame("Notepad");
		window.setBounds(100,100,800,600);
	}
	public void createTextArea() {
		textarea=new JTextArea();
		textarea.getDocument().addUndoableEditListener(
				new UndoableEditListener(){
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				}
				);
		
		scrollpane=new JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		window.add(scrollpane);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		//window.add(textarea);
	}
	public void createMenuBar(){
		menubar=new JMenuBar();
		window.setJMenuBar(menubar);
		
		menuFile=new JMenu("File");
		menubar.add(menuFile);
		
		menuEdit=new JMenu("Edit");
		menubar.add(menuEdit);
		
		menuFormat=new JMenu("Format");
		menubar.add(menuFormat);
		
		menuColor=new JMenu("Color");
		menubar.add(menuColor);
	}
	public void createFileMenu() {
		iNew=new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen=new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");		
		menuFile.add(iOpen);
		
		iSave=new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs=new JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		iExit=new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}
	public void createEditMenu() {
		iUndo=new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo=new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
	}
	public void createFormatmenu() {
		iWrap=new JMenuItem("Word Wrap: off ");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);
		
		menuFont =new JMenu("Font");
		menuFormat.add(menuFont);
		
		iFontArial=new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCSMS=new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);
		
		iFontTNR=new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		menuFontsize =new JMenu("Font Size");
		menuFormat.add(menuFontsize);
		
		menuFontstyle =new JMenu("Font Style");
		menuFormat.add(menuFontstyle);

		iFontSize8=new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontsize.add(iFontSize8);
		
		iFontSize12=new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontsize.add(iFontSize12);
		
		iFontSize16=new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontsize.add(iFontSize16);
		
		iFontSize20=new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("size20");
		menuFontsize.add(iFontSize20);
		
		iFontSize24=new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("size24");
		menuFontsize.add(iFontSize24);
		
		iFontSize28=new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("size28");
		menuFontsize.add(iFontSize28);
		
		iBold=new JMenuItem("Bold");
		iBold.addActionListener(this);
		iBold.setActionCommand("Bold");
		menuFontstyle.add(iBold);
		
		iItalic=new JMenuItem("Italic");
		iItalic.addActionListener(this);
		iItalic.setActionCommand("Italic");
		menuFontstyle.add(iItalic);
		
		iUnderline=new JMenuItem("Underline");
		iUnderline.addActionListener(this);
		iUnderline.setActionCommand("Underline");
		menuFontstyle.add(iUnderline);
	}
	public void createColorMenu() {
		iColor1=new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);
		
		iColor2=new JMenuItem("Black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Black");
		menuColor.add(iColor2);
		
		iColor3=new JMenuItem("Blue");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Blue");
		menuColor.add(iColor3);
	}
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		switch(command) {
		case "New": file.newFile(); break;
		case "Open": file.open(); break;
		case "Save": file.save(); break;
		case "SaveAs": file.saveas(); break;
		case "Exit": file.exit(); break;
		case "Undo": edit.undo(); break;
		case "Redo": edit.redo(); break;
		case "Word Wrap": format.wordWrap(); break;
		case "Arial" : format.setFont(command); break;//font
		case "Comic Sans MS" : format.setFont(command); break;
		case "Times New Roman" : format.setFont(command); break;
		case "size8": format.createFont(8); break;//size
		case "size12": format.createFont(12); break;
		case "size16": format.createFont(16); break;
		case "size20": format.createFont(20); break;
		case "size24": format.createFont(24); break;
		case "size28": format.createFont(28); break;
		case "White": color.changeColor(command); break;//color
		case "Black": color.changeColor(command); break;
		case "Blue": color.changeColor(command); break;
		/*case "Bold": format.changeStyle(command); break;//style
		case "Italic": format.changeStyle(command); break;
		case "Underline": format.changeStyle(command); break;
		*/
		}
	}
}
