package logic.unit;

public class ToughMan extends BaseCompetitor{
	private int maxHp;
	
	public ToughMan(String name) {
		super(name,8,4);
		this.setMaxHp(8);
	}
	
	public ToughMan(String name,int hp,int power) {
		super(name,hp,power);
		this.setMaxHp(hp);
	}
	
	public void heal(int healHp) {
		if(healHp <= 0) {
			return;
		}
		int newHp = this.getHp() + healHp;
		if(newHp > this.getMaxHp()) {
			newHp = this.getMaxHp();
		}
		this.setHp(newHp);
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public void attack(BaseCompetitor enemy) {
		String type = enemy.getType();
		int damage = this.getPower();
		if(type.equals("Sorcerer")) {
			damage = damage / 2;
		}
		if(type.equals("Tiger")) {
			damage = damage * 3 / 2;
		}
		enemy.setHp(enemy.getHp()-damage);
	}
	
	public void setMaxHp(int maxHp) {
		if(maxHp < 0) {
			maxHp = 0;
		}
		if(this.getHp() > maxHp) {
			this.setHp(maxHp);
		}
		this.maxHp = maxHp;
	}
	
}
