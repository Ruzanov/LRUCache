package data;

/**
 * Created with IntelliJ IDEA. User: inver Date: 26.05.13 Time: 15:48 To change
 * this template use File | Settings | File Templates.
 */
public class Item {

	private Integer id;

	private String someData;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSomeData() {
		return someData;
	}

	public void setSomeData(String someData) {
		this.someData = someData;
	}

	public Item(Integer id, String someData) {
		super();
		this.id = id;
		this.someData = someData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((someData == null) ? 0 : someData.hashCode());
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (someData == null) {
			if (other.someData != null)
				return false;
		} else if (!someData.equals(other.someData))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (this == null)
			return "item is null!";
		return "item [key=" + getId() + ", someData=" + getSomeData() + "]";
	}

}
