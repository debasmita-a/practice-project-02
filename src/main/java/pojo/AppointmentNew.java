package pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Getter

public class AppointmentNew {

	//required fields :
	private String factility;
	private boolean admission;
	private String program;
	private String date;
	
	//non required fields :
	private String comments;
}
