package model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Comment {
<<<<<<< HEAD

=======
>>>>>>> 36ae72f85d95d750fad770d6dd79e70dbbf6bf47
	private int userId;
	private int boardId;
	private String context;
}
