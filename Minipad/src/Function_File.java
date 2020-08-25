import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
	MiniPad miniPad;
	String fileName,fileAddress;
	Function_File(MiniPad miniPad){
		this.miniPad=miniPad;
	}
	public void newFile() {
		miniPad.textarea.setText("");
		miniPad.window.setTitle("New");
		fileName=null;
		fileAddress=null;
	}
	public void open(){
		FileDialog fd=new FileDialog(miniPad.window,"Open",FileDialog.LOAD);
		fd.setVisible(true);
		
		if(fd.getFile()!=null) {
			fileName=fd.getFile();
			fileAddress=fd.getDirectory();
			miniPad.window.setTitle("fileName");
			}
		try {
			BufferedReader br=new BufferedReader(new FileReader(fileAddress+fileName));
			miniPad.textarea.setText("");
			String line=null;
			while((line=br.readLine())!=null)
			{
				miniPad.textarea.append(line+"\n");
			}
			br.close();
			/*FileReader fr=new FileReader(fileAddress+fileName);
			char[] b=new char[10];
			int cnt;
			while((cnt=fr.read(b))!=-1)
			{
				gui.textarea.append(new String(b,0,cnt));
			}
			
			*/
		}catch(Exception e) {
			System.out.println("File not opened!");
		}
	}
	public void save() {
		if(fileName==null) {
			saveas();
		}else {
			try {
				FileWriter fw=new FileWriter(fileAddress+fileName);
				fw.write(miniPad.textarea.getText());
				miniPad.window.setTitle(fileName);
				fw.close();
			}catch(Exception e) {System.out.println("Something wrong");}
		}
	}
	public void saveas() {
		FileDialog fd=new FileDialog(miniPad.window,"Save",FileDialog.SAVE);
		fd.setVisible(true);
		if((fd.getFile())!=null) {
			fileName=fd.getFile();
			fileAddress=fd.getDirectory();
			miniPad.window.setTitle(fileName);
		}
		try {
			FileWriter fw=new FileWriter(fileAddress+fileName);
			fw.write(miniPad.textarea.getText());
			fw.close();
		}catch(Exception e) {System.out.println("Something wrong");}
	}
	public void exit() {
		System.exit(0);
	}
	
}
