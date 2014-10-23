import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;


public class NumberJButton extends JButton {

	public NumberJButton() {
		super();
		initButton();
	}

	public NumberJButton(Icon arg0) {
		super(arg0);
		initButton();	
	}

	public NumberJButton(String arg0) {
		super(arg0);
		initButton();
	}

	public NumberJButton(Action arg0) {
		super(arg0);
		initButton();
	}

	public NumberJButton(String arg0, Icon arg1) {
		super(arg0, arg1);
		initButton();
	}
	public void initButton(){
		this.setBackground(Color.GREEN);
	}

}
