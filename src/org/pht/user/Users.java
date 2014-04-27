package org.pht.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

class Users {
    // Files and things
	private static final long serialVersionUID = 4669256805791553941L;
	
	private HashMap<String, User> users;
	private File file;
	
	public Users() {
		users = new HashMap<String, User>();
	}
	
	public boolean loadUsers() throws IOException, ClassNotFoundException {
		String root = System.getProperty("user.home") + "/pht/usrdata";
		Files.createDirectories(Paths.get(root));
		file = Paths.get(root + "data.txt").toFile();
		if (!file.exists())
			file.createNewFile();
		FileInputStream fileIn = new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		users = (HashMap<String, User>) in.readObject();
		if (users == null) return false;
		else return true;
	}
	
	public User user(String name) {
		return users.get(name);
	}
	
	public void deleteUser(String name) {
		users.remove(name);
	}
	
	public boolean userExists(String name) {
		return users.containsKey(name);
	}
	
	public void createUser(String name) throws ClassNotFoundException, IOException {
		User tmp = new User(name);
		users.put(name, tmp);
	}

	public HashMap<String, User> getUsers() {
		return users;
	}

	public void setUsers(HashMap<String, User> users) {
		this.users = users;
	}
}
