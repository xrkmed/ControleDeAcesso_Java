package Internal;

import java.util.Objects;

public class GlobalPermissions {
	
	private long permissionId;
	private String permissionDescription;
	
	public GlobalPermissions() {
		
	}
	
	public GlobalPermissions(long permId, String permDesc) {
		this.permissionDescription = permDesc;
		this.permissionId = permId;
	}
	
	public long getPermissionId() {
		return permissionId;
	}
	
	public String getPermissionDescription()
	{
		return permissionDescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(permissionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GlobalPermissions other = (GlobalPermissions) obj;
		return permissionId == other.permissionId;
	}
	
	
	
}
