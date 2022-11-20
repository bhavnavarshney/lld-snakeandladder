package com.game;

import com.game.model.Dice;
import com.game.model.Player;
import com.game.model.Position;
import com.game.service.BoardService;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Dice dice = new Dice(3);
        Queue<Player> nextTurn = new LinkedList<>();
        Player p1 = new Player("A");
        Player p2 = new Player("B");
        nextTurn.offer(p1);
        nextTurn.offer(p2);
        List<Position> snakes = new ArrayList<>();
        Position pos1 = new Position(20, 3);
        Position pos2 = new Position(42, 12);
        Position pos3 = new Position(55, 44);
        Position pos4 = new Position(77, 11);
        Position pos5 = new Position(89, 33);
        Position pos6 = new Position(94, 2);
        snakes.add(pos1);
        snakes.add(pos2);
        snakes.add(pos3);
        snakes.add(pos4);
        snakes.add(pos5);
        snakes.add(pos6);
        List<Position> ladders = new ArrayList<>();
        Position pos7 = new Position(7, 49);
        Position pos8 = new Position(24, 56);
        Position pos9 = new Position(73, 97);
        Position pos10 = new Position(80, 90);
        ladders.add(pos7);
        ladders.add(pos8);
        ladders.add(pos9);
        ladders.add(pos10);
        Map<String, Integer> playersPosition = new HashMap<>();
        playersPosition.put("A", 0);
        playersPosition.put("B", 0);
        BoardService boardService = new BoardService(dice, nextTurn, snakes, ladders, playersPosition, 100);
        boardService.playGame();
    }
}
