package Controllers;

import Internal.LocationsInterface;
import Internal.RouteEntityInterface;

public class RouteEntity implements RouteEntityInterface {
	
	private final LocationsInterface fromLocation;
	private final LocationsInterface toLocation;
	private final String dateString;
	
	public RouteEntity() {
		fromLocation = null;
		toLocation = null;
		dateString = "01/02/1965";
	}
	
	public RouteEntity(String date, LocationsInterface fromLocation, LocationsInterface toLocation) {
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.dateString = date;
	}
	
	public LocationsInterface getFromLocation() {
		return fromLocation;
	}
	
	public LocationsInterface getToLocation() {
		return toLocation;
	}
	
	public String getDateString() {
		return dateString;
	}
	
	@Override
	public String toString() {
		return "{date: "+ dateString +", fromLocation: " + fromLocation + ", toLocation: " + toLocation + "}";
	}

}
