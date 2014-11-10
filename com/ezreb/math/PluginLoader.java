/**
 * Loads plugins into the system.
 */
package com.ezreb.math;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Mrab Ezreb
 *
 */
public class PluginLoader extends ClassLoader {

	static MathFunction[] plugins = new MathFunction[100];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	@SuppressWarnings("static-access")
	public static String getFunction(String chosenMath, double x1, double y1, double x2, double y2) {
		for (MathFunction math : plugins) {
			if(math.chosenMath==chosenMath) {
				return math.calculate(x1, y1, x2, y2);
			}
		}
		return "";
	}
	
	/**
	 * Adds a function from a plugin. ChosenMath is the name that will be shown.
	 * 
	 * @param chosenMath
	 */
	@SuppressWarnings("static-access")
	public static void addFunctionOption(MathFunction f) {
		MenuItem func = new MenuItem(f.chosenMath);
		final String choose = f.chosenMath;
		func.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.windows.chosenMath = choose;
			}
		});
		Main.windows.menuCalc.add(func);
		System.arraycopy(plugins, 0, plugins, 0, plugins.length);
		plugins[plugins.length] = f;
	}
}
