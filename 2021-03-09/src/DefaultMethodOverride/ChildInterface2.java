package DefaultMethodOverride;

public interface ChildInterface2 extends ParentInterface {
	
	@Override
	public default void method2() {
		
	}
	
	public void method3();
}
