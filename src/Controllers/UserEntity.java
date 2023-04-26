package Controllers;

import Internal.GlobalPermissions;
import Internal.UserInterface;
import Internal.UserPermissionsInterface;

public class UserEntity implements UserInterface {

	private long userUniqueId;
	private String userIdentificator;
	private final UserPermissionsInterface userPermissions = new UserPermissions();
	
	public UserEntity() {
		
	}
	
	public UserEntity(long userUniqueId, String userIdentificator) {
		this.userUniqueId = userUniqueId;
		this.userIdentificator = userIdentificator;
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
