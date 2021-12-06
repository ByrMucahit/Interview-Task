package istlink.CellBroadcastTestBench.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="_main")
@AllArgsConstructor
@NoArgsConstructor

public class NumericGenerator {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idStamp")
	private int idStamp;
	
	 @Column(nullable=true, name="cause")
	  private Integer cause;
	 
	 @Column(name="restarted_cell_list")
	  private Integer restarted_cell_list;
	 
	 @Column(name="is_broadcast_started")
	  private Short is_broadcast_started; 
	 @Column(name="is_draft")
	  private Short is_draft;
	 
	  @Column(name="is_deletee")
	  private Short is_deletee;
	  
	  @Column(name="sender_id")
	  private Integer sender_id; 
	 
	  @Column(name="department_id")
	  private Integer department_id; 
	  @Column(name="language")
	  private Integer language;
	  
	  @Column(name="counter")
	  private Integer counter;
	
	  @Column(name="is_abnormal_message")
	  private Short is_abnormal_message;
	  
	  public NumericGenerator() {
		  
	  }

	public NumericGenerator(int idStamp, Integer cause, Integer restarted_cell_list, Short is_broadcast_started,
			Short is_draft, Short is_deletee, Integer sender_id, Integer department_id, Integer language, Integer counter,
			Short is_abnormal_message) {
		super();
		this.idStamp = idStamp;
		this.cause = cause;
		this.restarted_cell_list = restarted_cell_list;
		this.is_broadcast_started = is_broadcast_started;
		this.is_draft = is_draft;
		this.is_deletee = is_deletee;
		this.sender_id = sender_id;
		this.department_id = department_id;
		this.language = language;
		this.counter = counter;
		this.is_abnormal_message = is_abnormal_message;
	}

	public int getIdStamp() {
		return idStamp;
	}

	public void setIdStamp(int idStamp) {
		this.idStamp = idStamp;
	}

	public Integer getCause() {
		return cause;
	}

	public void setCause(Integer cause) {
		this.cause = cause;
	}

	public Integer getRestarted_cell_list() {
		return restarted_cell_list;
	}

	public void setRestarted_cell_list(Integer restarted_cell_list) {
		this.restarted_cell_list = restarted_cell_list;
	}

	public Short getIs_broadcast_started() {
		return is_broadcast_started;
	}

	public void setIs_broadcast_started(Short is_broadcast_started) {
		this.is_broadcast_started = is_broadcast_started;
	}

	public Short getIs_draft() {
		return is_draft;
	}

	public void setIs_draft(Short is_draft) {
		this.is_draft = is_draft;
	}

	public Short getIs_deletee() {
		return is_deletee;
	}

	public void setIs_deletee(Short is_deletee) {
		this.is_deletee = is_deletee;
	}

	public Integer getSender_id() {
		return sender_id;
	}

	public void setSender_id(Integer sender_id) {
		this.sender_id = sender_id;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public Integer getLanguage() {
		return language;
	}

	public void setLanguage(Integer language) {
		this.language = language;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public Short getIs_abnormal_message() {
		return is_abnormal_message;
	}

	public void setIs_abnormal_message(Short is_abnormal_message) {
		this.is_abnormal_message = is_abnormal_message;
	}

}
