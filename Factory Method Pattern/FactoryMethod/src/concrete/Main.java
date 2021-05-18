package concrete;

import framework.Item;
import framework.ItemCreater;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemCreater creater;
		Item item;

		creater = new HpCreater();
		item = creater.create();

		item.use();
		creater = new MpCreater();
		creater.create();
		item.use();
	}

}
