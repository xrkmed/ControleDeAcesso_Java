package Internal;

public interface UserInterface {

	//Interface para controle das funcoes que um usuario pode ter
	public boolean hasPermission(GlobalPermissions permission); //Verificar se o mesmo tem permissao
	public long getUserUniqueId(); // Id do cracha do usuario
	public String getUserIdentificator(); // Nome do usuario
	public void addPermission(GlobalPermissions perm); // Rodar apenas em casos de promocoes hierarquicas ou carregamento da database;
	
}
