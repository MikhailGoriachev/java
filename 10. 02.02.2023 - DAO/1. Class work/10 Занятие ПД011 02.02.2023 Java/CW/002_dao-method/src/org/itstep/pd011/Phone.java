package org.itstep.pd011;

// модель для таблицы phones - справочник служебных номеров
public class Phone extends Entity {
	
    private int    id;
    private String phoneNumber;
	private String description;

	public Phone() { this(-1, "162", "номер телефона"); }

	public Phone(int id, String phoneNumber, String description) {
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Phone{" +
				"id=" + id +
				", phoneNumber='" + phoneNumber + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
