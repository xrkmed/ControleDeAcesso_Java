package Controllers;

import java.util.ArrayList;
import java.util.Objects;

import Internal.AccessPointInterface;
import Internal.LocationsInterface;
import Internal.UserInterface;

public class PontoDeAcesso implements AccessPointInterface {
	
	//A classe do ponto de acesso devera ter a localizacao de onde ela esta e o id do ponto
	
	private LocationsInterface pontoLoc;
	private long pointId; 

	
	public PontoDeAcesso() {
		
	}
	
	public PontoDeAcesso(long id, LocationsInterface ponto) {
		this.pointId = id;
		this.pontoLoc = ponto;
	}
	
	
	public ArrayList<UserInterface> getUsers(){
		return pontoLoc.getUsers();
	}
	
	
	public boolean addUser(UserInterface user) {
		return pontoLoc.onUserJoin(user);
	}
	
	public String getName() {
		return pontoLoc.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(pointId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PontoDeAcesso other = (PontoDeAcesso) obj;
		return pointId == other.pointId;
	}
	
	
}
