package Controllers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import Internal.GlobalPermissions;
import Internal.LocationsInterface;
import Internal.UserInterface;
import Internal.UserPermissionsInterface;

public class UserEntity implements UserInterface {

	private long userUniqueId;
	private String userIdentificator;
	private final UserPermissionsInterface userPermissions = new UserPermissions();
	private final HashMap<Long, RouteEntity> routeHistory = new HashMap<>();
	
	public UserEntity() {
		
	}
	
	public UserEntity(long userUniqueId, String userIdentificator) {
		this.userUniqueId = userUniqueId;
		this.userIdentificator = userIdentificator;
	}
	
	public boolean addRouteEntity(LocationsInterface oldLocation, LocationsInterface newLocation) {
		String timeString = new SimpleDateFormat("HH:mm:ss.SSSS dd/MM/yyyy").format(new java.util.Date());
		routeHistory.put(routeHistory.size()+1L, new RouteEntity(timeString, oldLocation, newLocation));
		return true;
	}
	
	public void imprimirRotas() {
		System.out.println("Log> Confira todos os caminhos que " + userIdentificator + " fez:");
		
		routeHistory.forEach((Long uniqueId, RouteEntity route) -> {
			if(route.getFromLocation() != null) {
				System.out.println("Log> O Usuario " + userIdentificator + " foi de " + route.getFromLocation() + " para " + route.getToLocation() + " as " + route.getDateString());
			}else {
				System.out.println("Log> O Usuario " + userIdentificator + " entrou na " + route.getToLocation() + " as " + route.getDateString());
			}
			
		});
	}
	
	//Verificar se o usuario tem determinada permissao
	public boolean hasPermission(GlobalPermissions permission) {
		if(userPermissions.UserHasPermission(permission)) {
			return true;
		}
		
		return false;
	}
	
	public long getUserUniqueId() {
		return userUniqueId;
	}
	
	
	//Retornar nome do usuario
	public String getUserIdentificator() {
		return userIdentificator;
	}
	
	//Rodar esta function apenas ao iniciar a database ou em promocoes hierarquicas
	public void addPermission(GlobalPermissions perm) {
		userPermissions.addUserPermission(perm);
		return;
	}
	
	
	
	
}
