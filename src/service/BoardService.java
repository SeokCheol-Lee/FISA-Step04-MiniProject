package service;

import java.util.HashMap;
import java.util.Set;

import model.entity.Board;
public class BoardService {
	private final int ITEM_PER_PAGE = 5;
	
	private static BoardService instance = new BoardService();
		
	public static BoardService getInstance() {
		return instance;
	}
	
	public static int idCount = 0;
	public static HashMap<Integer, Board> boardMap = new HashMap<Integer, Board>();
	
	public HashMap<Integer, Board> getBoardAll() {
		return boardMap;
	}
	
	// 게시판 생성
	public void createBoard(int id, int catId, int userId, String name, String context, int viewCount, String image) {
		if (name == null || context == null) {
			throw new IllegalArgumentException("제목과 내용을 입력하세요");
		}
		Board b = new Board(id, catId, userId, name, context, viewCount, image);
		boardMap.put(idCount, b);
		idCount ++;
	}
	
	
	// 게시판 페이지로 받기
	public HashMap<Integer, Board> getBoardInPage(int page) {
		HashMap<Integer, Board> allBoardMap = getBoardAll();
		return getCalculatedPage(page, allBoardMap);
	}
	
	private HashMap<Integer, Board> getCalculatedPage(int page, HashMap<Integer, Board> allBoardMap) {
        HashMap<Integer, Board> pageBoardMap = new HashMap<>();

        if (page < 1) {
        	throw new IllegalArgumentException("유효한 페이지 번호를 입력하세요");
        } else {
            int boardQuantity = allBoardMap.size();
            int pageQuantity = (int) Math.ceil(((double) boardQuantity / ITEM_PER_PAGE));

            if (page > pageQuantity) {
            	throw new IllegalArgumentException("유효한 페이지 번호를 입력하세요");
            }

            int start = (page - 1) * ITEM_PER_PAGE;
            int end = Math.min(start + ITEM_PER_PAGE, boardQuantity);

            // 페이지 범위에 해당하는 게시물을 pageBoardMap에 추가
            Set<Integer> keys = allBoardMap.keySet();
            int index = 0;

            for (Integer key : keys) {
                if (index >= start && index < end) {
                    pageBoardMap.put(key, allBoardMap.get(key));
                }
                
                index++;
                if (index >= end) {
                    break;
                }
            }

            return pageBoardMap;
        }
    }
	
	
	
	public Board getBoardByTitle(String title) {
        Set<Integer> keys = instance.boardMap.keySet();

        for (Integer key : keys) {
            Board searchedBoard = instance.boardMap.get(key);
            if (searchedBoard.getName().equals(title)) {
                return searchedBoard;
            }
        }
        return null;
    }
	
	public Board getBoardById(int id) {
		if (instance.boardMap.get(id) != null) {
			return instance.boardMap.get(id);
		}
		else {
			throw new IllegalArgumentException("id에 해당하는 board가 존재하지 않습니다.");
		}
	}
	
	public void updateBoardName(int boardId, String boardName) {
		Board board = getBoardById(boardId);
		if(board == null) {
			return;
		}
		board.setName(boardName);
		boardMap.put(boardId,board);
	}
	
	public void updateBoardContext(int boardId, String context) {
		Board board = getBoardById(boardId);
		if(board == null) {
			return;
		}
		board.setContext(context); 
		boardMap.put(boardId,board);
	}
	
	public void updateImage(int boardId, String image) {
		Board board = getBoardById(boardId);
		if(board == null) {
			return;
		}
		board.setImage(image);
		boardMap.put(boardId,board);
	}
	
	public void addViewCount(Board board) {
		int viewCount = board.getViewCount();
		int boardId = board.getId();
		board.setViewCount(viewCount + 1);
		boardMap.put(boardId, board);
	}
	
	public void deleteBoard(int boardId) {
		Board board = getBoardById(boardId);
		if(board == null) {
			return;
		}
		board = null;
		boardMap.remove(boardId);
	}
}


