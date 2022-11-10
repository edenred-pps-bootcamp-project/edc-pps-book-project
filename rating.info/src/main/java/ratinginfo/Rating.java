package ratinginfo;

public class Rating implements Comparable{
    private long ratingId = 0;
    private long bookId = 0;
    private long userId = 0;
    private int ratingValue = 0;


    public Rating(long bookId, long userId, int rating) {
        this.ratingId = bookId * 10000 + userId;
        this.bookId = bookId;
        this.userId = userId;
        this.ratingValue = rating;
        //getAverageRating();
    }

    @Override
    public String toString() {
        return "Rating{" +
                "Rating ID=" + ratingId +
                ", Book ID=" + bookId +
                ", User ID=" + userId +
                ", Rating Value=" + ratingValue +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Rating otherRating = (Rating)o;
        return (int)(this.ratingId-otherRating.ratingId);
    }

    public long getRatingId() {
        return ratingId;
    }

    public long getBookId() {
        return bookId;
    }

    public long getUserId() {
        return userId;
    }

    public int getRating() {
        return ratingValue;
    }
}
