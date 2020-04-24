package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import enttities.Comment;
import enttities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		// Post 1
		Post p1 = new Post(Post.getSdf().parse("21/06/2018 13:05:44"), "Viagem a Nova Zelandia",
				"Vou visitar esse país maravilhoso!", 12);

		// Comentários do post 1
		p1.addComment(new Comment("Tenha uma boa viagem!"));
		p1.addComment(new Comment("Uau! Isso é maravilhoso!"));
		
		System.out.println(p1);
		
		// Post 2
		Post p2 = new Post(Post.getSdf().parse("28/07/2018 23:14:19"), "Boa noite, Galera!",
				"Vejo vocês amanhã!", 5);

		// Comentários do post 1
		p2.addComment(new Comment("Boa noite!"));
		p2.addComment(new Comment("May the Force be with you!"));

		System.out.println(p2);

	}

}
