package kosketusanturi;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EV3TouchSensor ts = new EV3TouchSensor(SensorPort.S1);
		float[] sample = new float[ts.sampleSize()];
		int osu = 0;

		LCD.drawString("Paina kytkinta", 0, 0);
		while (!Button.ESCAPE.isDown()) {
			ts.fetchSample(sample, 0);

			if (sample[0] == 1) {
				osu++;
				 LCD.clear();
				 String x = "" + osu;
				 LCD.drawString(x, 0, 0);
				 Delay.msDelay(5000);
			}
		}
		
		int aika=0;
		ts.fetchSample(sample, 0);
		while(sample[0] == 1) {
			Delay.msDelay(1000);
			aika++;
		}
		int sek = aika % 60;
		int min = aika / 60;
		LCD.clear();
		 String pohjassa = "Pohjassa: " + min + "min, " + sek + "sek";
		 LCD.drawString(pohjassa, 0, 0);
		 Delay.msDelay(5000);
		
		ts.close();
	}
}
