public class MatrixMinPath{


	private int MIN_PATH_LEN = Integer.MAX_VALUE;
	
	private Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

	public boolean isCanPass(int posX, int posY,int[][] board){
		if (posX >= 0 && posX < board.length && posY < board[0].length && posY >= 0        
				&& board[posX][posY] != -1){
			if (board[posX][posY] == 0)   
				return true;
		}
		return false;
	}

	public void shortestPath(Position start, Position end, int[][] board){
		if(board == null || board.length == 0 || start == null || end == null)
			return;
		else{
			Stack<Position> stack = new Stack<Position>();
			board[start.x][start.y] = 1;
			stack.push(start);
			shortestPath(stack, start, end, board);
			for(Map.Entry<Integer, List<String>> entry : map.entrySet()){
				List<String> list = entry.getValue();
				for(int i = 0; i < list.size(); i++){
					System.out.println(list.get(i));
				}
				break;
			}
			System.out.print("MIN VALUE=" + MIN_PATH_LEN);
		}
	}

	public void shortestPath(Stack<Position> path, Position start, Position end, int[][] board){

		if(start.x == end.x && start.y == end.y){
			if(path.size() <= MIN_PATH_LEN){
				MIN_PATH_LEN = path.size();
				Stack<Position> clonePath = (Stack<Position>)path.clone();
				if(map.containsKey(MIN_PATH_LEN)){
					List<String> list = map.get(MIN_PATH_LEN);
					list.add(getPath(clonePath));
					map.put(MIN_PATH_LEN, list);
				}else{
					List<String> list = new ArrayList<String>();
					list.add(getPath(clonePath));
					map.put(MIN_PATH_LEN, list);
				}
			}
		}else{
			int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
			for(int k = 0; k < directions.length; k++){
				int cur_x = start.x + directions[k][0];
				int cur_y = start.y + directions[k][1];
				Position cur = new Position(cur_x, cur_y);
				if(isCanPass(cur_x, cur_y, board)){
					path.push(cur);
					board[cur_x][cur_y] = 1;
					shortestPath(path, cur, end, board);
					path.pop();
					board[cur_x][cur_y] = 0;
				}
			}
		}

	}

	public String getPath(Stack<Position> path){
		String result = "";
		while(!path.isEmpty()){
			Position p = path.pop();
			result += p.toString() + " ";
		}
		return result;
	}


}
