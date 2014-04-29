package org.pht.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Users {
    private HashMap<String, User> users;
	private File file;
	
	public Users() throws ClassNotFoundException, IOException {
		String root = System.getProperty("user.home") + "/pht/usrdata";
		Files.createDirectories(Paths.get(root));
		file = Paths.get(root + "data.txt").toFile();
		if (!file.exists())
			file.createNewFile();
		this.loadUsers();
	}
	
	public boolean loadUsers() throws IOException, ClassNotFoundException, EOFException {
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			users = (HashMap<String, User>) in.readObject();
		} catch (EOFException e) {
			users = new HashMap<String, User>();
			throw new EOFException;
		} finally {
			if (in != null) in.close();
			if (fileIn != null) fileIn.close();
		}
	}
	
	public void saveUsers() throws IOException {
		try {
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(users);
		} catch (Exception e) {
			
		}
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
