package interfaces;

import model.Usuario;

public interface IUsuario {

	Usuario validate(String username, String password);
    void createUser(Usuario user);
    Usuario findUserById(int id);
    void updateUser(Usuario user);
    void deleteUser(int id);
	
} //fin interface
