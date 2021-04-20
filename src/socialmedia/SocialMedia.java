package socialmedia;

import java.io.IOException;
import java.util.ArrayList;

/**
 * BadSocialMedia is a minimally compiling, but non-functioning implementor of
 * the SocialMediaPlatform interface.
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class SocialMedia implements SocialMediaPlatform {

	ArrayList<Account> accounts;
	ArrayList<Post> posts;

	/**
	 * constructor
	 */
	SocialMedia(){
		accounts = new ArrayList<Account>();
		posts = new ArrayList<Post>();
	}

	@Override
	public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException {
		// TODO Auto-generated method stub
		if (handleExists(handle)){
			throw new IllegalHandleException();
		}
		if (isValidHandle(handle)){
			throw new InvalidHandleException();
		}
		Account newAccount = new Account(handle);
		accounts.add(newAccount);
		return newAccount.getID();
	}

	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		// TODO Auto-generated method stub
		Account newAccount = new Account(handle, description);
		accounts.add(newAccount);
		return newAccount.getID();
	}

	@Override
	public void removeAccount(int id) throws AccountIDNotRecognisedException {
		// TODO Auto-generated method stub
		for (Account a : accounts){
			if (a.getID() == id){
				accounts.remove(a);
				return;
			}
		}
		throw new AccountIDNotRecognisedException();
	}

	@Override
	public void removeAccount(String handle) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub
		accounts.remove(getAccountByHandle(handle));
		throw new HandleNotRecognisedException();
	}

	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
			throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
		// TODO Auto-generated method stub
		if (!handleExists(oldHandle)){
			throw new HandleNotRecognisedException();
		}
		if (handleExists(newHandle)){
			throw new IllegalHandleException();
		}
		if (isValidHandle(newHandle)){
			throw new InvalidHandleException();
		}

		getAccountByHandle(oldHandle).updateHandle(newHandle);

	}

	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub
		if (!handleExists(handle)){
			throw new HandleNotRecognisedException();
		}
		getAccountByHandle(handle).updateDescription(description);

	}

	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub
		if (!handleExists(handle)){
			throw new HandleNotRecognisedException();
		}
		return getAccountByHandle(handle).showAccount();
	}

	@Override
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int endorsePost(String handle, int id)
			throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub

	}

	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringBuilder showPostChildrenDetails(int id)
			throws PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfAccounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalOriginalPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalEndorsmentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCommentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMostEndorsedPost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMostEndorsedAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void erasePlatform() {
		// TODO Auto-generated method stub

	}

	@Override
	public void savePlatform(String filename) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	private boolean handleExists(String handle){
		for (Account a : accounts){
			if (a.getHandle().equals(handle)){
				return true;
			}
		}
		return false;
	}

	private boolean isValidHandle(String handle){
		//no whitespace, no empty, no more than 30 characters
		if (handle.isEmpty()){
			return false;
		}
		if (handle.contains(" ")){
			return false;
		}
		if (handle.length() > 30){
			return false;
		}
		return true;
	}

	private Account getAccountByHandle(String handle){
		for (Account a : accounts){
			if (a.getHandle().equals(handle)){
				return a;
			}
		}
		return null;
	}
}
