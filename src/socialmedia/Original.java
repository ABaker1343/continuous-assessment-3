package socialmedia;

import java.util.ArrayList;

public class Original extends Post{
    ArrayList<Comment> comments;
    ArrayList<Endorsement> endorsements;

    Original(Account poster, String message){
        super(poster, message);
        comments = new ArrayList<Comment>();
        endorsements = new ArrayList<Endorsement>();
    }

    @Override
    public void addComment(Comment comment){
        comments.add(comment);
    }

    @Override
    public void addEndorsements(Endorsement endorsement){
        endorsements.add(endorsement);
    }

    @Override
    public void deleteEndorsements(){
        endorsements.removeAll(endorsements);
    }

    @Override
    public ArrayList<Comment> getComments() {
        // TODO Auto-generated method stub
        return comments;
    }
}
