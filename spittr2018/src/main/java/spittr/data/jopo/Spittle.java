package spittr.data.jopo;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spittle {
	
	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;
	
	public Spittle(String message,Date time){
		
		this(null,message,time,null,null);
	}
	public Spittle(Long id,String message,Date time,Double latitude,Double longtitude){
		
		this.id=id;
		this.message=message;
		this.time=time;
		this.latitude=latitude;
		this.longitude=longtitude;
	}
	
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longtitude) {
		this.longitude = longtitude;
	}
	public Long getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public Date getTime() {
		return time;
	}
	
	
		
	@Override
	public boolean equals(Object o){
		
		
		return EqualsBuilder.reflectionEquals(this, o, "id","time");
		
	}
	
	@Override
	public int hashCode(){
		
		return HashCodeBuilder.reflectionHashCode(this, "id","time");
	}

}
