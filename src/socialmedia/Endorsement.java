package socialmedia;

public class Endorsement extends Post{
    
    Post originalPost;
    
    Endorsement(Account poster, Post originalPost){
        super(poster, originalPost.getContent());
        setOriginalPost(originalPost);
        setEndorsementContent();
    }

    /**
     * sets the post that this Endorsement is Endorsing
     * @param originalPost
     */
    public void setOriginalPost(Post originalPost) {
        this.originalPost = originalPost;
    }

    /**
     * creates the endorsement content
     */
    protected void setEndorsementContent(){
        this.content = "EP@" + this.originalPost.getAccountHandle() +": "+ this.originalPost.getContent();
    }

    @Override
    public String show(int indent){
        String outString = "";
        
        for (int i = 0; i < indent; i++){
            outString += "    ";
        }
        outString += "ID: " + postID + "\n";
        for (int i = 0; i < indent; i++){
            outString += "    ";
        }
        outString += "Account: " + accountHandle + "\n";
        for (int i = 0; i < indent; i++){
            outString += "    ";
        }
        outString += content;

        return outString;
    }
}
