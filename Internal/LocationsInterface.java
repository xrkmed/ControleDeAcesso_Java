package Internal;

import java.util.ArrayList;

import Controllers.UserEntity;

public interface LocationsInterface {

	public void addNeededPermission(GlobalPermissions perm); // Adicionar uma permissao necessaria para entrar no local
	public void removePermission(GlobalPermissions perm);
	public boolean userCanJoin(UserInterface user); // Verificar se determinado usuario pode entrar
	public ArrayList<UserInterface> getUsers(); // Retornar todos os usuarios que estao no local
	public boolean onUserJoin(UserInterface user); // Evento de requisicao booleana quando um usuario tenta entrar, utilizar esta funcao para eventuais problemas em uma localizacao, chao molhado, etc
}
