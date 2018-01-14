import java.util.Scanner;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class TestPins {

	public static void main(String[] args) {
		TestPins tp = new TestPins();
		tp.testPinLoop();
	}

	private void testPinLoop() {
		boolean doContinue = true;
		Scanner scanner = new Scanner(System.in);
		final GpioController gpio = GpioFactory.getInstance();

		while (doContinue) {
			System.out.println("");
			System.out.println("Testing pins");
			System.out.println("Give the pin number to test, x to exit");

			System.out.print("PirjPin to test:");
			String pinRead = scanner.nextLine();

			if (pinRead.equalsIgnoreCase("x")) {
				doContinue = false;
				continue;
			}

			Pin pinToTest = getPinFromNumber(pinRead);
			if (pinToTest == null) {
				System.out.println("Pin not found");
				continue;
			}

			GpioPinDigitalOutput outputPin = gpio.provisionDigitalOutputPin(pinToTest, "MyLED", PinState.LOW);
			for (int repeat = 0; repeat < 5; repeat++) {
				try {
					outputPin.high();
					Thread.sleep(500);
					outputPin.low();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			gpio.unprovisionPin(outputPin);

			System.out.println("Testing pin:" + pinRead);
		}

		gpio.shutdown();
		scanner.close();
		System.out.println("Exitted ..");

	}

	private Pin getPinFromNumber(String number) {
		switch (number) {
		case "0":
			return RaspiPin.GPIO_00;
		case "1":
			return RaspiPin.GPIO_01;
		case "2":
			return RaspiPin.GPIO_02;
		case "3":
			return RaspiPin.GPIO_03;
		case "4":
			return RaspiPin.GPIO_04;
		case "5":
			return RaspiPin.GPIO_05;
		case "6":
			return RaspiPin.GPIO_06;
		case "7":
			return RaspiPin.GPIO_07;
		case "8":
			return RaspiPin.GPIO_08;
		case "9":
			return RaspiPin.GPIO_09;
		case "10":
			return RaspiPin.GPIO_10;
		case "11":
			return RaspiPin.GPIO_11;
		case "12":
			return RaspiPin.GPIO_12;
		case "13":
			return RaspiPin.GPIO_13;
		case "14":
			return RaspiPin.GPIO_14;
		case "15":
			return RaspiPin.GPIO_15;
		case "16":
			return RaspiPin.GPIO_16;
		case "17":
			return RaspiPin.GPIO_17;
		case "18":
			return RaspiPin.GPIO_18;
		case "19":
			return RaspiPin.GPIO_19;
		case "20":
			return RaspiPin.GPIO_20;
		case "21":
			return RaspiPin.GPIO_21;
		case "22":
			return RaspiPin.GPIO_22;
		case "23":
			return RaspiPin.GPIO_23;
		case "24":
			return RaspiPin.GPIO_24;
		case "25":
			return RaspiPin.GPIO_25;
		case "26":
			return RaspiPin.GPIO_26;
		case "27":
			return RaspiPin.GPIO_27;
		case "28":
			return RaspiPin.GPIO_28;
		case "29":
			return RaspiPin.GPIO_29;

		}

		return null;
	}

}
