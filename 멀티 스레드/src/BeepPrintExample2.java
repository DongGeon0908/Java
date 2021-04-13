

import java.awt.Toolkit;

public class BeepPrintExample2 {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				toolkit.beep();
				try {
					Thread.sleep(500);
				} catch (Exception e) {

				}
			}
			
		});
		thread.start();
		
		for(int i=0; i <5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				
			}
		}
	}
}
