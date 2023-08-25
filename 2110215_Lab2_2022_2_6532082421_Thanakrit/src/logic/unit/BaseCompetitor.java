package logic.unit;

public class BaseCompetitor {
	private String name;
	private int power;
	private int hp;
	
	public BaseCompetitor(String name) {
		this.setName(name);
		this.setHp(5);
		this.setPower(3);
	}
	
	public BaseCompetitor(String name, int hp, int power) {
		this.setName(name);
		this.setHp(hp);
		this.setPower(power);
	}
	
	public void attack(BaseCompetitor enemy) {
		enemy.setHp(enemy.getHp()-this.getPower());
	}
	
	public String getType() {
		if(this instanceof Sorcerer) {
			return "Sorcerer";
		}
		if(this instanceof Tiger) {
			return "Tiger";
		}
		if(this instanceof ToughMan) {
			return "ToughMan";
		}
		return "BaseCompetitor";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setHp(int hp) {
		if(hp < 0) {
			hp = 0;
		}
		this.hp = hp;
	}
	public void setPower(int power) {
		if(power < 1) {
			power = 1;
		}
		this.power = power;
	}
	
	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public int getHp() {
		return hp;
	}
}
