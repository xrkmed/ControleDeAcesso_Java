package Controllers;

import java.util.ArrayList;

import Internal.GlobalPermissions;
import Internal.UserPermissionsInterface;

public class UserPermissions implements UserPermissionsInterface {
	
	private final ArrayList<GlobalPermissions> userPermissions = new ArrayList();
	
	
	public UserPermissions() {
		
	}
	
	public void addUserPermission(GlobalPermissions perm) {
		userPermissions.add(perm);
	}
	
	public void removeUserPermission(GlobalPermissions perm) {
		userPermissions.remove(perm);
	}
	
	public boolean UserHasPermission(GlobalPermissions perm) {
		if(userPermissions.contains(perm))
			return true;
		
		return false;
	}

}
