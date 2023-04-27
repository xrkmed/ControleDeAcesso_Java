package Internal;

import java.util.ArrayList;

import Controllers.UserEntity;

public interface AccessPointInterface {

	public ArrayList<UserInterface> getUsers(); // Retornar os usuarios no ponto de acesso
	public boolean addUser(UserInterface user); // Adicionar usuario no ponto de acesso
	public String getName(); // Nome do Ponto de Acesso (Simplesmente o nome da localizacao)
	
}
