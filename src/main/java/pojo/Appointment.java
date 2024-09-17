package pojo;

public class Appointment {
	//required fields :
	private String factility;
	private boolean admission;
	private String program;
	private String date;
	
	//non required fields :
	private String comments;
	
	private Appointment(AppointmentBuilder builder) {
		this.factility = builder.factility;
		this.admission = builder.admission;
		this.program = builder.program;
		this.date = builder.date;
		this.comments = builder.comments;
	}
	
	public String getFactility() {
		return factility;
	}
	public void setFactility(String factility) {
		this.factility = factility;
	}
	public boolean isAdmission() {
		return admission;
	}
	public void setAdmission(boolean addmission) {
		this.admission = addmission;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	static class AppointmentBuilder{
		
		//required fields :
		private String factility;
		private boolean admission;
		private String program;
		private String date;
		
		//non required fields :
		private String comments;
		
		public AppointmentBuilder(String facility, boolean admission, String program, String date) {
			this.factility = facility;
			this.admission = admission;
			this.program = program;
			this.date = date;
		}

		public void setFactility(String factility) {
			this.factility = factility;
		}

		public void setAdmission(boolean admission) {
			this.admission = admission;
		}

		public void setProgram(String program) {
			this.program = program;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}
		
		public Appointment build() {
			return new Appointment(this);
		}
	}
	
	

}
