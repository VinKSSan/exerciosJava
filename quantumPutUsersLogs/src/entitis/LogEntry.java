package entitis;

import java.util.Date;
import java.util.Objects;

public class LogEntry {
	private String userName;
	private Date moment;
	
	public LogEntry(String name, Date moment) {
		super();
		this.userName = name;
		this.moment = moment;
	}
	public String getName() {
		return userName;
	}
	public void setName(String name) {
		this.userName = name;
	}
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEntry other = (LogEntry) obj;
		return Objects.equals(userName, other.userName);
	}
	
	
	
}
