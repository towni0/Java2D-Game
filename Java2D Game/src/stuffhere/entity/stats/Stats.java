package stuffhere.entity.stats;

public class Stats {
	// Start values
	private final int START_HEALTH = 20;
	private final int START_LEVEL = 1;
	private final int START_MANA = 5;
	private final int START_DAMAGE = 1;
	private final int START_MOVEMENT_SPEED = 5;
	private final int START_ATTACK_SPEED = 5;
	private final int START_ARMOUR = 5;
	private final int START_RESISTANCE = 5;
	private final int START_CRITICAL_CHANCE = 10;
	
	private int health;
	private int mana;
	private int exp;
	private int level;
	private int damage;
	private int attackSpeed;
	private int movementSpeed;
	private int armour;
	private int resistance;
	private int criticalChance;
	
	public Stats() {
		super();
		this.health = START_HEALTH;
		this.mana = START_MANA;
		this.level = START_LEVEL;
		this.damage = START_DAMAGE;
		this.attackSpeed = START_ATTACK_SPEED;
		this.movementSpeed = START_MOVEMENT_SPEED;
		this.armour = START_ARMOUR;
		this.resistance = START_RESISTANCE;
		this.criticalChance = START_CRITICAL_CHANCE;
	}


	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public int getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public int getArmour() {
		return armour;
	}

	public void setArmour(int armour) {
		this.armour = armour;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public int getCriticalChance() {
		return criticalChance;
	}

	public void setCriticalChance(int criticalChance) {
		this.criticalChance = criticalChance;
	}
	


}
