package DocumentBenchTest.demobenchtest.entities.concretes;
import java.util.LinkedHashMap;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.json.simple.JSONObject;

@Data
@Entity
@Table(name="_main")
@AllArgsConstructor
@NoArgsConstructor
public class GeneralInserGenerator {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idStamp;
	
	@Column(name="sender_id", nullable=false)
	private int sender_id;
	
	
	@Column(name="department_id", nullable=false)
	@NotNull(message="Please enter departman id")
	private Integer department_id;
	
	@Column(name="language", nullable=false)
	@NotNull(message ="Please enter language")
	private Integer language;
	
	  
	  private String selected_cells;
	
	 
	 
	  
	public GeneralInserGenerator() {
		
	}

	public GeneralInserGenerator( int idStamp, int sender_id, int department_id, Integer language, String selected_cells) {
		super();
		
		this.idStamp = idStamp;
		this.sender_id = sender_id;
		this.department_id = department_id;
		this.language = language;
		
		
	}

	

	public int getIdStamp() {
		return idStamp;
	}

	public void setIdStamp(int idStamp) {
		this.idStamp = idStamp;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public Integer getLanguage() {
		return language;
	}

	public void setLanguage(Integer language) {
		this.language = language;
	}
	@Column(name="selected_cells")
	public String getSelected_cells() {
		
		return selected_cells;
	}

	public void setSelected_cells(String selected_cells) {
		
		
		this.selected_cells = toJson();;
	}


	public String toJson() {
		
		JSONObject jObj = new JSONObject();
		JSONObject tjObj = new JSONObject();
		ArrayList<JSONObject> tArray = new ArrayList<JSONObject>();
		ArrayList<JSONObject> arrays= new ArrayList<JSONObject>();
		
		tjObj.put("s", this.sender_id);
		tjObj.put("l", this.department_id);
		
		tArray.add(tjObj);
		
		jObj.put("C", this.idStamp);
		jObj.put("N", tArray);
	
		arrays.add(jObj);
		return arrays.toString();
	}
}
