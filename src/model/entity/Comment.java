package model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Comment {
	private int id;
	private int userId;
	private int boardId;
	private String context;
}
