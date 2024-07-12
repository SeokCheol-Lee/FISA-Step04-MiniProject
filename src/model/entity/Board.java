package model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Board {
	private int id;
	private int catId;
	private int userId;
	private String name;
	private String context;
	private int viewCount;
	private String image;
	
	
	
	
	
	//서비스에 static으로 리스트로 저장
}
