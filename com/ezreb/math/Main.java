package com.ezreb.math;

import java.io.IOException;

class Main {
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
		final PluginLoader loader = new PluginLoader();
		windows.start();
	}
	final static MathWindow windows = new MathWindow();
}
