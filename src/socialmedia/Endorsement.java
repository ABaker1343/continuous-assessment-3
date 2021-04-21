package socialmedia;

public class Endorsement extends Post{
    
    Post originalPost;
    
    Endorsement(Account poster, Post originalPost){
        super(poster, originalPost.getContent());
        setOriginalPost(originalPost);
    }

    public void setOriginalPost(Post originalPost) {
        this.originalPost = originalPost;
    }

    @Override
    protected void setContent(String content){
        this.content = "EP@" + this.originalPost.getAccountHandle() + this.originalPost.getContent();
    }
}
