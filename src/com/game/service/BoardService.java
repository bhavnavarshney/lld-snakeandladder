package com.game.service;

import com.game.model.Dice;
import com.game.model.Player;
import com.game.model.Position;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BoardService {
    Dice dice;
    Queue<Player> nextTurn;
    List<Position> snakes;
    List<Position> ladders;
    Map<String, Integer> playerPosition;
    int boardSize;

    public BoardService(Dice dice, Queue<Player> nextTurn, List<Position> snakes, List<Position> ladders, Map<String, Integer> playerPosition, int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerPosition = playerPosition;
        this.boardSize = boardSize;
    }

    public void playGame(){
        while(nextTurn.size()>0){
            Player currentPlayer = nextTurn.poll();
            int position = playerPosition.get(currentPlayer.getName());
            int steps = dice.rollDice();
            int possibleNextCell = position+steps;
            if(possibleNextCell>boardSize){
                nextTurn.offer(currentPlayer);
            }else if(position==boardSize){
                System.out.printf("\n Congratulations! Player: %s won the game", currentPlayer.getName());
                return;
            }else{
                int[] nextPosition = new int[1];
                nextPosition[0] = possibleNextCell;
                snakes.forEach(snake->{
                    if(snake.getStart()==possibleNextCell){
                        nextPosition[0] = snake.getEnd();
                    }
                });
                if(nextPosition[0]!=possibleNextCell){
                    System.out.printf("\n Player %s bitten by snake", currentPlayer.getName());
                }

                ladders.forEach(ladder->{
                    if(ladder.getStart()==possibleNextCell){
                        nextPosition[0] = ladder.getEnd();
                    }
                });
                if(nextPosition[0]!=possibleNextCell){
                    System.out.printf("\n Player %s got ladder", currentPlayer.getName());
                }

                if(nextPosition[0]==boardSize){
                    System.out.printf("\n Congratulations! Player: %s won the game", currentPlayer.getName());
                    return;
                }else{
                    playerPosition.put(currentPlayer.getName(), nextPosition[0]);
                    System.out.printf("\n Player %s is at %d position", currentPlayer.getName(), nextPosition[0]);
                    nextTurn.offer(currentPlayer);
                }
            }
        }
    }
}
