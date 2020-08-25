
public class Function_Edit {
	MiniPad miniPad;
	Function_Edit(MiniPad miniPad){
		this.miniPad=miniPad;
	}
	public void undo(){
		miniPad.um.undo();
	}
	public void redo() {
		miniPad.um.redo();
	}
}
