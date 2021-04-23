import java.io.IOException;

import socialmedia.AccountIDNotRecognisedException;
import socialmedia.HandleNotRecognisedException;
import socialmedia.SocialMedia;
import socialmedia.IllegalHandleException;
import socialmedia.InvalidHandleException;
import socialmedia.InvalidPostException;
import socialmedia.NotActionablePostException;
import socialmedia.PostIDNotRecognisedException;
import socialmedia.SocialMediaPlatform;

/**
 * A short program to illustrate an app testing some minimal functionality of a
 * concrete implementation of the SocialMediaPlatform interface -- note you will
 * want to increase these checks, and run it on your SocialMedia class (not the
 * BadSocialMedia class).
 *
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class SocialMediaPlatformTestApp {

	/**
	 * Test method.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		System.out.println("The system compiled and started the execution...");

		SocialMediaPlatform platform = new SocialMedia();

		assert (platform.getNumberOfAccounts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalOriginalPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalCommentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalEndorsmentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";

		Integer id;
		Integer id2;
		Integer postID;
		try {
			id = platform.createAccount("my_handle");
			id2 = platform.createAccount("pewdiepie");
			assert (platform.getNumberOfAccounts() == 2) : "number of accounts registered in the system does not match";

			//platform.removeAccount(id);
			//assert (platform.getNumberOfAccounts() == 0) : "number of accounts registered in the system does not match";

			postID = platform.createPost("my_handle", "posting");
			platform.commentPost("my_handle", postID, "I hate this guy!");
			platform.commentPost("pewdiepie", postID, "Something mean");
			System.out.println(platform.showPostChildrenDetails(postID));

			int endorsementID = platform.endorsePost("pewdiepie", postID);
			System.out.println(platform.showIndividualPost(endorsementID));

			platform.deletePost(postID);
			System.out.println(platform.showPostChildrenDetails(postID));

			platform.savePlatform("firstPlatform");
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			platform.loadPlatform("firstPlatform");

			System.out.println(platform.showPostChildrenDetails(postID));

		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
		} catch (InvalidHandleException e) {
			assert (false) : "InvalidHandleException thrown incorrectly";
		} //catch (AccountIDNotRecognisedException e) {
			//assert (false) : "AccountIDNotRecognizedException thrown incorrectly";
		//} 
		catch(HandleNotRecognisedException e) {
			assert(false) : "HandleNotRecognisedException thrown incorrectly";
		} catch(InvalidPostException e) {
			assert(false) : "InvalidPostException thrown incorrectly";
		} catch (PostIDNotRecognisedException e){
			assert(false) : "PostIDNotRecognisedException thrown incorrectly";
		} catch (NotActionablePostException e){
			assert(false) : "NotActionablePostException thrown incorrectly";
		} catch (IOException e){
			System.out.println(e.getMessage());
			assert(false) : "IOException";
		} catch (InterruptedException e){
			System.out.println(e.getMessage());
			assert(false) : "InteruptedException";
		} catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
			assert(false) : "ClassNotFoundException";
		}
		

	}

}
