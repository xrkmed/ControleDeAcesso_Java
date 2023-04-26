package Controllers;

import java.util.ArrayList;

import Database.UsersDAO;
import Internal.GlobalPermissions;
import Internal.LocationsInterface;
import Internal.UserInterface;

public class Locations implements LocationsInterface {

	//A classe locations deve ter um nome do lugar e as permissoes para entrar ali
	
	private String locationName;
	private final ArrayList<GlobalPermissions> neededPermissions = new ArrayList();
	
	
	public Locations() {
		
	}
	
	public Locations(String name) {
		locationName = name;
	}
	
	//Adicionar uma permissao necessaria para entrar na localizacao
	public void addNeededPermission(GlobalPermissions perm) {
		neededPermissions.add(perm);
	}
	
	public void removePermission(GlobalPermissions perm) {
		neededPermissions.remove(perm);
	}
	
	
	//Verificar se determinado usuario pode entrar neste local
	public boolean userCanJoin(UserInterface user) {
		for(GlobalPermissions perm : neededPermissions) {			
			if(user.hasPermission(perm)) {
				return true;
			}
				
			
		}
		
		return false;
	}
	
	
	//Saber quem esta dentro deste determinado local
	public ArrayList<UserInterface> getUsers(){
		UsersDAO database = new UsersDAO().getInstance();
		return database.getUsersInLocation(this);
	}
	
	
	//Funcao executada toda vez que recebe uma requisicao de entrada do usuario
	public boolean onUserJoin(UserInterface user) {
		if(!userCanJoin(user))
			return false;
		
		UsersDAO database = new UsersDAO().getInstance();
		return database.updateUserLocation(user, this);
	}

	@Override
	public String toString() {
		return locationName;
	}
	
	
	
}
