package org.pht.user;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Users {
	private HashMap<String, User> users;
	private File file;

	public Users() throws ClassNotFoundException, IOException, EOFException {
		String root = System.getProperty("user.home") + "/pht/usrdata";
		Files.createDirectories(Paths.get(root));
		file = Paths.get(root + "data.txt").toFile();
		if (!file.exists())
			file.createNewFile();
		this.loadUsers();
	}

	public void loadUsers() throws IOException, ClassNotFoundException, EOFException {
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		try {
			fileIn = new FileInputStream(file);
			in = new ObjectInputStream(fileIn);
			users = (HashMap<String, User>) in.readObject();
		} catch (EOFException e) {
			users = new HashMap<String, User>();
			throw new EOFException();
		} finally {
			if (in != null) in.close();
			if (in != null) fileIn.close();
		}
	}

	public void saveUsers() throws IOException {
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;
		try {
			fileOut = new FileOutputStream(file);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(users);
		} catch (Exception e) {

		} finally {
			if (out != null) out.close();
			if (fileOut != null) fileOut.close();
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

	public void createUser(String name) throws ClassNotFoundException,
			IOException {
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
