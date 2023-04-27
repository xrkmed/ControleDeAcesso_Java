
# Sistema de Controle de Acesso

Um sistema de controle de acesso de funcionários com IDs e permissões para entrar em salas específicas tem como finalidade garantir a segurança e proteção de uma organização ou empresa.

Através desse sistema, é possível limitar o acesso de funcionários a certas áreas ou salas que contenham informações ou bens valiosos, garantindo que somente pessoas autorizadas possam entrar nessas áreas.

Cada funcionário recebe um ID único, que é registrado no sistema, juntamente com as suas permissões de acesso específicas. Essas permissões podem ser ajustadas de acordo com as necessidades da organização e podem ser revogadas a qualquer momento.

Dessa forma, é possível manter um controle rigoroso sobre quem entra e sai de certas áreas, reduzindo os riscos de roubo, vandalismo ou violação de dados sensíveis. O sistema também ajuda a monitorar e registrar as atividades dos funcionários, o que pode ser útil para fins de auditoria ou investigação em caso de incidentes de segurança.


## Autores

- [@xrkmed](https://www.github.com/xrkmed)


## Funcionalidades

- Controle de acesso em tempo real de funcionarios
- Gerencia de permissoes para acesso em ambientes
- Cada funcionario possui um ID unico com as suas devidas permissoes
- Java


## Registros do sistema

![App Screenshot](https://i.imgur.com/N3ubQn9.png)

## Uso/Testes

```
		//Registrar permissoes
		GlobalPermissions permSalaPrincipal = new GlobalPermissions(1, "Acessar a sala principal");
		
		//Registrar localizacoes
		Locations locSalaPrincipal = new Locations("Sala Principal");
		locSalaPrincipal.addNeededPermission(permSalaPrincipal);
		
		
		//Registrar pontos de acessos
		PontoDeAcesso point1 = new PontoDeAcesso(1, locSalaPrincipal);
		
		
		//Registrar usuarios
		UserEntity user = new UserEntity(100000, "John Friedrich");
		
		//Usuario de Admin tem permissoa para entrar em todas as salas
		AdminEntity admin = new AdminEntity(100001, "CEO Krugans Martin");
		
		//Adicionar permissoes aos usuarios
		user.addPermission(permSalaPrincipal);
		
		//Simular entrada do usuario
		point1.addUser(user);
		
		//Log
		System.out.println("> Log: Existem " + point1.getUsers().size() + " pessoas no ponto de acesso: " + point1.getName());
		
		//Simular travessia do usuario para um local que ele nao tem acesso
		GlobalPermissions permSalaGerencia = new GlobalPermissions(2, "Acessar a sala da gerencia");
		Locations locSalaGerencia = new Locations("Sala da Gerencia");
		locSalaGerencia.addNeededPermission(permSalaGerencia);
		
		PontoDeAcesso point2 = new PontoDeAcesso(2, locSalaGerencia);
		if(point2.addUser(user)) {
			System.out.println("O Usuario " + user.getUserIdentificator() + " entrou na " + locSalaGerencia);
		}else {
			System.out.println("O Usuario " + user.getUserIdentificator() + " esta tentando acessar uma sala (" + locSalaGerencia + ") que ele nao tem acesso.");
		}
		
		//Simular travessia do usuario para um local que ele tenha acesso
		GlobalPermissions permSalaFaxina = new GlobalPermissions(3, "Acessar a sala da faxina");
		Locations locSalaFaxina = new Locations("Sala da Faxina");
		locSalaFaxina.addNeededPermission(permSalaFaxina);
		
		PontoDeAcesso point3 = new PontoDeAcesso(3, locSalaFaxina);
		
		user.addPermission(permSalaFaxina);
		
		if(point3.addUser(user)) {
			System.out.println("O Usuario " + user.getUserIdentificator() + " entrou na " + locSalaFaxina);
		}else {
			System.out.println("O Usuario " + user.getUserIdentificator() + " esta tentando acessar uma sala (" + locSalaFaxina + ") que ele nao tem acesso.");
		}
		
		if(point2.addUser(admin)) {
			System.out.println("O Usuario " + admin.getUserIdentificator() + " entrou na " + point2.getName());
		}else {
			System.out.println("O Usuario " + admin.getUserIdentificator() + " esta tentando acessar uma sala (" + point2.getName()+ ") que ele nao tem acesso.");
		}
		
		//Log final
		System.out.println("> Log: Existem " + point1.getUsers().size() + " pessoas no ponto de acesso: " + point1.getName());
		System.out.println("> Log: Existem " + point2.getUsers().size() + " pessoas no ponto de acesso: " + point2.getName());
		System.out.println("> Log: Existem " + point3.getUsers().size() + " pessoas no ponto de acesso: " + point3.getName());
```
