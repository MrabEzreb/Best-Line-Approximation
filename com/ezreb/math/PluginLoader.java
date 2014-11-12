/**
 * Loads plugins into the system.
 */
package com.ezreb.math;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * @author Mrab Ezreb
 *
 */
public class PluginLoader extends ClassLoader {

	static MathFunction[] plugins2 = new MathFunction[100];
	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public PluginLoader() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Package pluginDir = Package.getPackage("plugins");
		ClassLoader loader = getSystemClassLoader();
		String arg0 = loader.getResource(pluginDir.getName()).toString();
		System.out.println(arg0);
		//System.out.println(loader.getResources("plugins").nextElement().getPath());
		//System.out.println(loader.getResource("plugins/TimesTwo").getFile());
		@SuppressWarnings("unchecked")
		Class<? extends MathFunction> clas = (Class<? extends MathFunction>) loadClass("plugins/TimesTwo");
		//Constructor<? extends MathFunction> construct = clas.getDeclaredConstructor(clas);
		MathFunction func = clas.newInstance();
		addFunctionOption(func);

	}
	public static String getFunction(String chosenMath, double x1, double y1, double x2, double y2) {
		for (MathFunction math : plugins2) {
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
	public static void addFunctionOption(MathFunction f) {
		MenuItem func = new MenuItem(f.chosenMath);
		final String choose = f.chosenMath;
		func.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.windows.chosenMath = choose;
			}
		});
		Main.windows.menuCalc.add(func);
		System.arraycopy(plugins2, 0, plugins2, 0, plugins2.length);
		plugins2[plugins2.length] = f;
	}
}
