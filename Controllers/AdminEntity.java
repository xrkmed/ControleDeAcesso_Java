package Controllers;

import Internal.GlobalPermissions;

public final class AdminEntity extends UserEntity {

	public AdminEntity() {
		
	}
	
	public AdminEntity(long userUniqueId, String userIdentificator) {
		super(userUniqueId, userIdentificator);
	}
	
	@Override
	public boolean hasPermission(GlobalPermissions permission) {
		return true;
	}
	
	
}
