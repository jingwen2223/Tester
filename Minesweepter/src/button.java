import javax.swing.*;
public class button extends JButton {
 private int kind;
 private int postion;
 private boolean check;
 private boolean flagged;

public button(int kind,int postion, boolean check,boolean flagged) {
	this.kind= kind;
	this.postion= postion;
	this.check= check;
	this.flagged= flagged;
}
public int getKind() {
	return  kind;
}
public int getPostion() {
	return postion();
}


}


