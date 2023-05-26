package main;

public class PhysicsUtilities {
	public static double distance(Entity entity1, Entity entity2) {
		return Math.sqrt(Math.pow(entity1.x - entity2.x, 2) + Math.pow(entity1.y - entity2.y, 2));
	}
	
	public static int ceilDiv(int x, int y){
	    return -Math.floorDiv(-x,y);
	}

}
