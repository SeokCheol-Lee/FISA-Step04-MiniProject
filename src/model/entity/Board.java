package model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Board {
	private int boardId;
	private int catId;
	private int userId;
	private String name;
	private String context;
	private int viewCount;
	private String image;
}
