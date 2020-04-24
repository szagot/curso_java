package enttities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private String title;
	private String content;
	private Integer likes;

	private List<Comment> comments = new ArrayList<>();

	public Post() {
	}

	public Post(Date moment, String title, String content, Integer likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * Adiciona comentário
	 * 
	 * @param comment
	 */
	public void addComment(Comment comment) {
		comments.add(comment);
	}

	/**
	 * Remove comentário
	 * 
	 * @param comment
	 */
	public void removeComment(Comment comment) {
		comments.remove(comment);
	}

	/**
	 * Exemplo de toString com o StringBuilder
	 */
	public String toString() {

		StringBuilder sb = new StringBuilder();
		// Título
		sb.append(title + '\n');
		// Quantidade de likes e data do Post
		sb.append(likes);
		sb.append(" Likes - ");
		sb.append(getSdf().format(moment) + "\n\n");
		// Conteúdo
		sb.append(content + "\n\n");
		sb.append("Comentários:\n");
		for(Comment comment : comments) {
			sb.append("  • " + comment.getText() + '\n');
		}
		sb.append("\n------------\n");
		
		return sb.toString();
		
	}

}
