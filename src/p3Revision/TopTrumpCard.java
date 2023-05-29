/**
 * 
 */
package p3Revision;


/**
 * @author Conall Murphy 
 * Student Number: 40236370
 */
public class TopTrumpCard {

	private String name;	
	private String realName;	
	private String ImageFilename;	
	private String Category;	
	private int Speed;	
	private int Strength;	
	private int Agility;	
	private int Intelligence;	
	private String Bio;
	
	private final int NAME_MIN_LENGTH = 1;
	private final int NAME_MAX_LENTGH = 30;
	private final int REAL_NAME_MIN_LENGTH = 1;
	private final int REAL_NAME_MAX_LENGTH = 30;
	private final int IMAGE_FILE_NAME_MIN_LENGTH = 5;
	private final int IMAGE_FILE_NAME_MAX_LENGTH = 30;
	private final int SPEED_MIN = 0;
	private final int SPEED_MAX = 100;
	private final int STRENGTH_MIN = 0;
	private final int STRENGTH_MAX = 100;
	private final int AGILITY_MIN = 0;
	private final int AGILITY_MAX = 100;
	private final int INTELLIGENCE_MIN = 0;
	private final int INTELLIGENCE_MAX = 100;
	
	/**
	 * @param name
	 * @param realName
	 * @param category2
	 * @param speed
	 * @param strength
	 * @param agility
	 * @param intelligence
	 * @param bio
	 */
	public TopTrumpCard(String name, String realName, String ImageFilename, String category2, int speed, int strength, int agility, int intelligence, String bio) {
		this.setName(name);
		this.setRealName(realName);
		this.setImageFilename(ImageFilename);
		this.setCategory(category2);
		this.setSpeed(speed);
		this.setStrength(strength);
		this.setAgility(agility);
		this.setIntelligence(intelligence);
		this.setBio(bio);
	}
	
	public TopTrumpCard() {
	}
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return Category;
	}
	
	/**
	 * @param category2 the category to set
	 * Business Rules: Hero or Villan 
	 */
	public void setCategory(String category2) {
		Category = category2;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the imageFilename
	 */
	public String getImageFilename() {
		return ImageFilename;
	}
	
	/**
	 * @param imageFilename the imageFilename to set
	 */
	public void setImageFilename(String imageFilename) throws IllegalArgumentException {
		if(imageFilename.length() < IMAGE_FILE_NAME_MIN_LENGTH || imageFilename.length() > IMAGE_FILE_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("Image File Name is not correct according to the specification. String must be between "+IMAGE_FILE_NAME_MIN_LENGTH+" and "+IMAGE_FILE_NAME_MIN_LENGTH+" characters");
		}else if(!imageFilename.endsWith("jpg")){
			throw new IllegalArgumentException("File Must end in .jpg ");
		}else
		{	
			ImageFilename = imageFilename;
		}
			
	}
	
	/**
	 * @param name the name to set
	 * Business Rules: At least 1 character but no more than 30
	 */
	public void setName(String name) throws IllegalArgumentException {
		if(name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENTGH) {
			throw new IllegalArgumentException("Name length must be between "+NAME_MIN_LENGTH+" and "+NAME_MAX_LENTGH+" characters");
		}else {
			this.name = name;
		}
			
	}
	
	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}
	
	/**
	 * @param realName the realName to set
	 * Business Rules: At least 1 character but no more than 30
	 */
	public void setRealName(String realName) throws IllegalArgumentException {
		if(realName.length() < REAL_NAME_MIN_LENGTH || realName.length() > REAL_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("Real Name length must be between "+REAL_NAME_MIN_LENGTH+" and "+REAL_NAME_MAX_LENGTH+" characters");
		}else {	
		this.realName = realName;
		}
		}
	
	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return Speed;
	}
	
	/**
	 * @param speed the speed to set
	 * Business Rules: Whole number 0-100 inclusive
	 */
	public void setSpeed(int speed) throws IllegalArgumentException {
		if(speed < SPEED_MIN || speed > SPEED_MAX) {
			throw new IllegalArgumentException("The value of Speed must be between "+SPEED_MIN+" and "+SPEED_MIN+" characters");
		}else {	
		Speed = speed;
		}
		}
	
	/**
	 * @return the strength
	 */
	public int getStrength() {
		return Strength;
	}
	
	/**
	 * @param strength the strength to set
	 * Business Rules: Whole number 0-100 inclusive
	 */
	public void setStrength(int strength) throws IllegalArgumentException {
		if(strength < STRENGTH_MIN || strength > STRENGTH_MAX) {
			throw new IllegalArgumentException("The value of Strength must be between "+STRENGTH_MIN+" and "+STRENGTH_MAX+" characters");
		}else {	
		Strength = strength;
		}
		}
	
	/**
	 * @return the agility
	 */
	public int getAgility() {
		return Agility;
	}
	
	/**
	 * @param agility the agility to set
	 * Business Rules: Whole number 0-100 inclusive
	 */
	public void setAgility(int agility) throws IllegalArgumentException {
		if(agility < AGILITY_MIN || agility > AGILITY_MAX) {
			throw new IllegalArgumentException("The value for Agility must be between "+AGILITY_MIN+" and "+AGILITY_MAX+" characters");
		}else {	
		Agility = agility;
		}
		}
	
	/**
	 * @return the intelligence
	 */
	public int getIntelligence() {
		return Intelligence;
	}
	
	/**
	 * @param intelligence the intelligence to set
	 * Business Rules: Whole number 0-100 inclusive
	 */
	public void setIntelligence(int intelligence) throws IllegalArgumentException {
		if(intelligence < INTELLIGENCE_MIN || intelligence > INTELLIGENCE_MAX) {
			throw new IllegalArgumentException("The value for Intelligence must be between "+INTELLIGENCE_MIN+" and "+INTELLIGENCE_MAX+" characters");
		}else {	
		Intelligence = intelligence;
		}
		}
	
	/**
	 * @return the bio
	 */
	public String getBio() {
		return Bio;
	}
	
	/**
	 * @param bio the bio to set
	 * Business Rules: Any length but cannot be null 
	 */
	public void setBio(String bio) throws IllegalArgumentException {
		if(bio == null) {
			throw new IllegalArgumentException("Bio cannot be null! Please try again and enter a valid value for Character Bio. Thank you!");
		}else {
			Bio = bio;
		}
		}		
	
	/**
	 * This method should return 0,1,2 or 3 depending on whether Speed, Strength, Agility or Intelligence 
	 * have the highest value respectively
	 * @return
	 */
	public int getMaxStatID() {
		int max = 0;
		int maxValue = this.getSpeed();
		
		if (this.getStrength() > maxValue) {
			max = 1;
			maxValue = this.getStrength();
		}
		if (this.getAgility() > maxValue) {
			max = 2;
			maxValue = this.getAgility();
		}
		if (this.getIntelligence() > maxValue) {
			max = 3;	
		}
		return max;	
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Agility;
		result = prime * result + ((Bio == null) ? 0 : Bio.hashCode());
		result = prime * result + ((Category == null) ? 0 : Category.hashCode());
		result = prime * result + ((ImageFilename == null) ? 0 : ImageFilename.hashCode());
		result = prime * result + Intelligence;
		result = prime * result + Speed;
		result = prime * result + Strength;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((realName == null) ? 0 : realName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopTrumpCard other = (TopTrumpCard) obj;
		if (Agility != other.Agility)
			return false;
		if (Bio == null) {
			if (other.Bio != null)
				return false;
		} else if (!Bio.equals(other.Bio))
			return false;
		if (Category == null) {
			if (other.Category != null)
				return false;
		} else if (!Category.equals(other.Category))
			return false;
		if (ImageFilename == null) {
			if (other.ImageFilename != null)
				return false;
		} else if (!ImageFilename.equals(other.ImageFilename))
			return false;
		if (Intelligence != other.Intelligence)
			return false;
		if (Speed != other.Speed)
			return false;
		if (Strength != other.Strength)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (realName == null) {
			if (other.realName != null)
				return false;
		} else if (!realName.equals(other.realName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n Top Trump Card \n Name: " + this.name + "\n Real Name: " + this.realName + "\n Image File Name: " + this.ImageFilename
				+ "\n Category: " + this.Category + "\n Speed: " + this.Speed + "\n Strength: " + this.Strength + "\n Agility: " + this.Agility
				+ "\n Intelligence: " + this.Intelligence + "\n Bio: " + this.Bio+"\n";
	}

	/**
	 * Should expect to receive an input of 0, 1, 2 or 3 and return the actual value of the 
	 * corresponding attribute Speed, Strength, Agility or Intelligence 
	 * @param statChoice
	 * @return
	 */
	public int getStatScore(int statChoice) {
		int statScore = -1;

		switch (statChoice) {
		case 0:
			statScore = this.getSpeed();
			break;
		case 1:
			statScore = this.getStrength();
			break;
		case 2:
			statScore = this.getAgility();
			break;
		case 3:
			statScore = this.getIntelligence();
			break;
		}

		return statScore;
	}

	public void displayNameAndBio() {
		System.out.println("Name: "+this.name);
		System.out.println("Bio: "+this.Bio);
		System.out.println("Length: "+getBio().length());
	}
	
	public void displayStatsFiveStrongest() {
		System.out.println("Name: "+this.name);
		System.out.println("Hero or Villan: "+this.Category);
		System.out.println("Speed: "+this.Speed);
		System.out.println("Strength: "+this.Strength);
		System.out.println("Agility: "+this.Agility);
		System.out.println("Intelligence: "+this.Intelligence);
	}
	
	public void displayAverage() {
		System.out.println("Name: "+this.name);
		System.out.println("Hero or Villan: "+this.Category);
		System.out.println("Average Stat: "+(getAgility()+getIntelligence()+getSpeed()+getStrength())/4);
		System.out.println();
	}
	
}

