package Exceptions;

import Controllers.UserEntity;

public class UserNotFound extends RuntimeException {
	
	public UserNotFound(UserEntity user) {
		super("Ocorreu um erro no sistema: o usuario " + user + " nao foi encontrado.");
	}

}
