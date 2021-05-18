package concrete;

import java.util.Date;

import framework.Item;
import framework.ItemCreater;

public class MpCreater extends ItemCreater {

	@Override
	protected void requestItemInfo() {
		// TODO Auto-generated method stub
		System.out.println("데이터베이스에서 마력 물약의 정보를 가져옴");
	}

	@Override
	protected void createImageLog() {
		// TODO Auto-generated method stub
		System.out.println("마력 물약을 새롭게 생성 " + new Date());
	}

	@Override
	protected Item createItem() {
		// TODO Auto-generated method stub
		return new HpPotion();
	}

}
