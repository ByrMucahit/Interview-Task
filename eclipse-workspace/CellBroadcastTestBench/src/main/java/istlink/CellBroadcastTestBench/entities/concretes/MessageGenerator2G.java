package istlink.CellBroadcastTestBench.entities.concretes;

import java.sql.Timestamp;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="_main")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernatelazyInitializer","handler","_main"})
public class MessageGenerator2G {
	
	

	@Column(name="timestamp")
	  private Timestamp timeStamp;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idStamp", nullable=false)
	  private Integer idStamp;

	@Column(name="msg_status")
	  private String msg_status;
	
	@Column(name="msg_generation")
	  private String msg_generation;
	
	@Column(name="message_type")
	  private String message_type;
	
	@Column(name="serial_number")
	  private String serial_number;
	
	@Column(name="new_serial_number")
	  private String new_serial_number;
	
	@Column(name="old_serial_number")
	  private String old_serial_number;
	
	@Column(name="message_identifier")
	  private String message_identifier;
	
	@Column(name="category")
	  private String category;
	
	@Column(name="list_of_TAIs")
	  private String list_of_TAIs;
	
	@Column(name="warning_area_list")
	  private String warning_area_list;
	
	@Column(name="repetition_period")
	  private String repetition_period;
	
	@Column(name="extended_repetition_period")
	  private String extended_repetition_period;
	
	@Column(name="number_of_broadcasts_requested")
	  private String number_of_broadcasts_requested;
	
	 @Column(name="broadcast_message_content")
	  private String broadcast_message_content;
	
	 @Column(name="warning_security_information")
	  private String warning_security_information;
	
	 @Column(name="data_coding_scheme")
	  private String data_coding_scheme;
	
	 @Column(name="warning_message_content")
	  private String warning_message_content;
	
	 @Column(name="omc_id") 
	 private String omc_id;
	 
	 @Column(name="concurrent_warning_message_indicator")
	  private String concurrent_warning_message_indicator;
	 
	 @Column(name="send_write_replace_warning_indication")
	  private String send_write_replace_warning_indication;
	 
	 @Column(name="global_enb_id")
	 private String global_enb_id;
	 
	  @Column(name="send_stop_warning_indication")
	  private String send_stop_warning_indication;
	 
	  @Column(name="stop_all_indicator")
	  private String stop_all_indicator;
	 
	  @Column(name="paging_etws_indicator")
	  private String paging_etws_indicator;
	
	  @Column(name="message_structure")
	  private String message_structure;
	  
	  @Column(name="warning_type")
	  private String warning_type;
	 
	  @Column(name="broadcast_message_content_validity_indicator")
	  private String broadcast_message_content_validity_indicator;

	  @Column(name="emergency_indicator")
	  private String emergency_indicator;

	  @Column(name="channel_indicator")
	  private String channel_indicator;
	
	  @Column(name="number_of_pages")
	  private String number_of_pages;
	  
	  @Column(name="schedule_period")
	  private String schedule_period;
	  
	  @Column(name="number_of_reserved_slots")
	  private String number_of_reserved_slots;
	 
	  @Column(name="broadcast_message_type")
	  private String broadcast_message_type;
	
	  @Column(name="warning_period")
	  private String warning_period;
	  
	  @Column(name="length_indicator")
	  private String length_indicator;
	
	  @Column(name="keep_alive_repetition_period")
	  private String keep_alive_repetition_period;
	  
	  @Column(nullable=true, name="cause")
	  private Integer cause;
	 
	  @Column(name="criticality_diagnostics")
	  private String criticality_diagnostics;
	 
	  @Column(name="broadcast_scheduled_area_list")
	  private String broadcast_scheduled_area_list;
	  
	  @Column(name="broadcast_cancelled_area_list")
	  private String broadcast_cancelled_area_list; 
	  
	  @Column(name="broadcast_empty_area_list")
	  private String broadcast_empty_area_list;
	  
	  @Column(name="restarted_cell_list")
	  private Integer restarted_cell_list;
	 
	  @Column(name="list_of_TAIs_restart")
	  private String list_of_TAIs_restart;
	  
	  @Column(name="list_of_EAIs_restart")
	  private String list_of_EAIs_restart;
	  
	  @Column(name="failed_cell_list")
	  private String failed_cell_list;
	  
	  @Column(name="failure_list")
	  private String failure_list;
	  
	 @Column(name="number_of_broadcasts_completed_list")
	  private String number_of_broadcasts_completed_list;
	
	 @Column(name="radio_resource_loading_list")
	  private String radio_resource_loading_list;

	 @Column(name="recovery_indication")
	  private String recovery_indication;
	
	 @Column(name="service_areas_list")
	  private String service_areas_list;
	 
	 @Column(name="typeoferror")
	  private String typeoferror;
	
	 @Column(name="cell_list")
	  private String cell_list;
	 
	 @Column(name="extras")
	  private String extras;

	 @Column(name="unknown_tracking_area_list")
	  private String unknown_tracking_area_list;

	 @Column(name="messagetype_response")
	  private String messagetype_response;
	
	  @Column(name="ip_address")
	  private String ip_address;
	
	  @Column(name="is_broadcast_started")
	  private Short is_broadcast_started; 
	 
	  @Column(name="is_draft")
	  private short is_draft;
	 
	  @Column(name="is_deletee")
	  private short is_deletee;
	  
	  @Column(name="sender_id")
	  private int sender_id; 
	 
	  @Column(name="department_id")
	  private int department_id; 
	  
	  @Column(name="subject")
	  private String subject;
	  
	  @Column(name="language")
	  private int language;
	  
	  @Column(name="selected_map_areas")
	  private String selected_map_areas;
	 
	  @Column(name="start_time")
	  private Timestamp start_time; 
	
	  @Column(name="end_time")
	  private Timestamp end_time;
	 
	  @Column(name="status")
	  private String status;
	  
	  @Column(name="updated_map_areas")
	  private String updated_map_areas;
	  
	  @Column(name="killed_map_areas")
	  private String killed_map_areas; 
	 
	  @Column(name="status_map_areas")
	  private String status_map_areas;
	
	  @Column(name="counter")
	  private Integer counter;
	
	  @Column(name="is_abnormal_message")
	  private short is_abnormal_message;
	  
	  @Column(name="selected_cells")
	  private String selected_cells;
	 
	  public MessageGenerator2G() {
		  
	  }
	  
	public MessageGenerator2G(Timestamp timestamp, Integer idStamp, String msg_status, String msg_generation, String message_type, String serial_number, String new_serial_number,
			String old_serial_number, String message_identifier, String category, String list_of_TAIs, String warning_area_list,String repetition_period,  String extended_repetition_period,
			String number_of_broadcasts_requested, String broadcast_message_content,  String warning_security_information, String data_coding_scheme, String warning_message_content,
			String omc_id, String concurrent_warning_message_indicator, String send_write_replace_warning_indication,  String global_enb_id, String send_stop_warning_indication, String stop_all_indicator,
			String paging_etws_indicator, String message_structure,  String warning_type, String broadcast_message_content_validity_indicator,  String emergency_indicator, String channel_indicator,
			 String number_of_pages, String schedule_period,String number_of_reserved_slots, String broadcast_message_type, String warning_period, String length_indicator,String keep_alive_repetition_period,
			 Integer cause, String criticality_diagnostics, String broadcast_scheduled_area_list, String broadcast_cancelled_area_list, String broadcast_empty_area_list, Integer restarted_cell_list,
			 String list_of_TAIs_restart, String list_of_EAIs_restart, String failed_cell_list,  String failure_list, String number_of_broadcasts_completed_list, String radio_resource_loading_list,
			 String recovery_indication, String service_areas_list, String typeoferror, String cell_list, String extras, String unknown_tracking_area_list, String messagetype_response, String ip_address,
			 Short is_broadcast_started, short is_draft,  short is_deletee, int sender_id, int department_id, String subject, int language, String selected_map_areas, Timestamp start_time, Timestamp end_time,
			 String status, String updated_map_areas,String killed_map_areas, String status_map_areas, Integer counter, short is_abnormal_message, String selected_cells) {
		super();
		this.timeStamp = timestamp;
		this.idStamp = idStamp;
		this.msg_status = msg_status;
		this.msg_generation = msg_generation;
		this.message_type = message_type;
		this.serial_number = serial_number;
		this.new_serial_number = new_serial_number;
		this.old_serial_number = old_serial_number;
		this.message_identifier =message_identifier;
		this.category = category;
		this.list_of_TAIs = list_of_TAIs;
		this.warning_area_list = warning_area_list;
		this.repetition_period = repetition_period;
		this.extended_repetition_period = extended_repetition_period;
		this.number_of_broadcasts_requested = number_of_broadcasts_requested;
		this.broadcast_message_content = broadcast_message_content;
		this.warning_security_information = warning_security_information;
		this.data_coding_scheme = data_coding_scheme;
		this.warning_message_content = warning_message_content;
		this.omc_id = omc_id;
		this.concurrent_warning_message_indicator = concurrent_warning_message_indicator;
		this.send_write_replace_warning_indication = send_write_replace_warning_indication;
		this.global_enb_id = global_enb_id;
		this.send_stop_warning_indication = send_stop_warning_indication;
		this.stop_all_indicator = stop_all_indicator;
		this.paging_etws_indicator = paging_etws_indicator;
		this.message_structure = message_structure;
		this.warning_type = warning_type;
		this.broadcast_message_content_validity_indicator = broadcast_message_content_validity_indicator;
		this.emergency_indicator = emergency_indicator;
		this.channel_indicator = channel_indicator;
		this.number_of_pages = number_of_pages;
		this.schedule_period = schedule_period;
		this.number_of_reserved_slots = number_of_reserved_slots;
		this.broadcast_message_type = broadcast_message_type;
		this.warning_period = warning_period;
		this.length_indicator = length_indicator;
		this.keep_alive_repetition_period = keep_alive_repetition_period;
		this.cause = cause;
		this.criticality_diagnostics = criticality_diagnostics;
		this.broadcast_scheduled_area_list = broadcast_scheduled_area_list;
		this.broadcast_cancelled_area_list = broadcast_cancelled_area_list;
		this.broadcast_empty_area_list = broadcast_empty_area_list;
		this.restarted_cell_list = restarted_cell_list;
		this.list_of_TAIs_restart = list_of_TAIs_restart;
		this.list_of_EAIs_restart = list_of_EAIs_restart;
		this.failed_cell_list = failed_cell_list;
		this.failure_list = failure_list;
		this.number_of_broadcasts_completed_list = number_of_broadcasts_completed_list;
		this.radio_resource_loading_list = radio_resource_loading_list;
		this.recovery_indication = recovery_indication;
		this.service_areas_list = service_areas_list;
		this.typeoferror = typeoferror;
		this.cell_list = cell_list;
		this.extras = extras;
		this.unknown_tracking_area_list = unknown_tracking_area_list;
		this.messagetype_response = messagetype_response;
		this.ip_address =ip_address;
		this.is_broadcast_started = is_broadcast_started;
		this.is_draft = is_draft;
		this.is_deletee = is_deletee;
		this.sender_id = sender_id;
		this.department_id = department_id;
		this.subject = subject;
		this.language = language;
		this.selected_map_areas = selected_map_areas;
		this.start_time = start_time;
		this.end_time = end_time;
		this.status = status;
		this.updated_map_areas = updated_map_areas;
		this.killed_map_areas = killed_map_areas;
		this.status_map_areas = status_map_areas;
		this.counter = counter;
		this.is_abnormal_message = is_abnormal_message;
		this.selected_cells = selected_cells;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timestamp) {
		this.timeStamp = timestamp;
	}
	
	public Integer getIdStamp() {
		return idStamp;
	}

	public void setIdStamp(Integer idStamp) {
		this.idStamp = idStamp;
	}

	public String getMsg_status() {
		return msg_status;
	}

	public void setMsg_status(String msg_status) {
		this.msg_status = msg_status;
	}

	public String getMsg_generation() {
		return msg_generation;
	}

	public void setMsg_generation(String msg_generation) {
		this.msg_generation = msg_generation;
	}

	public String getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getNew_serial_number() {
		return new_serial_number;
	}

	public void setNew_serial_number(String new_serial_number) {
		this.new_serial_number = new_serial_number;
	}

	public String getOld_serial_number() {
		return old_serial_number;
	}

	public void setOld_serial_number(String old_serial_number) {
		this.old_serial_number = old_serial_number;
	}

	public String getMessage_identifier() {
		return message_identifier;
	}

	public void setMessage_identifier(String message_identifier) {
		this.message_identifier = message_identifier;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getList_of_TAIs() {
		return list_of_TAIs;
	}

	public void setList_of_TAIs(String list_of_TAIs) {
		this.list_of_TAIs = list_of_TAIs;
	}

	public String getWarning_area_list() {
		return warning_area_list;
	}

	public void setWarning_area_list(String warning_area_list) {
		this.warning_area_list = warning_area_list;
	}

	public String getRepetition_period() {
		return repetition_period;
	}

	public void setRepetition_period(String repetition_period) {
		this.repetition_period = repetition_period;
	}

	public String getExtended_repetition_period() {
		return extended_repetition_period;
	}

	public void setExtended_repetition_period(String extended_repetition_period) {
		this.extended_repetition_period = extended_repetition_period;
	}

	public String getNumber_of_broadcasts_requested() {
		return number_of_broadcasts_requested;
	}

	public void setNumber_of_broadcasts_requested(String number_of_broadcasts_requested) {
		this.number_of_broadcasts_requested = number_of_broadcasts_requested;
	}

	public String getBroadcast_message_content() {
		return broadcast_message_content;
	}

	public void setBroadcast_message_content(String broadcast_message_content) {
		this.broadcast_message_content = broadcast_message_content;
	}

	public String getWarning_security_information() {
		return warning_security_information;
	}

	public void setWarning_security_information(String warning_security_information) {
		this.warning_security_information = warning_security_information;
	}

	public String getData_coding_scheme() {
		return data_coding_scheme;
	}

	public void setData_coding_scheme(String data_coding_scheme) {
		this.data_coding_scheme = data_coding_scheme;
	}

	public String getWarning_message_content() {
		return warning_message_content;
	}

	public void setWarning_message_content(String warning_message_content) {
		this.warning_message_content = warning_message_content;
	}

	public String getOmc_id() {
		return omc_id;
	}

	public void setOmc_id(String omc_id) {
		this.omc_id = omc_id;
	}

	public String getConcurrent_warning_message_indicator() {
		return concurrent_warning_message_indicator;
	}

	public void setConcurrent_warning_message_indicator(String concurrent_warning_message_indicator) {
		this.concurrent_warning_message_indicator = concurrent_warning_message_indicator;
	}

	public String getSend_write_replace_warning_indication() {
		return send_write_replace_warning_indication;
	}

	public void setSend_write_replace_warning_indication(String send_write_replace_warning_indication) {
		this.send_write_replace_warning_indication = send_write_replace_warning_indication;
	}

	public String getGlobal_enb_id() {
		return global_enb_id;
	}

	public void setGlobal_enb_id(String global_enb_id) {
		this.global_enb_id = global_enb_id;
	}

	public String getSend_stop_warning_indication() {
		return send_stop_warning_indication;
	}

	public void setSend_stop_warning_indication(String send_stop_warning_indication) {
		this.send_stop_warning_indication = send_stop_warning_indication;
	}

	public String getStop_all_indicator() {
		return stop_all_indicator;
	}

	public void setStop_all_indicator(String stop_all_indicator) {
		this.stop_all_indicator = stop_all_indicator;
	}

	public String getPaging_etws_indicator() {
		return paging_etws_indicator;
	}

	public void setPaging_etws_indicator(String paging_etws_indicator) {
		this.paging_etws_indicator = paging_etws_indicator;
	}

	public String getMessage_structure() {
		return message_structure;
	}

	public void setMessage_structure(String message_structure) {
		this.message_structure = message_structure;
	}

	public String getWarning_type() {
		return warning_type;
	}

	public void setWarning_type(String warning_type) {
		this.warning_type = warning_type;
	}

	public String getBroadcast_message_content_validity_indicator() {
		return broadcast_message_content_validity_indicator;
	}

	public void setBroadcast_message_content_validity_indicator(String broadcast_message_content_validity_indicator) {
		this.broadcast_message_content_validity_indicator = broadcast_message_content_validity_indicator;
	}

	public String getEmergency_indicator() {
		return emergency_indicator;
	}

	public void setEmergency_indicator(String emergency_indicator) {
		this.emergency_indicator = emergency_indicator;
	}

	public String getChannel_indicator() {
		return channel_indicator;
	}

	public void setChannel_indicator(String channel_indicator) {
		this.channel_indicator = channel_indicator;
	}

	public String getNumber_of_pages() {
		return number_of_pages;
	}

	public void setNumber_of_pages(String number_of_pages) {
		this.number_of_pages = number_of_pages;
	}

	public String getSchedule_period() {
		return schedule_period;
	}

	public void setSchedule_period(String schedule_period) {
		this.schedule_period = schedule_period;
	}

	public String getNumber_of_reserved_slots() {
		return number_of_reserved_slots;
	}

	public void setNumber_of_reserved_slots(String number_of_reserved_slots) {
		this.number_of_reserved_slots = number_of_reserved_slots;
	}

	public String getBroadcast_message_type() {
		return broadcast_message_type;
	}

	public void setBroadcast_message_type(String broadcast_message_type) {
		this.broadcast_message_type = broadcast_message_type;
	}

	public String getWarning_period() {
		return warning_period;
	}

	public void setWarning_period(String warning_period) {
		this.warning_period = warning_period;
	}

	public String getLength_indicator() {
		return length_indicator;
	}

	public void setLength_indicator(String length_indicator) {
		this.length_indicator = length_indicator;
	}

	public String getKeep_alive_repetition_period() {
		return keep_alive_repetition_period;
	}

	public void setKeep_alive_repetition_period(String keep_alive_repetition_period) {
		this.keep_alive_repetition_period = keep_alive_repetition_period;
	}
	
	public Integer  getCause() {
		return cause;
	}

	public void setCause(Integer  cause) {
		this.cause = cause;
	}

	public String getCriticality_diagnostics() {
		return criticality_diagnostics;
	}

	public void setCriticality_diagnostics(String criticality_diagnostics) {
		this.criticality_diagnostics = criticality_diagnostics;
	}

	public String getBroadcast_scheduled_area_list() {
		return broadcast_scheduled_area_list;
	}

	public void setBroadcast_scheduled_area_list(String broadcast_scheduled_area_list) {
		this.broadcast_scheduled_area_list = broadcast_scheduled_area_list;
	}

	public String getBroadcast_cancelled_area_list() {
		return broadcast_cancelled_area_list;
	}

	public void setBroadcast_cancelled_area_list(String broadcast_cancelled_area_list) {
		this.broadcast_cancelled_area_list = broadcast_cancelled_area_list;
	}

	public String getBroadcast_empty_area_list() {
		return broadcast_empty_area_list;
	}

	public void setBroadcast_empty_area_list(String broadcast_empty_area_list) {
		this.broadcast_empty_area_list = broadcast_empty_area_list;
	}

	public Integer getRestarted_cell_list() {
		return restarted_cell_list;
	}

	public void setRestarted_cell_list(Integer restarted_cell_list) {
		this.restarted_cell_list = restarted_cell_list;
	}

	public String getList_of_TAIs_restart() {
		return list_of_TAIs_restart;
	}

	public void setList_of_TAIs_restart(String list_of_TAIs_restart) {
		this.list_of_TAIs_restart = list_of_TAIs_restart;
	}

	public String getList_of_EAIs_restart() {
		return list_of_EAIs_restart;
	}

	public void setList_of_EAIs_restart(String list_of_EAIs_restart) {
		this.list_of_EAIs_restart = list_of_EAIs_restart;
	}

	public String getFailed_cell_list() {
		return failed_cell_list;
	}

	public void setFailed_cell_list(String failed_cell_list) {
		this.failed_cell_list = failed_cell_list;
	}

	public String getFailure_list() {
		return failure_list;
	}

	public void setFailure_list(String failure_list) {
		this.failure_list = failure_list;
	}

	public String getNumber_of_broadcasts_completed_list() {
		return number_of_broadcasts_completed_list;
	}

	public void setNumber_of_broadcasts_completed_list(String number_of_broadcasts_completed_list) {
		this.number_of_broadcasts_completed_list = number_of_broadcasts_completed_list;
	}

	public String getRadio_resource_loading_list() {
		return radio_resource_loading_list;
	}

	public void setRadio_resource_loading_list(String radio_resource_loading_list) {
		this.radio_resource_loading_list = radio_resource_loading_list;
	}

	public String getRecovery_indication() {
		return recovery_indication;
	}

	public void setRecovery_indication(String recovery_indication) {
		this.recovery_indication = recovery_indication;
	}

	public String getService_areas_list() {
		return service_areas_list;
	}

	public void setService_areas_list(String service_areas_list) {
		this.service_areas_list = service_areas_list;
	}

	public String getTypeoferror() {
		return typeoferror;
	}

	public void setTypeoferror(String typeoferror) {
		this.typeoferror = typeoferror;
	}

	public String getCell_list() {
		return cell_list;
	}

	public void setCell_list(String cell_list) {
		this.cell_list = cell_list;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public String getUnknown_tracking_area_list() {
		return unknown_tracking_area_list;
	}

	public void setUnknown_tracking_area_list(String unknown_tracking_area_list) {
		this.unknown_tracking_area_list = unknown_tracking_area_list;
	}

	public String getMessagetype_response() {
		return messagetype_response;
	}

	public void setMessagetype_response(String messagetype_response) {
		this.messagetype_response = messagetype_response;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public Short getIs_broadcast_started() {
		return is_broadcast_started;
	}

	public void setIs_broadcast_started(Short is_broadcast_started) {
		this.is_broadcast_started = is_broadcast_started;
	}

	public short getIs_draft() {
		return is_draft;
	}

	public void setIs_draft(short is_draft) {
		this.is_draft = is_draft;
	}

	public short getIs_deletee() {
		return is_deletee;
	}

	public void setIs_deletee(short is_deletee) {
		this.is_deletee = is_deletee;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public String getSelected_map_areas() {
		return selected_map_areas;
	}

	public void setSelected_map_areas(String selected_map_areas) {
		this.selected_map_areas = selected_map_areas;
	}

	public Timestamp getStart_time() {
		return start_time;
	}

	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}

	public Timestamp getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdated_map_areas() {
		return updated_map_areas;
	}

	public void setUpdated_map_areas(String updated_map_areas) {
		this.updated_map_areas = updated_map_areas;
	}

	public String getKilled_map_areas() {
		return killed_map_areas;
	}

	public void setKilled_map_areas(String killed_map_areas) {
		this.killed_map_areas = killed_map_areas;
	}

	public String getStatus_map_areas() {
		return status_map_areas;
	}

	public void setStatus_map_areas(String status_map_areas) {
		this.status_map_areas = status_map_areas;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public short getIs_abnormal_message() {
		return is_abnormal_message;
	}

	public void setIs_abnormal_message(short is_abnormal_message) {
		this.is_abnormal_message = is_abnormal_message;
	}

	public String getSelected_cells() {
		return selected_cells;
	}

	public void setSelected_cells(String selected_cells) {
		this.selected_cells = selected_cells;
	}


	
	  

}
