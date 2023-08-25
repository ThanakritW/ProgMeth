package logic.unit;

public class Sorcerer extends BaseCompetitor {
	public Sorcerer(String name) {
		super(name,4,2);
	}
	public Sorcerer(String name,int hp,int power) {
		super(name,hp,power);
	}
	public void lowerPower(BaseCompetitor enemy, int powerDown) {
		if(powerDown < 1) {
			return;
		}
		if(powerDown >= enemy.getPower()) {
			enemy.setPower(1);
			return;
		}
		enemy.setPower(enemy.getPower()-powerDown);		
	}
	public void attack(BaseCompetitor enemy) {
		String type = enemy.getType();
		int damage = this.getPower();
		if(type.equals("Tiger")) {
			damage = damage / 2;
		}
		if(type.equals("ToughMan")) {
			damage = damage * 3 / 2;
		}
		enemy.setHp(enemy.getHp()-damage);
	}
	
}
