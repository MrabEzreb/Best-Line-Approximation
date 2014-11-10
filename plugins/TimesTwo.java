package plugins;

import com.ezreb.math.MathFunction;
import com.ezreb.math.PluginLoader;

public class TimesTwo implements MathFunction {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		MathFunction f = TimesTwo.class.newInstance();
		PluginLoader.addFunctionOption(f);
	}
	@Override
	public String calculate(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
