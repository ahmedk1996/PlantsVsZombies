package Tests;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Controller.TimeLine;
import Model.Game;
import junit.framework.TestCase;

public class TimeLineTest extends TestCase{
	TimeLine tl ;
	Game game ;
	@Before
	public void setUp() {
		tl = new TimeLine();
		game= new Game();
	}

	@Test
	//public void addNext(Game game)
	public void test() {
		
		tl.addNext(game);
		
		assertTrue("What is stored in game should be game",tl.undo() instanceof Game);
	}
	
	@Test
	//public boolean isUndoAvailable()
	public void test1() {
		tl = new TimeLine();
		
		assertFalse("should return false",tl.isUndoAvailable());
	}
	
	@Test
	//public boolean isRedoAvailable()
	public void test2() {
		tl = new TimeLine();
		
		assertFalse("should return false",tl.isRedoAvailable());
	}
	
	@Test
	//public Game undo()
	public void test3() {
		tl = new TimeLine();
		game= new Game();
		
		tl.addNext(game);
		
		assertTrue("It should return the same game",tl.undo() instanceof Game);
	}
	
	@Test
	//public Game undo()
	public void test4() {
		tl = new TimeLine();
		game= new Game();
		
		tl.addNext(game);
		tl.addNext(game);
		tl.addNext(game);
		
		Game temp = tl.undo();
		assertTrue("It should return the game",tl.redo() instanceof Game);
		
	}
	
}
