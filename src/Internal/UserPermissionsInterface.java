package Internal;

public interface UserPermissionsInterface {
	
	public void addUserPermission(GlobalPermissions perm);
	public void removeUserPermission(GlobalPermissions perm);
	public boolean UserHasPermission(GlobalPermissions perm);

}
