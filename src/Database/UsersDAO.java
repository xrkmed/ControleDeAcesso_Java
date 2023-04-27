package Database;

import java.util.ArrayList;
import java.util.HashMap;

import Internal.LocationsInterface;
import Internal.UserInterface;

public class UsersDAO {

	public static UsersDAO _instance;
	
	//Controle de acesso de onde todos estao
	private final HashMap<UserInterface, LocationsInterface> userLocation = new HashMap<>();
	
	//Singleton Class
	public UsersDAO getInstance() {
		if(UsersDAO._instance == null) {
			_instance = new UsersDAO();
		}
		
		return _instance;
	}
	
	
	//Procurar aonde um determinado usuario esta
	public LocationsInterface findUser(UserInterface user) {
		return userLocation.getOrDefault(user, null);
	}
	
	//Saber quem esta em determinada localizacao
	public ArrayList<UserInterface> getUsersInLocation(LocationsInterface loc){
		ArrayList<UserInterface> result = new ArrayList();
		userLocation.forEach((UserInterface user, LocationsInterface locRegistry) -> {
			if(locRegistry == loc) {
				result.add(user);
			}
		});
		
		return result;
	}
	
	
	//Executar travessia de uma localizacao para outra localizacao
	public boolean updateUserLocation(UserInterface user, LocationsInterface newLocation) {
		try {
			LocationsInterface oldLocation = findUser(user);
			if(newLocation.userCanJoin(user)) {
				userLocation.compute(user, (usuario, location) -> {
					if(location != newLocation) {
						location = newLocation;
					}
					
					return location;
				});
				
				return true;
			}
			
			
		}catch(Exception userException) {
			// tratar futuramente esta excecao
		}
		
		return false;
	}
	
	
}
